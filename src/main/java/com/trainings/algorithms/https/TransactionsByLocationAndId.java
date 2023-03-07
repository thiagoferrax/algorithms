package com.trainings.algorithms.https;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

class Transaction {
    private Integer locationId;
    private BigDecimal amount;
    private String txnType;
    private String ip;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Transaction [locationId=" + locationId + ", amount=" + amount + ", txnType=" + txnType + ", ip=" + ip + "]";
    }

}

class Result {

    private static final Locale CURRENT_LOCALE = Locale.US;
    private static final String TOTAL_PAGES = "total_pages";
    private static final int FIRST_PART = 0;
    private static final int VALUE = 2;
    private static final int KEY = 1;
    private static final String CREDIT = "credit";
    private static final String REQUEST_METHOD = "GET";
    private static final String IP = "ip";
    private static final String AMOUNT = "amount";
    private static final String TXN_TYPE = "txnType";
    private static final String ID = "id";
    private static final String URL = "https://jsonmock.hackerrank.com/api/transactions/search?userId=";
    private static final String TRANSACTIONS_REGEXP = "\"(\\w+)\":(?:\"?((?:\\d+\\.?){1,4}|\\w+|\\$(?:\\d+)?,?\\d+\\.?\\d+)\"?),?";
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    private static final int DECIMALS = 2;

    private static BigDecimal rounded(BigDecimal number) {
        return number.setScale(DECIMALS, ROUNDING_MODE);
    }

    /*
     * Complete the 'getTransactions' function below.
     *
     * The function is expected to return an INTEGER. The function accepts following
     * parameters: 1. INTEGER userId 2. INTEGER locationId 3. INTEGER netStart 4.
     * INTEGER netEnd
     *
     * https://jsonmock.hackerrank.com/api/transactions/search?userId=
     */
    public static int getTransactions(int userId, int locationId, int netStart, int netEnd) {
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("userId: " + userId + ", locationId: " + locationId + ", netStart: " + netStart + ", netEnd: " + netEnd);
        System.out.println("---------------------------------------------------------------------------------------");

        int amountsSum;

        try {
            List<Transaction> transactions = getTransactionsByUserId(userId);
            amountsSum = calculateAmountSum(locationId, netStart, netEnd, transactions);
        } catch (IOException e) {
            e.printStackTrace();
            amountsSum = 0;
        }

        return amountsSum;
    }

    private static int calculateAmountSum(int locationId, int netStart, int netEnd, List<Transaction> transactions) {
        BigDecimal amountsSum = rounded(BigDecimal.ZERO);
        for (Transaction transaction : transactions) {
            if (transaction.getLocationId().intValue() == locationId
                    && isIpInNetInterval(transaction.getIp(), netStart, netEnd)) {
                if (transaction.getTxnType().equals(CREDIT)) {
                    amountsSum = rounded(amountsSum.add(transaction.getAmount()));
                } else {
                    amountsSum = rounded(amountsSum.subtract(transaction.getAmount()));
                }
            }
        }

        amountsSum.setScale(DECIMALS, ROUNDING_MODE);
        BigDecimal scaled = amountsSum.setScale(0, RoundingMode.HALF_DOWN);

        System.out.println("\nAmount value (currency) => " + NumberFormat.getCurrencyInstance(CURRENT_LOCALE).format(amountsSum));
        System.out.println("Amount value (integer)  => " + scaled.intValue());
        System.out.println("---------------------------------------------------------------------------------------\n");

        return scaled.intValue();
    }

    private static boolean isIpInNetInterval(String ip, int netStart, int netEnd) {
        int firstPartIpAddress = Integer.valueOf(ip.split("\\.")[FIRST_PART]);
        return firstPartIpAddress >= netStart && firstPartIpAddress <= netEnd;
    }

    /**
     * Return the total number of pages of the query.
     *
     * @param json         Receives a json to be parsed in a list of transactions.
     * @param transactions All parsed transactions will be added in this list.
     * @return The total number of pages.
     */
    private static Integer parseJsonToTransationList(String json, List<Transaction> transactions) {

        Pattern pattern = Pattern.compile(TRANSACTIONS_REGEXP);
        Matcher matcher = pattern.matcher(json);

        Transaction transaction = null;
        Integer totalPages = 0;

        while (matcher.find()) {
            String key = matcher.group(KEY);
            String value = matcher.group(VALUE);

            if (ID.equals(key)) {
                if (transaction == null) {
                    transaction = new Transaction();
                } else {
                    transaction.setLocationId(Integer.valueOf(value));
                }
            } else if (TXN_TYPE.equals(key)) {
                transaction.setTxnType(value);
            } else if (AMOUNT.equals(key)) {
                transaction.setAmount(parseAmount(value));
            } else if (IP.equals(key)) {
                transaction.setIp(value);
                transactions.add(transaction);

                System.out.println(transaction);

                transaction = null;
            } else if (TOTAL_PAGES.equals(key)) {
                totalPages = Integer.valueOf(value);
            }

        }

        return totalPages;
    }

    private static BigDecimal parseAmount(String value) {
        BigDecimal amount;

        try {
            Number number = NumberFormat.getCurrencyInstance(CURRENT_LOCALE).parse(value);
            amount = rounded(new BigDecimal(number.toString()));
        } catch (ParseException e) {
            amount = rounded(BigDecimal.ZERO);
            e.printStackTrace();
        }
        return amount;
    }

    private static List<Transaction> getTransactionsByUserId(int userId) throws IOException {
        Integer page = 1, totalPages = 1;

        List<Transaction> transactions = new ArrayList<Transaction>();

        while (page <= totalPages) {
            String json = getTransactionsJsonByUserIdAndPage(userId, page);

            List<Transaction> transactionsPerPage = new ArrayList<Transaction>();
            totalPages = parseJsonToTransationList(json, transactionsPerPage);
            transactions.addAll(transactionsPerPage);

            page++;
        }

        return transactions;
    }

    private static String getTransactionsJsonByUserIdAndPage(int userId, Integer page) throws IOException {
        URL url = new URL(URL + userId + "&page=" + page);

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod(REQUEST_METHOD);

        String json = null;
        if (connection.getResponseCode() == HttpsURLConnection.HTTP_OK) {

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            json = response.toString();
        }
        return json;
    }

}

public class TransactionsByLocationAndId {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int userId = Integer.parseInt(bufferedReader.readLine().trim());

        int locationId = Integer.parseInt(bufferedReader.readLine().trim());

        int netStart = Integer.parseInt(bufferedReader.readLine().trim());

        int netEnd = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.getTransactions(userId, locationId, netStart, netEnd);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}