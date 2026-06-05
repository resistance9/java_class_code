package practice.prac3;

import java.util.Scanner;

public class Backjun6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] standard = {1, 1, 2, 2, 2, 8};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int n = sc.nextInt();
            sb.append(standard[i] - n);
            if (i < 5) sb.append(" ");
        }
        System.out.println(sb);
    }
}