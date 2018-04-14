package com.mandola;
import java.io.*;

public class CSVRead {
    public static final String FILE_NAME = "sample.csv";
    public static void main(String [] args) throws IOException {
        int ch;
        BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Sangwan.DESKTOP-40R23NP\\" + FILE_NAME));

        while ((ch=bf.read()) != -1) {
            System.out.println((char)ch);
        }

        bf.close();
    }
}
