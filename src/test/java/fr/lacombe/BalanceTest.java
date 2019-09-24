package fr.lacombe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BalanceTest {
    @Test
    public void deposite_of_500_return_balance_of_500() {
        Balance balance = new Balance(0);

        Balance balanceResult = balance.deposit(new Amount(500.0));

        assertThat(balanceResult).isEqualTo(new Balance(500.0));
    }

    @Test
    public void deposite_500_and_1000_return_balance_1500() {
        Balance balance = new Balance(0);

        Balance balanceResult = balance
                .deposit(new Amount(500.0))
                .deposit(new Amount(1000.0));

        assertThat(balanceResult).isEqualTo(new Balance(1500.0));
    }

    @Test
    public void deposite_1000_and_withdrawal_500_return_balance_500() {
        Balance balance = new Balance(0);

        Balance balanceResult = balance
                .deposit(new Amount(1000.0))
                .withdrawal(new Amount(500.0));

        assertThat(balanceResult).isEqualTo(new Balance(500.0));
    }
}
