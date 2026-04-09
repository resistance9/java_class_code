package inclass_code.w5;

public class ReturnArray {
    static int[] makeArray() {
        int temp[] = new int[4];
        for (int i=0; i<temp.length; i++) {
            temp[i] = i;
        }
        return temp;
    }
    public static void main (String[] args) {
        int intArrary[];
        intArrary = makeArray();
        for (int i=0; i< intArrary.length; i++){
            System.out.print(intArrary[i] + " ");
        }
    }
}
