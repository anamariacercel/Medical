package com.medical.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public Statement statement;
    public Connection connection;

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myconnection=DriverManager.getConnection("jdbc:mysql://localhost:3306?medical?serverTimezone=UTC",
                    "root", "root");
            Statement mystatement = myconnection.createStatement();
            this.statement = mystatement;
            this.connection = myconnection;
        } catch (ClassNotFoundException var3) {
            var3.printStackTrace();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }
}
