package inclass_code.w6;

public class Books {
    String title;
    String author;

    void show() {System.out.println(title + " " + author); }

    public Books () {
        this ("","");
        System.out.println("생성자 호출됨");
    }

    public Books (String title) {
        this(title, "작가미상");
    }

    public Books (String title, String author) {
        this.title = title;
        this.author = author;
    }

    public static void main (String[] args) {
        Books littlePrince = new Books("어린왕자", "생텍쥐페");
        Books loveStory = new Books("춘향전");
        Books emptyBook = new Books();
        loveStory.show();

    }
}
