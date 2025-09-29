import java.util.ArrayList;
import java.util.Scanner;

public class SumWithAutoboxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers (type 'done' to finish):");
        while (true) {
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                // Autoboxing
                Integer num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, enter an integer or 'done'.");
            }
        }

        int sum = 0;
        for (Integer n : numbers) {
            sum += n; // Unboxing happens here
        }

        // ✅ Print only one integer as output
        System.out.println(sum);

        sc.close();
    }
}
