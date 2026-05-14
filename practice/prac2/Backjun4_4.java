package practice.prac2;

import java.util.Scanner;

public class Backjun4_4 {
    public static void main(String[] args) {
        Scanner br = new Scanner(System.in);

        int max = 0;
        int index = 0;

        for(int i=1; i<=9; i++){
            int num = br.nextInt();
            if(num > max){
                max = num;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}
