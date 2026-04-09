package inclass_code.w6;

import java.util.Scanner;

class Booki {
    String title, author;

    public Booki(String title, String author) {
        this.title = title;
        this.author = author;
    }
}


public class BookArray {
    public static void main(String[] args) {
        Booki[] Booki = new Booki[2];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < Booki.length; i++) {
            System.out.print("제목>> ");
            String title = scanner.nextLine();
            System.out.print("저자>> ");
            String author = scanner.nextLine();
            Booki[i] = new Booki(title, author);
        }

        for (int i = 0; i < Booki.length; i++) {
            System.out.print("(" + Booki[i].title + ", " + Booki[i].author + ")");
        }

        scanner.close();
    }
}