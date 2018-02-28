package com.tazimehdi.blockchain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {

    final private char SEPARATOR = ';';

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Incorrect parameters, restart the application using the following ones :");
            System.out.println("P1 - the number of accounts to generate ( 0 for unlimited )");
            System.out.println("P2 - the output filename");
            return;
        }

        final long numberOfAccounts = Long.parseLong(args[0]);
        final String fileName = args[1];

        BufferedWriter fileWriter = null;
        try {

            File file = new File(fileName);
            boolean createHeader = !file.exists() || file.isDirectory();
            fileWriter = new BufferedWriter(new FileWriter(fileName, true));



            if(createHeader) {
                fileWriter.write("public;private;balance");
                fileWriter.newLine();
            }

            if(numberOfAccounts > 0)
                new Main().generateKeys(numberOfAccounts,fileWriter);
            else
                new Main().generateKeysUnlimited(fileWriter);

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    private void generateKeys(final BufferedWriter fileWriter) throws IOException, NoSuchAlgorithmException {

        final Keys keys = new Keys(Bitcoin.generateKeys());

        final long balanceOf = Bitcoin.getBalanceOf(keys.getKey());

        final StringBuffer line = new StringBuffer(keys.getPublicKey());
        line.append(SEPARATOR);

        line.append(keys.getPrivateKey());
        line.append(SEPARATOR);

        line.append(balanceOf);

        fileWriter.write(line.toString());
        fileWriter.newLine();
    }

    private void generateKeys(final long numberOfAccounts,final BufferedWriter fileWriter) throws IOException, NoSuchAlgorithmException {
        for (long i = 0; i < numberOfAccounts; i++) {
            generateKeys(fileWriter);
        }
    }

    private void generateKeysUnlimited(final BufferedWriter fileWriter) throws IOException, NoSuchAlgorithmException {
        while(1 != 2) {
            generateKeys(fileWriter);
        }
    }

    private void checkFileBalance() {

    }

    public Main() {

    }
}

