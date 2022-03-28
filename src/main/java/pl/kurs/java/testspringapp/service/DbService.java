package pl.kurs.java.testspringapp.service;

import pl.kurs.java.testspringapp.model.MyForm;

import java.sql.*;

public class DbService {
    private Connection connection;
    Statement stmt;

    public DbService() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calculator", "root", "Chujdupa2137xd!");
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveToDatabase(MyForm myForm) {
        String sql = "insert into calculator(a, b, operation, result) values(" + myForm.getA() + "," + myForm.getB()
                + ",'" + myForm.getOperation() + "'," + myForm.getResult() + ")";
        try {
            int st = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
