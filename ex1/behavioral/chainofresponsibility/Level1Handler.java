package ex1.behavioral.chainofresponsibility;

public class Level1Handler extends SupportHandler {

    @Override
    public void handleTicket(Ticket ticket) {
        if (ticket.getComplexityLevel() == 1) {
            System.out.println("Level 1 handled the ticket: " + ticket.getDescription());
        } else if (nextHandler != null) {
            System.out.println("Level 1 cannot handle, passing to Level 2...");
            nextHandler.handleTicket(ticket);
        } else {
            System.out.println("Ticket could not be handled!");
        }
    }
}
