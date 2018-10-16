package com.syhan.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64Encoder {

    public static void encode(String filePath) throws Exception {
        //
        File inputFile = new File(filePath);

        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
        String encodedString = Base64
                .getEncoder()
                .encodeToString(fileContent);
        System.out.println(encodedString);

        byte[] encodedStringBytes = encodedString.getBytes();
        Files.write(Paths.get(filePath + ".txt"), encodedStringBytes);
    }

    public static void decode(String textFilePath) throws Exception {
        //
        String content = new String(Files.readAllBytes(Paths.get(textFilePath)));

        File outputFile = new File(textFilePath+".out");

        // decode the string and write to file
        byte[] decodedBytes = Base64
                .getDecoder()
                .decode(content);
        FileUtils.writeByteArrayToFile(outputFile, decodedBytes);
    }

    public static void main(String[] args) throws Exception {
        //
        encode("log_20181005.zip");
        //decode("a-tool.txt");
    }
}
