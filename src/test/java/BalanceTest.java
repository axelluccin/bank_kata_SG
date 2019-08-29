import Balance.Balance;
import fr.lacombe.Amount;
import fr.lacombe.Operation;
import org.junit.Test;

import static fr.lacombe.OperationType.Deposit;
import static fr.lacombe.OperationType.Withdrawal;
import static org.assertj.core.api.Assertions.assertThat;

public class BalanceTest {
    @Test
    public void deposite_of_500_return_balance_of_500() {
        Balance balance = new Balance();
        Operation operation = new Operation(Deposit, new Amount(500.0));

        double balanceResult = balance.calculate(operation);

        assertThat(balanceResult).isEqualTo(500.0);
    }

    @Test
    public void deposite_500_and_1000_return_balance_1500() {
        Balance balance = new Balance();
        Operation operationOf500 = new Operation(Deposit, new Amount(500.0));
        Operation operationOf1000 = new Operation(Deposit, new Amount(1000.0));

        balance.calculate(operationOf500);
        Double balanceResult = balance.calculate(operationOf1000);

        assertThat(balanceResult).isEqualTo(1500.0);
    }

    @Test
    public void deposite_1000_and_withdrawal_500_return_balance_500() {
        Operation operationDepositeOf1000 = new Operation(Deposit, new Amount(1000.0));
        Operation operationWithdrawalOf500 = new Operation(Withdrawal, new Amount(500.0));
        Balance balance = new Balance();

        balance.calculate(operationDepositeOf1000);
        Double balanceResult = balance.calculate(operationWithdrawalOf500);

        assertThat(balanceResult).isEqualTo(500.0);
    }
}
