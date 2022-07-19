package carsharing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl implements CompanyDao {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:./src/carsharing/db/carsharing";
    static final String USER = "";
    static final String PASS = "";

    private Connection connection;

    public CompanyDaoImpl() {
        connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            connection.setAutoCommit(true);

            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS company " +
                    "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR UNIQUE NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException ignored) {}
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM company ORDER BY id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                companies.add(new Company(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return companies;
    }

    @Override
    public void createCompany(String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO company (name) VALUES (?)");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void exit() {
        try {
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
