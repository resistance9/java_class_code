package homework_code.w5;

import java.util.Scanner;
import java.util.InputMismatchException;


public class Exeption {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("곱하고자 하는 정수 2개 입력 >> ");
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            System.out.println(n + "x" + m + "=" + m*n);
            scanner.close();
        }
        catch (InputMismatchException e) {
            System.out.println("정수를 입력하세요!");
            scanner.nextLine();
        }
    }
}
