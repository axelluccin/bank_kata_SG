package fr.lacombe;

import static fr.lacombe.OperationType.Deposit;

public class Operation {
    private final OperationType operationType;
    private Amount amount;

    public Operation(OperationType operationType, Amount amount) {
        this.operationType = operationType;
        this.amount = amount;
    }

    public boolean getType(OperationType operationType) {
        return operationType.equals(this.operationType);
    }

    public double amountMoney() {
        return amount.money;
    }

    public String formatWithdrawal() {
        String withdrawal;
        if (getType(Deposit)) {
            withdrawal = "";
        } else {
            withdrawal = formatAmount(amountMoney()) + " ";
        }
        return withdrawal;
    }

    public String formatDeposit() {
        String deposit;
        if (getType(Deposit)) {
            deposit = formatAmount(amountMoney()) + " ";
        } else {
            deposit = "";
        }
        return deposit;
    }

    private String formatAmount(double account) {
        return String.format("%.2f", account).replace(',', '.');
    }

    double calculate(double balance) {
        if (getType(Deposit)) {
            balance += amountMoney();
        } else {
            balance -= amountMoney();
        }
        return balance;
    }
}
