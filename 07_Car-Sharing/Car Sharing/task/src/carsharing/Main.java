package carsharing;

import java.sql.*;
// Stage 1 - Aleh Liavanau
public class Main {

    private static final String DEFAULT_DB_NAME = "carsharing";
    private static final String TABLE_NAME = "COMPANY";

    public static void main(String[] args) {
        try (Connection connection = createConnection(getDBName(args))) {
            connection.setAutoCommit(true);
            createTable(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection createConnection(String dbName) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./src/carsharing/db/" + dbName);
    }

    private static String getDBName(String[] args) {
        return args.length >= 2 && args[0].equals("-databaseFileName")
                ? args[1]
                : DEFAULT_DB_NAME;
    }

    private static void createTable(Connection connection) {
        try {
            final Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + TABLE_NAME + "(" +
                    "ID INT," +
                    "NAME VARCHAR)"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}