import java.util.InputMismatchException;
import java.util.Scanner;

public class KeyboardReader {

    private KeyboardReader(){}

 //   public static final KeyboardReader kr = new KeyboardReader();
    public static Scanner sc = new Scanner(System.in);

    public static void close() {sc.close();}

    public static int readInt(int range, String message) {

        boolean choice = true;
        int result = -1;
        System.out.println(message);

        while (choice) {
            try {
                result = sc.nextInt();
                if (result>0 && result<=range) {
                    choice = false;
                } else {
                    System.out.println("Podaj liczbę całkowitą pomiędzy 1-" + range);
                    }

            } catch (InputMismatchException ex) {
                System.out.println("Podaj liczbę całkowitą pomiędzy 1-"+range);
                sc.nextLine();
            }
        }
        sc.nextLine();
        return result;
    }
    public static String readString(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

}
