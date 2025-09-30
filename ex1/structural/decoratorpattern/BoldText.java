package ex1.structural.decoratorpattern;

public class BoldText extends Decorator {

    public BoldText(Text text) {
        super(text);
    }

    @Override
    public String getContent() {
        return "<b>" + super.getContent() + "</b>";
    }
}
