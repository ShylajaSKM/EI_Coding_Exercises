package ex1.behavioral.chainofresponsibility;

import java.util.logging.Logger;

public class Level3Handler extends SupportHandler {
    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getComplexity() <= 3) {
            logger.info("Level 3 resolved ticket: " + ticket.getDescription());
        } else {
            logger.warning("Ticket requires escalation: " + ticket.getDescription());
        }
    }
}
