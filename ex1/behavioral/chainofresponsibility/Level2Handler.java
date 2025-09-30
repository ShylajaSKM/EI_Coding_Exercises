package ex1.behavioral.chainofresponsibility;

import java.util.logging.Logger;

public class Level2Handler extends SupportHandler {
    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getComplexity() <= 2) {
            logger.info("Level 2 resolved ticket: " + ticket.getDescription());
        } else if (nextHandler != null) {
            logger.info("Level 2 passing ticket to next handler");
            nextHandler.handleRequest(ticket);
        } else {
            logger.warning("Ticket could not be resolved: " + ticket.getDescription());
        }
    }
}
