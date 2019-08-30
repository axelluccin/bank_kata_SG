package fr.lacombe;

import java.util.ArrayList;
import java.util.List;

public class OperationsHistory {
    private List<Operation> historyOperation = new ArrayList<>();

    public void add(OperationType operationType, Amount amount, String dateTime, Balance balance) {
        historyOperation.add(new Operation(operationType, amount, dateTime, balance));
    }

    public List<Operation> getAll() {
        return historyOperation;
    }
}
