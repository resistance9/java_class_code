package inclass_code.w10;

public class AutoBoxingUnBoxingEX {
    public static void main(String[] args) {
        int n = 10;
        Integer intObject = n;
        System.out.println("intObject = " + intObject);

        int m = intObject + 10;
        System.out.println("m = " + m);
    }
}
