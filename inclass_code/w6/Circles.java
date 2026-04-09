package inclass_code.w6;

public class Circles {
    int radius;
    String name;

    public Circles() {
        radius = 1;
        name = "";
    }

    public Circles(int r, String n) {
        radius = r;
        name = n;
    }

    public double getArea() {
        return 3.14*radius*radius;
    }

    public static void main(String[] args) {
        Circles pizza = new Circles(10, "자바피자");

        double area = pizza.getArea();
        System.out.println(pizza.name + "의 면적은 " + area);

        Circles dount = new Circles();
        dount.name = "도넛피자";
        area = dount.getArea();
        System.out.println(dount.name + "의 면적은 " + area);

    }
}
