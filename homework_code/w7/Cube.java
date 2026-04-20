package homework_code.w7;



public class Cube {
    private int x;
    private int y;
    private int z;

    public Cube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getVolume() {
        return x*y*z;
    }

    public void increase(int x, int y, int z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public boolean isZero() {
        if (getVolume() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Cube cube = new Cube(1,2,3);
        System.out.println("큐브의 부피는 "+ cube.getVolume());
        cube.increase(1,2,3);
        System.out.println("큐브의 부피는 "+ cube.getVolume());
        if (cube.isZero()) {
            System.out.println("큐브의 부피는 0");
        } else {
            System.out.println("큐브의 부피는 0이 아님");
        }

    }
}
