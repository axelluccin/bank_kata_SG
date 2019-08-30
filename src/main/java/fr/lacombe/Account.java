package fr.lacombe;

import static fr.lacombe.OperationType.Deposit;
import static fr.lacombe.OperationType.Withdrawal;

public class Account {
    private final PrinterStatement printer;
    private final OperationsHistory operationsHistory;
    private final FormatterOperation formatterOperation;
    private ClockOperation clockOperation;

    public Account(PrinterStatement printer, OperationsHistory operationsHistory, FormatterOperation formatterOperation, ClockOperation clockOperation) {
        this.printer = printer;
        this.operationsHistory = operationsHistory;
        this.formatterOperation = formatterOperation;
        this.clockOperation = clockOperation;
    }

    public void deposit(Amount amount) {
        String dateTime = clockOperation.dateTime();
        operationsHistory.add(Deposit, amount, dateTime);
    }

    public void withdrawal(Amount amount) {
        String dateTime = clockOperation.dateTime();
        operationsHistory.add(Withdrawal, amount, dateTime);
    }

    public void print() {
        printer.print(this.formatterOperation.getStatement(operationsHistory).toString());
    }
}
