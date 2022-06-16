class Employee {

    final String UNK = "unknown";
    final int ZERO = 0;

    String name;
    int salary;
    String address;

    public Employee() {
        this.name = UNK;
        this.salary = ZERO;
        this.address = UNK;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.address = UNK;
    }

    public Employee(String name, int salary, String address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }
}