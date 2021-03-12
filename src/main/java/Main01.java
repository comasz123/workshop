import java.io.InputStreamReader;

public class Main01 {
    public static void main(String[] args) {

        String result1 = KeyboardReader.readString();
        System.out.println(result1);
        KeyboardReader.close();
    }
}
