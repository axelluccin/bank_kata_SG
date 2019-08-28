import fr.lacombe.PrinterStatement;

public class PrinterFake implements PrinterStatement {

    private String statement;

    @Override
    public void print(String statement) {
        this.statement = statement;
    }

    public String getPrinted() {
        return statement;
    }
}
