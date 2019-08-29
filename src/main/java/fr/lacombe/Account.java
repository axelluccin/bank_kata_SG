package fr.lacombe;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private static final String STATEMENT_TITLE = "date || credit || debit || balance";
    private final PrinterStatement printer;
    private List<Amount> amountDeposit = new ArrayList<>();
    private Amount amountWithDrawal;

    public Account(PrinterStatement printer) {
        this.printer = printer;
    }

    public void deposit(Amount amount) {
        this.amountDeposit.add(amount);
    }

    public void withDrawal(Amount amount) {
        amountWithDrawal = amount;
    }

    public void print() {
        StringBuilder statement = new StringBuilder();
        if (amountDeposit.size() > 0) {
            double balance = 0;
            for (Amount amount : amountDeposit) {
                balance += amount.money;
                statement.insert(0, "\n10/01/2012 || " + formatAmount(amount.money) + " || || " + formatAmount(balance));
            }
        } else if (null != amountWithDrawal) {
            statement.insert(0, "\n10/01/2012 || || " + formatAmount(amountWithDrawal.money) + " || -" + formatAmount(amountWithDrawal.money));
        }
        printer.print(STATEMENT_TITLE + statement);
    }

    private String formatAmount(double account) {
        return String.format("%.2f", account).replace(',', '.');
    }

}
