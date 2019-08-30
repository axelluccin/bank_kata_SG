package fr.lacombe;

public class FormatterOperation {
    private static final String STATEMENT_TITLE = "date || credit || debit || balance";

    public StringBuilder getStatement(OperationsHistory operationsHistory) {
        StringBuilder statement = new StringBuilder();
        for (Operation operation : operationsHistory.getAll()) {
            statement.insert(0, "\n" + operation.dateTime() + " || "
                    + operation.formatDeposit() + "|| "
                    + operation.formatWithdrawal() + "|| "
                    + operation.balanceOperation());
        }
        return statement.insert(0, STATEMENT_TITLE);
    }
}
