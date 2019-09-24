package fr.lacombe;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BalanceTest {
    @Test
    public void deposit_of_500_return_balance_of_500() {
        Balance balance = new Balance(BigDecimal.ZERO);

        Balance balanceResult = balance.deposit(new Amount(BigDecimal.valueOf(500.0)));

        assertThat(balanceResult).isEqualTo(new Balance(BigDecimal.valueOf(500.0)));
    }

    @Test
    public void deposit_500_and_1000_return_balance_1500() {
        Balance balance = new Balance(BigDecimal.ZERO);

        Balance balanceResult = balance
                .deposit(new Amount(BigDecimal.valueOf(500.0)))
                .deposit(new Amount(BigDecimal.valueOf(1000.0)));

        assertThat(balanceResult).isEqualTo(new Balance(BigDecimal.valueOf(1500.0)));
    }

    @Test
    public void deposit_1000_and_withdrawal_500_return_balance_500() {
        Balance balance = new Balance(BigDecimal.ZERO);

        Balance balanceResult = balance
                .deposit(new Amount(BigDecimal.valueOf(1000.0)))
                .withdrawal(new Amount(BigDecimal.valueOf(500.0)));

        assertThat(balanceResult).isEqualTo(new Balance(BigDecimal.valueOf(500.0)));
    }
}
