package homework_code.w3;

import java.util.Scanner;

public class Daycalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("생일 입력 하세요 >> ");
        int brith = scanner.nextInt();

        int year = brith / 10000;
        int month = (brith % 10000) / 100;
        int day = brith % 100;

        System.out.println(year + "년 " + month + "월 " + day + "일");
        scanner.close();
    }

}
