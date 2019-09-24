package fr.lacombe;

import java.math.BigDecimal;
import java.util.Objects;

public class Balance {
    public final BigDecimal balance;

    public Balance(BigDecimal balance) {
        this.balance = balance;
    }

    public Balance deposit(Amount amount) {
        return new Balance(this.balance.add(amount.money));
    }

    public Balance withdrawal(Amount amount) {
        return new Balance(this.balance.subtract(amount.money));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance1 = (Balance) o;
        return Objects.equals(balance, balance1.balance);
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
