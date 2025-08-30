import java.io.IOException;

public class Main_ordenacao {
    public static void main(String[] args) {
        try {
            Main_length.main(args);
            System.out.println("\n");
            Main_data.main(args);
            System.out.println("\n");
            Main_month.main(args);
            System.out.println("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
