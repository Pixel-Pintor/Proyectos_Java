import java.util.Comparator;

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user1.getName().compareTo(user2.getName());
    }
}

/*
class Main {

    public static void main(String[] args) {

        User user1 = new User("Andres");
        User user2 = new User("Christian");
        List<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user1);
        System.out.println(users); // [Christian, Andres]
        users.sort(new UserComparator());
        System.out.println(users); // [Andres, Christian]
    }
}*/
