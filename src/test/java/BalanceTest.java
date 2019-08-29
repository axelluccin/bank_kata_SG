import Balance.Balance;
import fr.lacombe.Amount;
import fr.lacombe.Operation;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BalanceTest {
    @Test
    public void deposite_of_500_return_balance_of_500() {
        Balance balance = new Balance();
        Operation operation = new Operation(null, new Amount(500.0));
        double balanceResult = balance.calculate(operation);
        assertThat(balanceResult).isEqualTo(500.0);
    }
}
