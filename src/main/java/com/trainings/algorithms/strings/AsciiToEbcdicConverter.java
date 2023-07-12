package com.trainings.algorithms.strings;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import static java.nio.file.Files.newOutputStream;

public class AsciiToEbcdicConverter {

    private static final String ENTRADA = "entrada";
    private static final String SAIDA = "saida";
    private static final String IBM500 = "IBM500";
    private static final String CHARSET = "ISO-8859-1";

    private static final String CBS = "cbs";
    private static final Logger LOG = Logger.getLogger(AsciiToEbcdicConverter.class.getName());

    public void convertAsciiToEbcdic(String inputFilePath, String outputFilePath, String cbs) {
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        if (inputFile.exists()) {
            try {
                String linePattern = "(?<=\\G.{" + cbs + "})";

                List<String> lines = Files.readAllLines(inputFile.toPath(), Charset.forName(CHARSET));
                Path outputPath = outputFile.toPath();
                AsciiToEbcdicConverter.write(outputPath, lines, Charset.forName(IBM500));

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

                String linePattern = "(?<=\\G.{" + cbs + "})";
                String[] splitLines = content.split(linePattern);

                List<String> outputLines = List.of(splitLines);
                Path outputPath = outputFile.toPath();
                Files.write(outputPath, outputLines, Charset.forName(CHARSET));

                LOG.info("The file has been converted from EBCDIC to ASCII. Please check the file at: " + outputPath);

            } catch (IOException e) {
                LOG.severe("An error occurred during the conversion process: " + e.getMessage());
            }
        } else {
            LOG.info("The input file does not exist: " + inputFile.getAbsolutePath());
        }

        LOG.info("The EBCDIC to ASCII conversion job has finished.");
    }

    public static Path write(Path path, Iterable<? extends CharSequence> lines,
                             Charset cs, OpenOption... options)
            throws IOException
    {
        // ensure lines is not null before opening file
        Objects.requireNonNull(lines);
        CharsetEncoder encoder = cs.newEncoder();
        try (OutputStream out = newOutputStream(path, options);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, encoder))) {
            for (CharSequence line: lines) {
                writer.append(line);
            }
        }
        return path;
    }

    public static void main(String[] args) {
        String inputFilePath = "input_file.txt";
        String outputFilePath = "output_file_ebcdic.txt";
        String cbs = "5115";

        AsciiToEbcdicConverter converter = new AsciiToEbcdicConverter();
        converter.convertAsciiToEbcdic(inputFilePath, outputFilePath, cbs);

        converter.convertEbcdicToAscii(outputFilePath,"output_file_ascii.txt", cbs);
    }
}