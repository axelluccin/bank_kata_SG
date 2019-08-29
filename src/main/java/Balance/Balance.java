package Balance;

import fr.lacombe.Operation;

import static fr.lacombe.OperationType.Deposit;

public class Balance {
    private double balance = 0;

    public double calculate(Operation operation) {
        if (operation.isType(Deposit)) {
            return this.balance += operation.amountMoney();
        }
        return this.balance -= operation.amountMoney();
    }
}
