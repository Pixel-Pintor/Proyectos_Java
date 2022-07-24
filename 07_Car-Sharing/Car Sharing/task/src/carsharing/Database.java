package carsharing;

import java.io.File;
import java.io.IOException;
import java.sql.*;

class Database {

    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:./";
    private static final String FOLDER = "src/carsharing/db/";

    public Database() {
        try {
            Class.forName(DRIVER);

        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер " + DRIVER + " не найден!!!");
        }
    }

    private Connection getConnection(String database_name) {
        createDatabaseFolder(database_name);
        String connectionString = URL + FOLDER + database_name;
        Connection connection = null;
        try {
            connection =  DriverManager.getConnection(connectionString);
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            return connection;
        }
        return connection;
    }

    public ResultSet executeQuery(String database_name, String query) {
        PreparedStatement statement;
        ResultSet resultSet = null;

        try {
            Connection connection = getConnection(database_name);
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

        } catch (SQLException e) {
            System.out.println("Ошибка запроса: " + e.getMessage());
        }
        return resultSet;
    }

    public void execute(String database_name, String query) {
        PreparedStatement statement;

        try (Connection connection = getConnection(database_name)) {
            statement = connection.prepareStatement(query);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Ошибка запроса: " + e.getMessage());
        }
    }

    private void createDatabaseFolder(String dataFile) {
        File folder = new File(FOLDER);
        boolean isFolderCreated = folder.mkdirs();

        File file = new File(FOLDER + dataFile + ".mv.db");
        try {
            boolean isFileCreated = file.createNewFile();
        } catch (IOException ignored) {
        }

    }

}