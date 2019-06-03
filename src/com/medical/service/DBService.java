package com.medical.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class DBService extends DBConnection {
    private static DBService ourInstance = new DBService();

    public static DBService getInstance() {
        return ourInstance;
    }

    private DBService() {
    }

    public void insertPillDB() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("INSERT Pill id : ");
        int id = Integer.parseInt(br.readLine());
        System.out.println("INSERT Pill name : ");
        String name = br.readLine();
        System.out.println("INSERT Pill prospect : ");
        String prospect = br.readLine();

        try {
            Statement statement = this.connection.createStatement();
            statement.execute("insert into pills(id, name, prospect) values (" + id + ", '" + name + "', '" + prospect + "')");
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

    }

    public void selectPillsBD() throws SQLException {
        ResultSet resultSet = this.statement.executeQuery(" select * from pills");
        ResultSetMetaData var2 = resultSet.getMetaData();

        while(resultSet.next()) {
            System.out.println("id=" + resultSet.getInt(1) + ", name=" + resultSet.getString(2) + ", prospect=" + resultSet.getString(3));
        }

    }

    public void updatePillsBD_byId() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("UPDATE  WHERE Pill id : ");
        int id = Integer.parseInt(br.readLine());
        System.out.println("UPDATE Pill name : ");
        String name = br.readLine();
        System.out.println("UPDATE Pill prospect : ");
        String prospect = br.readLine();
        String sql = "update pills set name=?, prospect=? where id=" + id;

        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, prospect);
            pst.executeUpdate();
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

    }

    public void deletePillsBD_byName() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("DELETE  WHERE Pill name = ");
        String name = br.readLine();
        String sql = "delete from pills where name=?";

        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, name);
            pst.executeUpdate();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

    }

    public void insertPatientDB(String cnp, String name, String telephone, int age) throws IOException, SQLException {
        Statement statement = null;

        try {
            statement = this.connection.createStatement();
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        statement.execute("insert into patients(name, email, age) values (" + cnp + ", '" + name + "', '" + telephone + "', " + age + ")");
    }

    public void selectPatientsBD() throws SQLException {
        ResultSet resultSet = this.statement.executeQuery(" select * from patients");
        ResultSetMetaData var2 = resultSet.getMetaData();

        while(resultSet.next()) {
            System.out.println("first name=" + resultSet.getString(2) + ", email=" + resultSet.getString(3) + ", cnp=" + resultSet.getString(4) + ", age=" + resultSet.getString(6));
        }

    }

    public void updatePatientBD_byName(String name, String telephone) throws IOException {
        String sql = "update patients set blood_type=? where name='" + name + "'";

        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, telephone);
            pst.executeUpdate();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

    }

    public void deletePatientBD_byName(String name) throws IOException {
        String sql = "delete from patients where name=?";

        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, name);
            pst.executeUpdate();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }
}
