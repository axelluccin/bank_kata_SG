package fr.lacombe;

public class Operation {
    private final OperationType operationType;
    private Amount amount;

    public Operation(OperationType operationType, Amount amount) {
        this.operationType = operationType;
        this.amount = amount;
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
