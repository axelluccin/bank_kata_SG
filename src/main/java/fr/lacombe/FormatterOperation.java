package fr.lacombe;

import java.util.Collections;
import java.util.List;

public class FormatterOperation {
    private static final String STATEMENT_TITLE = "date || credit || debit || balance";

    public StringBuilder getStatement(OperationsHistory operationsHistory) {
        StringBuilder statement = new StringBuilder();
        List<Operation> all = operationsHistory.getAll();
        Collections.reverse(all);
        for (Operation operation : all) {
            statement.append("\n")
                    .append(operation.dateTime())
                    .append(" || ")
                    .append(operation.formatDeposit())
                    .append("|| ")
                    .append(operation.formatWithdrawal())
                    .append("|| ")
                    .append(operation.balanceOperation());
        }
        return statement.insert(0, STATEMENT_TITLE);
    }
}
