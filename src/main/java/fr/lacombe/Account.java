package fr.lacombe;

import Balance.Balance;

import static fr.lacombe.OperationType.Deposit;
import static fr.lacombe.OperationType.Withdrawal;

public class Account {
    private static final String STATEMENT_TITLE = "date || credit || debit || balance";
    private final PrinterStatement printer;
    private OperationsHistory operationsHistory;

    public Account(PrinterStatement printer, OperationsHistory operationsHistory) {
        this.printer = printer;
        this.operationsHistory = operationsHistory;
    }

    public void deposit(Amount amount) {
        operationsHistory.add(Deposit, amount);
    }

    public void withdrawal(Amount amount) {
        operationsHistory.add(Withdrawal, amount);
    }

    public void print() {
        StringBuilder statement = getStatement();
        printer.print(STATEMENT_TITLE + statement);
    }

    private StringBuilder getStatement() {
        StringBuilder statement = new StringBuilder();
        Balance balance = new Balance(0);
        for (Operation operation : operationsHistory.getAll()) {
            balance = balance.calculate(operation);
            statement.insert(0, "\n10/01/2012 || "
                    + operation.formatDeposit() + "|| "
                    + operation.formatWithdrawal() + "|| "
                    + formatAmount(balance));
        }
        return statement;
    }

    private String formatAmount(Balance account) {
        return String.format("%.2f", account.balance).replace(',', '.');
    }
}
