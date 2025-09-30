package ex1.creational.prototypepattern;

public abstract class Document implements Cloneable {
    protected String title;
    protected String content;

    public Document(String title, String content) {
        if(title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
        this.title = title;
        this.content = content != null ? content : "";
    }

    public abstract void display();

    @Override
    public Document clone() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning failed: " + e.getMessage());
            return null;
        }
    }

    public void setContent(String content) {
        this.content = content != null ? content : "";
    }
}
