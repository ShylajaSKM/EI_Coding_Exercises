package ex1.structural.decoratorpattern;

public class ItalicText extends Decorator {

    public ItalicText(Text text) {
        super(text);
    }

    @Override
    public String getContent() {
        return "<i>" + super.getContent() + "</i>";
    }
}
