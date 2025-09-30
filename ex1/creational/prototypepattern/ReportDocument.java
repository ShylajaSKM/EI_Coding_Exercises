package ex1.creational.prototypepattern;

public class ReportDocument extends Document {
    private String author;

    public ReportDocument(String title, String content, String author) {
        super(title, content);
        this.author = author;
    }

    @Override
    public void display() {
        System.out.println("Report Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
