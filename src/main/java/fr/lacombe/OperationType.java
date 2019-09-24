package fr.lacombe;

public enum OperationType {
    Deposit {
        @Override
        String formatWithdrawal(double amount) {
            return "";
        }

        @Override
        String formatDeposit(double amount) {
            return formatAmount(amount) + " ";
        }
    },
    Withdrawal {
        @Override
        String formatWithdrawal(double amount) {
            return formatAmount(amount) + " ";
        }

        @Override
        String formatDeposit(double amount) {
            return "";
        }
    };

    abstract String formatWithdrawal(double amount);

    abstract String formatDeposit(double amount);

    String formatAmount(double account) {
        return String.format("%.2f", account).replace(',', '.');
    }
}
