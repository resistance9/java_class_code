package homework_code.w5;

import java.util.Scanner;

public class printing_star {
    public static void main(String[] args) {
        System.out.print("양의 정수를 입력>>");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n>0) {
            for (int i=n; i<=n; i--) {
                System.out.println("*".repeat(i));
            }
        }
        else {
          main(args);
        }
        scanner.close();
    }
}
