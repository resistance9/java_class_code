package homework_code.w3;

import java.util.Scanner;

public class score {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("학생1>>");
        String name1 = scanner.next();
        int late1 = scanner.nextInt();
        int absent1 = scanner.nextInt();

        System.out.print("학생2>>");
        String name2 = scanner.next();
        int late2 = scanner.nextInt();
        int absent2 = scanner.nextInt();

        int penalty1 = (late1 * 3) + (absent1 * 8);
        int score1 = 100 - penalty1;

        int penalty2 = (late2 * 3) + (absent2 * 8);
        int score2 = 100 - penalty2;

        System.out.println(name1 + "의 감점은 " + penalty1 + ", " + name2 + "의 감점은 " + penalty2);

        if (score1 > score2) {
            System.out.println(name1 + "의 출석 점수가 더 높음. " + name1 + " 출석 점수는 " + score1);
        } else if (score2 > score1) {
            System.out.println(name2 + "의 출석 점수가 더 높음. " + name2 + " 출석 점수는 " + score2);
        } else {
            System.out.println("점수 동일");
        }
        scanner.close();

    }
}
