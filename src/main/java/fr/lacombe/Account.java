package fr.lacombe;

import java.util.ArrayList;
import java.util.List;

import static fr.lacombe.OperationType.Deposit;

public class Account {
    private static final String STATEMENT_TITLE = "date || credit || debit || balance";
    private final PrinterStatement printer;
    private List<Amount> amountDeposit = new ArrayList<>();
    private List<Amount> amountWithDrawal = new ArrayList<>();
    private Operations operations;

    public Account(PrinterStatement printer, Operations operations) {
        this.printer = printer;
        this.operations = operations;
    }

    public void deposit(Amount amount) {
        amountDeposit.add(amount);
        operations.add(Deposit, amount);
    }

    public void withDrawal(Amount amount) {
        amountWithDrawal.add(amount);
    }

    public void print() {
        StringBuilder statement = getStringBuilder();
        FormatterOperation formatterOperation = new FormatterOperation();

        printer.print(STATEMENT_TITLE + statement);
    }

    private StringBuilder getStringBuilder() {
        StringBuilder statement = new StringBuilder();
        double balance = 0;
        for (Amount amount : amountDeposit) {
            balance += amount.money;
            statement.insert(0, "\n10/01/2012 || " + formatAmount(amount.money) + " || || " + formatAmount(balance));
        }
        for (Amount amount : amountWithDrawal) {
            balance -= amount.money;
            statement.insert(0, "\n10/01/2012 || || " + formatAmount(amount.money) + " || " + formatAmount(balance));
        }
        return statement;
    }

    private String formatAmount(double account) {
        return String.format("%.2f", account).replace(',', '.');
    }

}
