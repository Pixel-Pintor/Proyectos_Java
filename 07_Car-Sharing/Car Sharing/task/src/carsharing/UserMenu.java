package carsharing;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class UserMenu {

    LinkedHashSet<MenuItem> menuItems;
    Scanner scanner;

    public UserMenu(List<MenuItem> items) {
        scanner = new Scanner(System.in);
        menuItems = new LinkedHashSet<>();
        menuItems.addAll(items);
    }

    public void openMenu() {
        System.out.println(" ");
        menuItems.forEach(menuItem -> System.out.println(menuItem.getDescription()));
        selectMenuItem();
    }

    private void selectMenuItem() {
        long itemID = scanner.nextInt();
        menuItems.forEach(menuItem -> {
            if (menuItem.getId() == 0) {
                menuItem.execute();
            }
            if (menuItem.getId() == itemID) {
                menuItem.execute();
                openMenu();
            }
        });
    }
}