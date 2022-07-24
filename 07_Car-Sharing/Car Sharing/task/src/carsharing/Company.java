package carsharing;

public class Company {

    private final long id;
    private final String name;
    private long listNumber;

    public Company(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%d. %s", id, name);
    }

    public long getListNumber() {
        return listNumber;
    }

    public void setListNumber(long listNumber) {
        this.listNumber = listNumber;
    }
}