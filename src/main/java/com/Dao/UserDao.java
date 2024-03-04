package com.Dao;

import com.Dao.model.Employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDao implements GenericDatabaseDao<Employee, Integer> {

    private final MysqlDataSource dataSource;

    public UserDao() {
        this.dataSource = (MysqlDataSource) MySqlDatasourceUtil.getMySQLDataSource();
    }

    @Override
    public void add(Employee employee) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO employee (empname, empemail) VALUES (?, ?)",
                        Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, employee.getUsername());
            preparedStatement.setString(2, employee.getEmail());

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    employee.setId((generatedKeys.getInt(1)));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        ArrayList<Employee> employees = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM employee")) {

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("empid"));
                employee.setUsername(resultSet.getString("empname"));
                employee.setEmail(resultSet.getString("empemail"));

                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public List<Employee> getAll(String searchParameter) {
        ArrayList<Employee> employees = new ArrayList<>();
    
        // Using a prepared statement to avoid SQL injection
        String sqlQuery = "SELECT * FROM employee WHERE empname LIKE ? OR empemail LIKE ?";
        
        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            
            // Setting the search parameter for both username and email
            String likeParameter = "%" + searchParameter + "%";
            preparedStatement.setString(1, likeParameter);
            preparedStatement.setString(2, likeParameter);
    
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getInt("empid"));
                    employee.setUsername(resultSet.getString("empname"));
                    employee.setEmail(resultSet.getString("empemail"));
    
                    employees.add(employee);
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return employees;
    }

    @Override
    public void update(Employee employee) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE employee SET empname=?, empemail=? WHERE empid=?")) {

            preparedStatement.setString(1, employee.getUsername());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setInt(3, employee.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Employee employee) {
        removeEmployeeById(employee.getId());
    }

    public void removeEmployeeById(int id) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("DELETE FROM employee WHERE empid=?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getById(Integer id) {
        Employee employee = null;

        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("SELECT * FROM employee WHERE empid=?")) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    employee = new Employee();
                    employee.setId(resultSet.getInt("empid"));
                    employee.setUsername(resultSet.getString("empname"));
                    employee.setEmail(resultSet.getString("empemail"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    public Employee getByName(String username) {
        Employee employee = null;
        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("SELECT * FROM employee WHERE empname=?")) {

            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    employee = new Employee();
                    employee.setId(resultSet.getInt("empid"));
                    employee.setUsername(resultSet.getString("empname"));
                    employee.setEmail(resultSet.getString("empemail"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    public Employee getByEmail(String username) {
        Employee employee = null;
        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("SELECT * FROM employee WHERE empname=?")) {

            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    employee = new Employee();
                    employee.setId(resultSet.getInt("empid"));
                    employee.setUsername(resultSet.getString("empname"));
                    employee.setEmail(resultSet.getString("empemail"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

}
