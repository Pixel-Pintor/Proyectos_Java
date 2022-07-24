package carsharing;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static UserMenu firstMenu;
    private static UserMenu managerMenu;
    private static CompanyDAOImpl companyDAO;

    public static void main(String[] args) {
        setupMenus();

        String databaseFileName = getDatabaseFileName(args);
        companyDAO = new CompanyDAOImpl(databaseFileName);

        firstMenu.openMenu();
    }

    private static void setupMenus() {
        firstMenu = setupFirstMenu();
        managerMenu = setupManagerMenu();
    }

    private static UserMenu setupFirstMenu() {
        MenuItem logInAsManager = new MenuItem(1, "1. Log in as a manager", () -> {
            managerMenu.openMenu();
        });

        MenuItem exit = new MenuItem(0, "0. Exit", () -> {
            Runtime.getRuntime().exit(0);
        });

        return new UserMenu(List.of(logInAsManager, exit));
    }

    private static UserMenu setupManagerMenu() {
        MenuItem backToFirstMenu = new MenuItem(0, "0. Back", () -> firstMenu.openMenu());

        MenuItem chooseCompany = new MenuItem(1, "1. Company list", () -> {
            List<Company> companies = companyDAO.getCompanyList();
            if (companies.isEmpty()) {
                System.out.println("The company list is empty!");
                return;
            }

            System.out.println("Choose a company:");
            printCompanyList(companies);
            System.out.println("0. Back");

            Scanner scanner = new Scanner(System.in);
            int selectedID = scanner.nextInt();

            // костыль на Back to main menu :(
            if (selectedID == 0) {
                managerMenu.openMenu();
                return;
            }

            Company selectedCompany = companies.stream()
                    .filter(company -> company.getListNumber() == selectedID)
                    .findFirst()
                    .orElse(null);
            setupCompanyMenu(selectedCompany).openMenu();
        });

        MenuItem createCompany = new MenuItem(2, "2. Create a company", () -> {
            System.out.println("Enter the company name:");
            String name = new Scanner(System.in).nextLine();
            companyDAO.createCompany(name);
            System.out.println("The company was created!");

            managerMenu.openMenu();
        });


        return new UserMenu(List.of(chooseCompany, createCompany, backToFirstMenu));
    }

    private static UserMenu setupCompanyMenu(Company company) {
        System.out.println("'" + company.getName() + "' company");

        MenuItem showCarList = new MenuItem(1, "1. Car list", () -> {
            List<Car> cars = companyDAO.getCarList(company);
            if (cars.isEmpty()) {
                System.out.println("The car list is empty!");
                return;
            }
            System.out.println("Car list:");
            printCarList(cars);
        });

        MenuItem createCar = new MenuItem(2, "2. Create a car", () -> {
            System.out.println("Enter the car name:");
            Scanner scanner = new Scanner(System.in);
            String carName = scanner.nextLine();
            companyDAO.createCar(company, carName);
            System.out.println("The car was added!");
        });

        MenuItem backToManagerMenu = new MenuItem(0, "0. Back", () -> managerMenu.openMenu());

        return new UserMenu(List.of(showCarList, createCar, backToManagerMenu));
    }

    private static void printCompanyList(List<Company> companies) {
        int counter = 1;
        for (Company company : companies) {
            company.setListNumber(counter);
            System.out.printf("%d. %s%n", counter, company.getName());
            counter++;
        }
    }

    private static void printCarList(List<Car> cars) {
        int counter = 1;
        for (Car car : cars) {
            car.setListNumber(counter);
            System.out.printf("%d. %s%n", counter, car.getName());
            counter++;
        }
    }

    private static String getDatabaseFileName(String[] args) {
        String databaseFileName = "H2storage";
        //String[] debugArgs = new String[] {"-databaseFileName", "db"};

        HashMap<String, String> arguments = parseConsoleArguments(args);
        if (arguments.containsKey("-databaseFileName")) {
            databaseFileName = arguments.get("-databaseFileName");
        }
        return databaseFileName;
    }

    private static HashMap<String, String> parseConsoleArguments(String[] args) {
        HashMap<String, String> arguments = new HashMap<>();
        List<String> arrayOfArgs = List.of(args);

        String key = "";
        for (String arg : arrayOfArgs) {
            if (arg.startsWith("-")) {
                key = arg;
                continue;
            }
            arguments.put(key, arg);
        }

        return arguments;
    }
}