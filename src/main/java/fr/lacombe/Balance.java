package fr.lacombe;

import java.util.Objects;

public class Balance {
    public final double balance;

    public Balance(double balance) {
        this.balance = balance;
    }

    public Balance calculate(Operation operation) {
        return new Balance(this.balance + operation.amountMoney());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance1 = (Balance) o;
        return Double.compare(balance1.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance=" + balance +
                '}';
    }

    String formatAmount() {
        return String.format("%.2f", balance).replace(',', '.');
    }
}
