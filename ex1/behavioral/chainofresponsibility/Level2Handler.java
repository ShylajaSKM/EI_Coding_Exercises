package ex1.behavioral.chainofresponsibility;

public class Level2Handler extends SupportHandler {

    @Override
    public void handleTicket(Ticket ticket) {
        if (ticket.getComplexityLevel() == 2) {
            System.out.println("Level 2 handled the ticket: " + ticket.getDescription());
        } else if (nextHandler != null) {
            System.out.println("Level 2 cannot handle, passing to Level 3...");
            nextHandler.handleTicket(ticket);
        } else {
            System.out.println("Ticket could not be handled!");
        }
    }
}
