package com.trainings.algorithms.strings;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class AsciiToEbcdicConverter {

    private static final String ENTRADA = "entrada";
    private static final String SAIDA = "saida";
    private static final String IBM500 = "ibm500";
    private static final String DEFAULT_CHARSET = Charset.defaultCharset().toString();

    private static final String CBS = "cbs";
    private static final Logger LOG = Logger.getLogger(AsciiToEbcdicConverter.class.getName());

    public void convertAsciiToEbcdic(String inputFilePath, String outputFilePath, String cbs) {
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        if (inputFile.exists()) {
            try {
                String lineSeparator = System.getProperty("line.separator");
                String linePattern = "(?<=\\G.{" + cbs + "})";

                List<String> lines = Files.readAllLines(inputFile.toPath(), Charset.forName(DEFAULT_CHARSET));
                String content = String.join(lineSeparator, lines);
                String[] splitLines = content.split(linePattern);
                List<String> outputLines = Arrays.asList(splitLines);

                Path outputPath = outputFile.toPath();
                Files.write(outputPath, outputLines, Charset.forName(IBM500));

                LOG.info("The file has been converted from ASCII to EBCDIC. Please check the file at: " + outputPath);

            } catch (IOException e) {
                LOG.severe("An error occurred during the conversion process: " + e.getMessage());
            }
        } else {
            LOG.info("The input file does not exist: " + inputFile.getAbsolutePath());
        }

        LOG.info("The ASCII to EBCDIC conversion job has finished.");
    }

    public void convertEbcdicToAscii(String inputFilePath, String outputFilePath, String cbs) {
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        if (inputFile.exists()) {
            try {
                byte[] inputBytes = Files.readAllBytes(inputFile.toPath());
                String content = new String(inputBytes, Charset.forName(IBM500));

                String lineSeparator = System.getProperty("line.separator");
                String linePattern = "(?<=\\G.{" + cbs + "})";
                String[] splitLines = content.split(linePattern);

                List<String> outputLines = List.of(splitLines);
                Path outputPath = outputFile.toPath();
                Files.write(outputPath, outputLines, Charset.forName(DEFAULT_CHARSET));

                LOG.info("The file has been converted from EBCDIC to ASCII. Please check the file at: " + outputPath);

            } catch (IOException e) {
                LOG.severe("An error occurred during the conversion process: " + e.getMessage());
            }
        } else {
            LOG.info("The input file does not exist: " + inputFile.getAbsolutePath());
        }

        LOG.info("The EBCDIC to ASCII conversion job has finished.");
    }
    public static void main(String[] args) {
        String inputFilePath = "input_file.txt";
        String outputFilePath = "output_file.txt";
        String cbs = "80";

        AsciiToEbcdicConverter converter = new AsciiToEbcdicConverter();
        converter.convertAsciiToEbcdic(inputFilePath, outputFilePath, cbs);

        converter.convertEbcdicToAscii(outputFilePath,"output_file2.txt", cbs);
    }
}
