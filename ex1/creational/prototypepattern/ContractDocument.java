package ex1.creational.prototypepattern;

public class ContractDocument extends Document {
    private String partyName;

    public ContractDocument(String title, String content, String partyName) {
        super(title, content);
        this.partyName = partyName;
    }

    @Override
    public void display() {
        System.out.println("Contract Title: " + title);
        System.out.println("Party: " + partyName);
        System.out.println("Content: " + content);
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }
}
