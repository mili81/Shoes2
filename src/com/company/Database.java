package com.company;

import java.sql.*;
import java.util.Scanner;


public class Database {

    static final String DB_URL = "jdbc:mysql://group1db.ckfcq92zr1jy.eu-west-2.rds.amazonaws.com/shoes";


    static Connection conn = null;
    static Statement stmt = null;

    //this will give possibility to repeat input scenario many times on users choice
    public static void repeat() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("How many rows You will enter?");
        int answer = input.nextInt();
        int count = 0;
        do {
            insertValues();
            count++;
        } while (count < answer);
    }

    public static void insertValues() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Name:");
        String name = input.next();
        System.out.println("Size:");
        int size = input.nextInt();
        System.out.println("Colour:");
        String colour = input.next();
        System.out.println("Brand:");
        String brand = input.next();


        String sql = "INSERT INTO Shoes(name,size,colour,brand) VALUES (+" +
                "'" + name + "'," + size + ",'" + colour + "','" + brand + "')";
        stmt.execute(sql);
    }


    public static void main(String[] args) {
        Scanner name = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = name.next();
        Scanner pass = new Scanner(System.in);
        System.out.println("Enter password:");
        String password = pass.next();
        try {

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, username, password);
            System.out.println("Creating statement...");

            //Create statement object
            stmt = conn.createStatement();

            repeat();

        } catch (SQLException sqlException) {
            System.out.println("Error:" + sqlException.getMessage());

        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Got error and connection closed." + ex.getMessage());
            }
        }


    }
}