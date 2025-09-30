package ex1.behavioral.chainofresponsibility;

import java.util.logging.Logger;

public class Level1Handler extends SupportHandler {
    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getComplexity() <= 1) {
            logger.info("Level 1 resolved ticket: " + ticket.getDescription());
        } else if (nextHandler != null) {
            logger.info("Level 1 passing ticket to next handler");
            nextHandler.handleRequest(ticket);
        } else {
            logger.warning("Ticket could not be resolved: " + ticket.getDescription());
        }
    }
}
