package homework_code.w5;

import java.util.Scanner;
import java.util.InputMismatchException;

public class coffeeorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String coffee[] = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
        int price[] = {3000, 3500, 4000, 5000};

        System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");

        while (true) {
            System.out.print("주문 >> ");
            String name = scanner.next(); // 메뉴명 입력

            if (name.equals("그만")) break;

            int index = -1;
            for (int i = 0; i < coffee.length; i++) {
                if (coffee[i].equals(name)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println(name + "은(는) 없는 메뉴입니다.");
                continue;
            }

            try {
                int count = scanner.nextInt();
                System.out.println("가격은 " + (price[index] * count) + "원입니다.");
            } catch (InputMismatchException e) {
                System.out.println("잔 수는 양의 정수로 입력해주세요!");
                scanner.nextLine();
            }
        }

        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}