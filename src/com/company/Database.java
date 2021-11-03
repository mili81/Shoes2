package com.company;
import java.sql.*;
import java.util.Scanner;


public class Database {

    static final String DB_URL = "jdbc:mysql://group1db.ckfcq92zr1jy.eu-west-2.rds.amazonaws.com/shoes";

    static final String USER = "admin";
    static final String PASSWORD = "Shoes_1234";
    static Connection conn = null;
    static Statement stmt = null;

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


    public static void main(String[] args) throws SQLException {
        try {

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Creating statement...");

            //Create statement object
            stmt = conn.createStatement();
            insertValues();

        } catch (SQLException sqlException) {
            System.out.println("Error:" + sqlException.getMessage());

        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
            }
        }


    }
}