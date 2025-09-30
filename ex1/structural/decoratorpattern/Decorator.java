package ex1.structural.decoratorpattern;

public abstract class Decorator implements Text {
    protected Text text;

    protected Decorator(Text text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        this.text = text;
    }

    @Override
    public String getContent() {
        return text.getContent();
    }
}
