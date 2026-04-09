package inclass_code.w5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputExetion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 3개를 입력하시오");

        int sum=0, n=0;
        for (int i=0; i<3; i++){
            System.out.print(i+">>");
            try{
                n = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                String ex = scanner.nextLine();

                System.out.println(ex+"은 정수가 아닙니다. 다시입력하세요!");
                i--;
                continue;
            }
            sum +=n;
        }
        System.out.println("합은 " + sum);
        scanner.close();
    }
}
