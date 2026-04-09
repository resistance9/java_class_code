package inclass_code.w6;

import java.util.Scanner;

class  Rectangle{
    int width;
    int hight;
    public int getArea() {
        return width * hight / 2;
    }
}

public class ReactApp {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        Scanner scanner = new Scanner(System.in);
        System.out.println(">> ");
        rect.width = scanner.nextInt();
        rect.hight = scanner.nextInt();
        System.out.println("삼각형의 면적은 " + rect.getArea());
        scanner.close();
    }
}

