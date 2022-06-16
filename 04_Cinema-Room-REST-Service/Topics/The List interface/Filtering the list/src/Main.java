import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<String> list = Arrays.asList(str.split(" "));
        list = filterList(list);
        list.forEach(num -> System.out.print(num + " "));
    }

    static List<String> filterList(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) {
                newList.add(list.get(i));
            }
        }
        Collections.reverse(newList);
        return newList;
    }
}