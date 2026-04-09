package homework_code.w5;

import java.util.Scanner;

public class GradeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String course[] = {"C", "C++", "Python", "Java", "HTML5"};
        String grade[] = {"A", "B+", "B", "A+", "D"};

        while (true) {
            System.out.print("과목 >> ");
            String name = scanner.next();

            if (name.equals("그만")) {
                break;
            }

            int i;
            for (i = 0; i < course.length; i++) {
                if (course[i].equals(name)) { // 배열 내 과목명과 입력값 비교
                    System.out.println(name + " 학점은 " + grade[i]);
                    break;
                }
            }

            if (i == course.length) {
                System.out.println(name + "는 없는 과목입니다.");
            }
        }

        scanner.close();
    }
}