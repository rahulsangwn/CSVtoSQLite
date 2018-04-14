package com.mandola;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

class DBWrite {

    public static final String DB_NAME = "test.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Sangwan.DESKTOP-40R23NP\\" + DB_NAME;
    public static final String TABLE_STUDENT = "Student";

    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_CONTACT = "Contact";
    public static final String COLUMN_ADDRESS = "Address";


    public static void dbops(String first, String second,String  third,String  fourth) {

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();


            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_STUDENT + " (" + COLUMN_ID + " text, " +
                               COLUMN_NAME + " text, " + COLUMN_CONTACT + " text, " + COLUMN_ADDRESS + " text )" );
            statement.execute("INSERT INTO " + TABLE_STUDENT + "( " + COLUMN_ID + ", " + COLUMN_NAME +
                               ", " + COLUMN_CONTACT + " , " + COLUMN_ADDRESS +  " ) " + "VALUES( " + first + " , '" + second + "' , " + third + " , '" + fourth + "' ) ");

            statement.close();
            conn.close();

        }
        catch(SQLException e) {
            System.out.println("Something goes wrong : " + e.getMessage());
        }
    }
}

public class Main {
    public static final String FILE_NAME = "sample.csv";


    public static void main(String [] args) throws IOException {
        int ch;
        BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Sangwan.DESKTOP-40R23NP\\" + FILE_NAME));

        String s;
        while ((s=bf.readLine()) != null) {

            String[] s2 = s.split(",");

            DBWrite.dbops(s2[0], s2[1], s2[2], s2[3]); // sample.csv contain ID, Name, Contact_no, Address of students in csv format
        }

        bf.close();
    }

    }


