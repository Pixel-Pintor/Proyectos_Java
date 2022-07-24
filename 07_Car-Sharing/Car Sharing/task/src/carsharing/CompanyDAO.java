package carsharing;

import java.util.List;

interface CompanyDAO {

    void createCompany(String CompanyName);

    List<Company> getCompanyList();

    void createCar(Company company, String carName);

    List<Car> getCarList(Company company);
}