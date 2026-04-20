package homework_code.w7;

public class Rect {
    private int x, y, width, height;

    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void show() {
        System.out.println("(" + x + "," + y + ")에서 크기가 " + width + "x" + height + "인 사각형");
    }

    public boolean isSquare() {
        return width == height;
    }

    public boolean contains(Rect r) {
        int myRight = this.x + this.width;
        int myBottom = this.y + this.height;

        int rRight = r.x + r.width;
        int rBottom = r.y + r.height;

        if (r.x > this.x && r.y > this.y && rRight < myRight && rBottom < myBottom) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Rect a = new Rect(3, 3, 6, 6); // (3,3)에서 6x6
        Rect b = new Rect(4, 4, 2, 3); // (4,4)에서 2x3

        a.show();

        if (a.isSquare()) {
            System.out.println("a는 정사각형입니다.");
        } else {
            System.out.println("a는 직사각형입니다.");
        }

        if (a.contains(b)) {
            System.out.println("a는 b를 포함합니다.");
        }
    }
}