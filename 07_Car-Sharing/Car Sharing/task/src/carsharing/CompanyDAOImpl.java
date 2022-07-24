package carsharing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompanyDAOImpl implements CompanyDAO {

    private final Database database;
    private final String databaseName;
    private Optional<Company> selectedCompany;

    public CompanyDAOImpl(String databaseName) {
        this.databaseName = databaseName;
        database = new Database();
        createCompanyTable();
        createCarTable();
    }

    @Override
    public void createCompany(String companyName) {
        database.execute(databaseName, "INSERT INTO COMPANY (name) " +
                "VALUES('" + companyName + "');");
    }

    @Override
    public List<Company> getCompanyList() {
        List<Company> companies = new ArrayList<>();
        try (ResultSet result = database.executeQuery(databaseName, "SELECT * FROM COMPANY;")) {
            while (result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                companies.add(new Company(id, name));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return companies;
    }

    @Override
    public void createCar(Company company, String carName) {
        database.execute(databaseName, "INSERT INTO CAR (name, company_id) " +
                String.format("VALUES('%s', %d);", carName, company.getId()));
    }

    @Override
    public List<Car> getCarList(Company company) {
        List<Car> cars = new ArrayList<>();
        try (ResultSet result = database.executeQuery(databaseName,
                String.format("SELECT * FROM CAR WHERE COMPANY_ID = %d;", company.getId()))) {
            while (result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                cars.add(new Car(id, name));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }

    private void createCompanyTable() {
        database.execute(databaseName,
                "CREATE TABLE COMPANY (" +
                        "ID INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                        "NAME VARCHAR UNIQUE NOT NULL" +
                        ");"
        );
    }

    private void createCarTable() {
        database.execute(databaseName,
                "CREATE TABLE CAR (" +
                        "ID INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                        "NAME VARCHAR UNIQUE NOT NULL," +
                        "COMPANY_ID INTEGER NOT NULL," +
                        "CONSTRAINT fk_company FOREIGN KEY (COMPANY_ID)" +
                        "REFERENCES COMPANY(ID)" +
                        ");"
        );
    }
}