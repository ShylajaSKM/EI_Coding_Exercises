package ex1.behavioral.chainofresponsibility;

import java.util.logging.Logger;

public abstract class SupportHandler {
    protected SupportHandler nextHandler;
    protected final Logger logger = Logger.getLogger(SupportHandler.class.getName());

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    
    public abstract void handleRequest(SupportTicket ticket);
}
