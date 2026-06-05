package inclass_code.w10;

class _Point {
    private int x, y;

    public _Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Point_(" + x + "," + y + ")";
    }
}

public class ToStringEx {
    public static void main(String[] args) {
        _Point p = new _Point(2, 3);
        System.out.println(p.toString());
        System.out.println(p);
        System.out.println(p + "입니다.");
    }
}