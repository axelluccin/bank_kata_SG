package fr.lacombe;

public enum OperationType {
    Deposit {
        @Override
        double amountMoney(double amount) {
            return amount;
        }

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
        double amountMoney(double amount) {
            return -amount;
        }

        @Override
        String formatWithdrawal(double amount) {
            return formatAmount(amount) + " ";
        }

        @Override
        String formatDeposit(double amount) {
            return "";
        }
    };


    abstract double amountMoney(double amount);

    abstract String formatWithdrawal(double amount);

    abstract String formatDeposit(double amount);

    String formatAmount(double account) {
        return String.format("%.2f", account).replace(',', '.');
    }
}
