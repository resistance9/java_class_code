package inclass_code.w10;

class Point_ {
    private int x, y;

    public Point_(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {
        Point_ p = (Point_) obj;
        if (x == p.x && y == p.y) return true;
        else return false;
    }
}

public class EqualsEx {
    public static void main(String[] args) {
        Point_ a = new Point_(2, 3);
        Point_ b = new Point_(2, 3);
        Point_ c = new Point_(3, 4);

        if (a == b) {
            System.out.println("a==b");
        }
        if (a.equals(b)) {
            System.out.println("a is equal to b");
        }
        if (a.equals(c)) {
            System.out.println("a is equal to c");
        }
    }
}