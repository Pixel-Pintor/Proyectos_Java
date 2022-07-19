package banking.anonymous;

import java.sql.*;

public class CardRepository {

    public CardRepository() {
        createTable();
    }

    public void createTable() {
        Connection connection = DBUtils.getConnection();

        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS card (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "number VARCHAR(16), " +
                    "pin VARCHAR(4), " +
                    "balance INTEGER DEFAULT 0" +
                    ")";
            statement.executeUpdate(query);
            DBUtils.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Card findByNumber(String number) {
        Connection connection = DBUtils.getConnection();
        Card card = new Card();

        try {
            String query = "SELECT * FROM card " +
                    "WHERE number = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, number);
            ResultSet resultSet = ps.executeQuery();

            if (!resultSet.next()) {
                return null;
            }

            card.setId(resultSet.getInt("id"));
            card.setNumber(resultSet.getString("number"));
            card.setPin(resultSet.getString("pin"));
            card.setBalance(resultSet.getInt("balance"));

            DBUtils.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return card;
    }

    public void save(Card card) {
        Connection connection = DBUtils.getConnection();

        try {
            connection.setAutoCommit(false);
            String query = "INSERT INTO card(number, pin, balance) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, card.getNumber());
            ps.setString(2, card.getPin());
            ps.setInt(3, card.getBalance());
            ps.executeUpdate();
            connection.commit();
            DBUtils.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
