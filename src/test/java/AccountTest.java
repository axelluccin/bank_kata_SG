import fr.lacombe.Account;
import fr.lacombe.Amount;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    @Test
    public void no_operation_on_account_print_only_title() {
        PrinterFake printed = new PrinterFake();
        Account account = new Account(printed);
        account.print();
        String actual = printed.getPrinted();
        assertThat(actual).isEqualTo("date || credit || debit || balance");
    }

    @Test
    public void deposit_1000_on_account_print_title_and_one_line() {
        PrinterFake printed = new PrinterFake();
        Account account = new Account(printed);
        account.deposit(new Amount(1000.00));
        account.print();
        String actual = printed.getPrinted();
        assertThat(actual)
                .isEqualTo("date || credit || debit || balance\n10/01/2012 || 1000.00 || || 1000.00");
    }

    @Test
    public void deposit_2000_on_account_print_title_and_one_line() {

        PrinterFake printed = new PrinterFake();
        Account account = new Account(printed);
        account.deposit(new Amount(2000.00));
        account.print();
        String actual = printed.getPrinted();
        assertThat(actual).isEqualTo("date || credit || debit || balance\n" +
                "10/01/2012 || 2000.00 || || 2000.00");
    }
}
