package carsharing;

import java.util.List;

public interface CompanyDao {

    List<Company> getAllCompanies();
    void createCompany(String name);
    void exit();
}
