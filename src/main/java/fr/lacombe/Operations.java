package fr.lacombe;

import java.util.ArrayList;
import java.util.List;

public class Operations {
    private List<Operation> historyOperation = new ArrayList<>();

    public void add(OperationType operationType, Amount amount) {
        historyOperation.add(new Operation(operationType, amount));
    }

    public List<Operation> getAll() {
        return historyOperation;
    }
}
