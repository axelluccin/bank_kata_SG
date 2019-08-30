package fr.lacombe;

public class Operation {
    private final OperationType operationType;
    private final Amount amount;

    private final String dateTime;

    public Operation(OperationType operationType, Amount amount, String dateTime) {
        this.operationType = operationType;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public double amountMoney() {
        return operationType.amountMoney(amount.money);
    }

    public String formatWithdrawal() {
        return operationType.formatWithdrawal(amount.money);
    }

    public String formatDeposit() {
        return operationType.formatDeposit(amount.money);
    }

}
