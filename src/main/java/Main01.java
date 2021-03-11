public class Main01 {
    public static void main(String[] args) {
 //       KeyboardReader kr = new KeyboardReader();
        int result = KeyboardReader.readInt(7);
        System.out.println(result);

        String result1 = KeyboardReader.readString();
        System.out.println(result1);
        KeyboardReader.close();
    }
}
