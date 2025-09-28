package ex1.behavioral.chainofresponsibility;

public class Level3Handler extends SupportHandler {

    @Override
    public void handleTicket(Ticket ticket) {
        if (ticket.getComplexityLevel() == 3) {
            System.out.println("Level 3 handled the ticket: " + ticket.getDescription());
        } else {
            System.out.println("Ticket could not be handled at any level!");
        }
    }
}
