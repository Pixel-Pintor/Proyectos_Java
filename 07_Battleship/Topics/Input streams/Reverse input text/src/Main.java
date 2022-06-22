import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder strBuild = new StringBuilder();
        int chars = reader.read();
        while (chars != -1) {
            strBuild.append((char) chars);
            chars = reader.read();
        }
        reader.close();
        System.out.println(strBuild.reverse());
    }
}