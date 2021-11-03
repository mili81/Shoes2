package com.company;
import java.sql.*;
import java.util.Scanner;


public class Database {

    static final String DB_URL = "jdbc:mysql://localhost/Shoes";  //here defined where database is located, need to define instead of the localhost, the server internal IP address
    //Database credentials
    static final String USER = "root";
    static final String PASSWORD = "qwerty";
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


        String sql = "INSERT INTO shoes(ID,Name,Size,Colour,Brand) VALUES (+" +
                name + "'," + size + ",'" + colour + "','" + brand + "')";
        stmt.execute(sql);
    }


    public static void main(String[] args) throws SQLException {
        try {
            //return connection instance
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Creating statement...");

            //Create statement object
            stmt = conn.createStatement();


        } catch (SQLException sqlException) {
            System.out.println("Error:" + sqlException.getMessage());

        } finally {  //this finally block will always be performed
            try {     //wrap with try+catch block
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
            }
        }


    }
}