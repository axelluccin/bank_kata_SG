package fr.lacombe;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Account {
    public static final String STATEMENT_TITLE = "date || credit || debit || balance";
    private final PrinterStatement printer;
    private Amount amountDeposit;

    public Account(PrinterStatement printer) {
        this.printer = printer;
    }

    public void deposit(Amount amount) {
        this.amountDeposit = amount;
    }

    public void withDrawal(Amount amount) {
        throw new NotImplementedException();
    }

    public void print() {
        String statement = STATEMENT_TITLE;
        if (null != this.amountDeposit)
            statement += "\n10/01/2012 || " + this.amountDeposit.getFormatAmount() + " || || " + this.amountDeposit.getFormatAmount();
        printer.print(statement);
    }

}
