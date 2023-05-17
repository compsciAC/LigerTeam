package com.sparta.liger;

import java.sql.*;

public class EmployeeDAO {
    private final Connection connection;
    private Statement statement;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createEmployee(int empNo, Date birthDate, String firstName, String lastName, String gender, Date hireDate) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.CREATE);
            preparedStatement.setInt(1, empNo);
            preparedStatement.setDate(2, birthDate);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, gender);
            preparedStatement.setDate(6, hireDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}