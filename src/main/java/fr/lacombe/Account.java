package fr.lacombe;

import static fr.lacombe.OperationType.Deposit;
import static fr.lacombe.OperationType.Withdrawal;

public class Account {
    private final PrinterStatement printer;
    private OperationsHistory operationsHistory;
    private final FormatterOperation formatterOperation;

    public Account(PrinterStatement printer, OperationsHistory operationsHistory, FormatterOperation formatterOperation) {
        this.printer = printer;
        this.operationsHistory = operationsHistory;
        this.formatterOperation = formatterOperation;
    }

    public void deposit(Amount amount) {
        operationsHistory.add(Deposit, amount);
    }

    public void withdrawal(Amount amount) {
        operationsHistory.add(Withdrawal, amount);
    }

    public void print() {
        printer.print(this.formatterOperation.getStatement(operationsHistory).toString());
    }
}
