package fr.lacombe;

import java.util.Collections;
import java.util.List;

public class FormatterOperation {
    private static final String STATEMENT_TITLE = "date || credit || debit || balance";
    private static final String FORMAT_STATEMENT = "|| ";

    public StringBuilder buildStatement(OperationsHistory operationsHistory) {
        StringBuilder statement = new StringBuilder();
        List<Operation> operationsHistoryAll = operationsHistory.getAll();
        Collections.reverse(operationsHistoryAll);
        for (Operation operation : operationsHistoryAll) {
            statement.append("\n")
                    .append(operation.dateTime())
                    .append(" || ")
                    .append(operation.formatDeposit())
                    .append(FORMAT_STATEMENT)
                    .append(operation.formatWithdrawal())
                    .append(FORMAT_STATEMENT)
                    .append(operation.balanceOperation());
        }
        return statement.insert(0, STATEMENT_TITLE);
    }
}
