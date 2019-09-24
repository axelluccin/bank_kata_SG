package fr.lacombe;

public class Operation {
    private final OperationType operationType;
    private final Amount amount;
    private final String dateTime;
    private final Balance balance;


    public Operation(OperationType operationType, Amount amount, String dateTime, Balance balance) {
        this.operationType = operationType;
        this.amount = amount;
        this.dateTime = dateTime;
        this.balance = balance;
    }

    public String formatWithdrawal() {
        return operationType.formatWithdrawal(amount.money.doubleValue());
    }

    public String formatDeposit() {
        return operationType.formatDeposit(amount.money.doubleValue());
    }

    public String dateTime() {
        return dateTime;
    }

    public String balanceOperation() {
        return balance.formatAmount();
    }
}
