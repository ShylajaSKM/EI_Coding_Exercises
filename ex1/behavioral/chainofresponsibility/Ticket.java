package ex1.behavioral.chainofresponsibility;

public class Ticket {
    private String description;
    private int complexityLevel; // 1 = simple, 2 = moderate, 3 = complex

    public Ticket(String description, int complexityLevel) {
        this.description = description;
        this.complexityLevel = complexityLevel;
    }

    public String getDescription() {
        return description;
    }

    public int getComplexityLevel() {
        return complexityLevel;
    }
}
