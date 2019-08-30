package fr.lacombe;

import static fr.lacombe.OperationType.Deposit;
import static fr.lacombe.OperationType.Withdrawal;

public class Account {
    private final PrinterStatement printer;
    private final OperationsHistory operationsHistory;
    private final FormatterOperation formatterOperation;
    private ClockOperation clockOperation;
    private Balance balance = new Balance(0);

    public Account(PrinterStatement printer, OperationsHistory operationsHistory, FormatterOperation formatterOperation, ClockOperation clockOperation) {
        this.printer = printer;
        this.operationsHistory = operationsHistory;
        this.formatterOperation = formatterOperation;
        this.clockOperation = clockOperation;
    }

    public void deposit(Amount amount) {
        balance = balance.addDeposite(amount);
        operationsHistory.add(Deposit, amount, clockOperation.dateTime(), balance);
    }

    public void withdrawal(Amount amount) {
        balance = balance.addWithdrawal(amount);
        operationsHistory.add(Withdrawal, amount, clockOperation.dateTime(), balance);
    }

    public void print() {
        printer.print(this.formatterOperation.getStatement(operationsHistory).toString());
    }
}
