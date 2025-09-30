package ex1.structural.decoratorpattern;

public class ConcreteText implements Text {
    private final String content;

    public ConcreteText(String content) {
        if (content == null) {
            throw new IllegalArgumentException("Content cannot be null");
        }
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
