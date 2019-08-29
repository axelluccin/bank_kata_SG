import fr.lacombe.Account;
import fr.lacombe.Amount;
import fr.lacombe.Operations;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BankAccpetanceTest {
    @Test
    public void deposit_and_withdrawal_on_account_print_the_statement() {
        // Setup
        PrinterFake printer = new PrinterFake();
        Operations operations = new Operations();
        Account account = new Account(printer, operations);
        account.deposit(new Amount(1000.00));
        account.deposit(new Amount(2000.00));
        account.withDrawal(new Amount(500.00));
        
        //test
        account.print();
        
        // assert
        Assertions.assertThat(printer.getPrinted()).
                isEqualTo("date || credit || debit || balance\n" +
                "14/01/2012 || || 500.00 || 2500.00\n" +
                "13/01/2012 || 2000.00 || || 3000.00\n" +
                "10/01/2012 || 1000.00 || || 1000.00");
    }
}
