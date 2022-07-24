package carsharing;

public class MenuItem {
    private final long id;
    private final String description;
    private final Runnable execution;

    public MenuItem(long id, String description, Runnable execution) {
        this.id = id;
        this.description = description;
        this.execution = execution;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void execute() {
        execution.run();
    }
}