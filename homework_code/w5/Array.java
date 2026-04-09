package homework_code.w5;

public class Array {
     public static void main(String[] args) {
        int array [][] = new int[5][];
        array[0] = new int [] {1,2,3};
        array[1] = new int [] {2,3};
        array[2] = new int [] {1};
        array[3] = new int [] {1,2,3};
        array[4] = new int [] {1,2,3,4};

        for (int i =0; i<array.length; i++) {
            System.out.println();
            for (int j =0; j<array[i].length; j++) {
                System.out.print(array[i][j]);
            }
        }
     }
}
