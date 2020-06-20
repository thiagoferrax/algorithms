package com.trainings.algorithms.https;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
	
		public String getTxnType() {
			return txnType;
		}
	
		public String getIp() {
			return ip;
		}
	
		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
	
		public void setTxnType(String txnType) {
			this.txnType = txnType;
		}
	
		public void setIp(String ip) {
			this.ip = ip;
		}
	
		@Override
		public String toString() {
			return "Transaction [locationId=" + locationId + ", amount=" + amount + ", txnType=" + txnType + ", ip=" + ip
					+ "]";
		}
		
		
	}
	
	class Result {
	
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
			System.out.println("userId: " + userId + ", locationId: " + locationId + ", netStart: " + netStart
					+ ", netEnd: " + netEnd);
			System.out.println("---------------------------------------------------------------------------------------\n");
	
			int amountsSum;
	
			try {
				List<Transaction> transactions = getTransactionsByUserId(userId);
				amountsSum = calculateAmountSum(locationId, netStart, netEnd, transactions);
			} catch (IOException e) {
				amountsSum = 0;
			}
	
			return amountsSum;
		}
	
		private static int calculateAmountSum(int locationId, int netStart, int netEnd, List<Transaction> transactions) {
			BigDecimal amountsSum = BigDecimal.ZERO;
			for (Transaction transaction : transactions) {
				if (transaction.getLocationId().intValue() == locationId && isIpInNetInterval(transaction.getIp(), netStart, netEnd)) {
					if (transaction.getTxnType().equals(CREDIT)) {
						amountsSum = amountsSum.add(transaction.getAmount());
					} else {
						amountsSum = amountsSum.subtract(transaction.getAmount());
					}
				}
			}
	
			
			BigDecimal scaled = amountsSum.setScale(0, RoundingMode.HALF_UP);
			return scaled.intValue();
		}
	
		private static boolean isIpInNetInterval(String ip, int netStart, int netEnd) {
			int firstPartIpAddress = Integer.valueOf(ip.split("\\.")[FIRST_PART]);
			return firstPartIpAddress >= netStart && firstPartIpAddress <= netEnd;
		}
	
		private static List<Transaction> parseJsonToTransationList(String json) {
			if (json == null) {
				return new ArrayList<Transaction>();
			}
	
			Pattern pattern = Pattern.compile(TRANSACTIONS_REGEXP);
			Matcher matcher = pattern.matcher(json);
	
			Transaction transaction = null;
			List<Transaction> transactions = new ArrayList<Transaction>();
			while (matcher.find()) {
				String key = matcher.group(KEY);
				String value = matcher.group(VALUE);
	
				if (key.equals(ID)) {
					if (transaction == null) {
						System.out.println("TransactionId => " + value);
	
						transaction = new Transaction();
					} else {
						System.out.println("LocationId => " + value);
	
						transaction.setLocationId(Integer.valueOf(value));
					}
				}
	
				if (key.equals(TXN_TYPE)) {
					System.out.println(key + " => " + value);
	
					transaction.setTxnType(value);
				}
	
				if (key.equals(AMOUNT)) {
					System.out.println(key + " => " + value);
	
					transaction.setAmount(new BigDecimal(value.substring(1, value.length() - 1).replace(",", "")));
				}
	
				if (key.equals(IP)) {
					System.out.println(key + " => " + value + "\n");
	
					transaction.setIp(value);
					transactions.add(transaction);
	
					transaction = null;
				}
			}
	
			return transactions;
		}
	
		private static List<Transaction> getTransactionsByUserId(int userId) throws IOException {
			String json = null;
	
			URL url = new URL(URL + userId);
	
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod(REQUEST_METHOD);
	
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
	
			return parseJsonToTransationList(json);
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