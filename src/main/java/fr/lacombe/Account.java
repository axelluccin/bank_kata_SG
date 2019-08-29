package fr.lacombe;

import static fr.lacombe.OperationType.Deposit;
import static fr.lacombe.OperationType.Withdrawal;

public class Account {
    private static final String STATEMENT_TITLE = "date || credit || debit || balance";
    private final PrinterStatement printer;
    private Operations operations;

    public Account(PrinterStatement printer, Operations operations) {
        this.printer = printer;
        this.operations = operations;
    }

    public void deposit(Amount amount) {
        operations.add(Deposit, amount);
    }

    public void withDrawal(Amount amount) {
        operations.add(Withdrawal, amount);
    }

    public void print() {
        StringBuilder statement = getStringBuilder();

        printer.print(STATEMENT_TITLE + statement);
    }

    private StringBuilder getStringBuilder() {
        StringBuilder statement = new StringBuilder();
        double balance = 0;
        for (Operation operation : operations.getAll()) {
            String deposit;
            String withdrawal;
            balance = calculate(balance, operation);
            deposit = formatDeposit(operation);
            withdrawal = formatWithdrawal(operation);
            statement.insert(0, "\n10/01/2012 || " + deposit + "|| " + withdrawal + "|| " + formatAmount(balance));
        }
        return statement;
    }

    private String formatWithdrawal(Operation operation) {
        String withdrawal;
        if (operation.getType(Deposit)) {
            withdrawal = "";
        } else {
            withdrawal = formatAmount(operation.amount.money) + " ";
        }
        return withdrawal;
    }

    private String formatDeposit(Operation operation) {
        String deposit;
        if (operation.getType(Deposit)) {
            deposit = formatAmount(operation.amount.money) + " ";
        } else {
            deposit = "";
        }
        return deposit;
    }

    private double calculate(double balance, Operation operation) {
        if (operation.getType(Deposit)) {
            balance += operation.amount.money;
        } else {
            balance -= operation.amount.money;
        }
        return balance;
    }

    private String formatAmount(double account) {
        return String.format("%.2f", account).replace(',', '.');
    }

}
