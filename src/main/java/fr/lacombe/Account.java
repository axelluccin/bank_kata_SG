package fr.lacombe;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Account {
    public static final String STATEMENT_TITLE = "date || credit || debit || balance";
    private final PrinterStatement printer;
    private List<Amount> amountDeposit = new ArrayList<>();

    public Account(PrinterStatement printer) {
        this.printer = printer;
    }

    public void deposit(Amount amount) {
        this.amountDeposit.add(amount);
    }

    public void withDrawal(Amount amount) {
        throw new NotImplementedException();
    }

    public void print() {
        String statement = "";
        if (amountDeposit.size() > 0) {
            double balance = 0;
            for (Amount amount : amountDeposit) {
                balance += amount.money;
                statement = "\n10/01/2012 || " + formatAmount(amount.money) + " || || " + formatAmount(balance) + statement;
            }
        }
        printer.print(STATEMENT_TITLE + statement);
    }

    private String formatAmount(double account) {
        return String.format("%.2f", account).replace(',', '.');
    }

}
