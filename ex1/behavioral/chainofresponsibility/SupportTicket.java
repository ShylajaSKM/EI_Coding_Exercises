package ex1.behavioral.chainofresponsibility;

public class SupportTicket {
    private final String description;
    private final int complexity;

    public SupportTicket(String description, int complexity) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }

        if (complexity < 1) {
            complexity = 1; // default to 1 if invalid
        }

        this.description = description;
        this.complexity = complexity;
    }

    public String getDescription() {
        return description;
    }

    public int getComplexity() {
        return complexity;
    }
}
