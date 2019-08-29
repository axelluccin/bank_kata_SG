package fr.lacombe;

public class Operation {
    private final OperationType operationType;
    public Amount amount;

    public Operation(OperationType operationType, Amount amount) {
        this.operationType = operationType;
        this.amount = amount;
    }

    public boolean getType(OperationType operationType) {
        return operationType.equals(this.operationType);
    }
}
