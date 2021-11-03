package com.company;
import java.sql.*;


public class Database {

    static final String DB_URL = "jdbc:mysql://localhost/store";  //here defined where database is located, need to define instead of the localhost, the server internal IP address
    //Database credentials
    static final String USER = "root";
    static final String PASSWORD = "qwerty";
    static Connection conn = null;
    static Statement stmt = null;

    public static void insertWithValue(int id, String name) throws SQLException {

        String size = "com.company.InputValues.inputSize()";
        String brand = "com.company.InputValues.inputColour();";
        String colour = "com.company.InputValues.inputBrand()";


        String sql = "INSERT INTO shoes(ID,Name,Size,Colour,Brand) VALUES (+" +
                id + ",'" + name + "'," + size + ",'" + colour + "','" + brand + "')";
        stmt.execute(sql);
    }

        public static void main (String[]args){
            com.company.InputValues.inputSize() throws SQLInput;
            com.company.InputValues.inputBrand() throws SQLInput;
            com.company.InputValues.inputColour() throws SQLInput;
        }
    }
