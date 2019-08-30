package fr.lacombe;

public class FormatterOperation {
    private static final String STATEMENT_TITLE = "date || credit || debit || balance";

    public StringBuilder getStatement(OperationsHistory operationsHistory) {
        StringBuilder statement = new StringBuilder();
        Balance balance = new Balance(0);
        for (Operation operation : operationsHistory.getAll()) {
            balance = balance.calculate(operation);
            statement.insert(0, "\n" + operation.dateTime() + " || "
                    + operation.formatDeposit() + "|| "
                    + operation.formatWithdrawal() + "|| "
                    + balance.formatAmount());
        }
        return statement.insert(0, STATEMENT_TITLE);
    }
}
