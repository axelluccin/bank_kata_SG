package fr.lacombe;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private PrinterFake printed;
    private Account account;

    @Before
    public void setUp() throws Exception {
        printed = new PrinterFake();
        OperationsHistory operationsHistory = new OperationsHistory();
        FormatterOperation formatterOperation = new FormatterOperation();
        account = new Account(printed, operationsHistory, formatterOperation, new ClockFake("10/01/2012", "12/01/2012"));
    }

    @Test
    public void no_operation_on_account_print_only_title() {
        account.print();
        String actual = printed.getPrinted();
        assertThat(actual).isEqualTo("date || credit || debit || balance");
    }

    @Test
    public void deposit_1000_on_account_print_title_and_one_line_of_statement() {
        account.deposit(new Amount(BigDecimal.valueOf(1000.00)));
        account.print();
        String actual = printed.getPrinted();
        assertThat(actual)
                .isEqualTo("date || credit || debit || balance\n10/01/2012 || 1000.00 || || 1000.00");
    }

    @Test
    public void deposit_2000_on_account_print_title_and_one_line_of_statement() {
        account.deposit(new Amount(BigDecimal.valueOf(2000.00)));
        account.print();
        String actual = printed.getPrinted();
        assertThat(actual).isEqualTo("date || credit || debit || balance\n" +
                "10/01/2012 || 2000.00 || || 2000.00");
    }

    @Test
    public void deposit_1000_and_2000_on_account_print_title_and_two_line_of_statement() {
        account.deposit(new Amount(BigDecimal.valueOf(2000.00)));
        account.deposit(new Amount(BigDecimal.valueOf(1000.00)));
        account.print();
        String actual = printed.getPrinted();
        assertThat(actual).isEqualTo("date || credit || debit || balance\n" +
                "12/01/2012 || 1000.00 || || 3000.00\n" +
                "10/01/2012 || 2000.00 || || 2000.00");
    }

    @Test
    public void withdrawal_500_on_account_print_title_and_one_line_of_statement() {
        account.withdrawal(new Amount(BigDecimal.valueOf(500.00)));

        account.print();
        String actual = printed.getPrinted();
        assertThat(actual).isEqualTo("date || credit || debit || balance\n" +
                "10/01/2012 || || 500.00 || -500.00");
    }

    @Test
    public void withdrawal_500_and_1000_on_account_print_title_and_two_line_of_statement() {
        account.withdrawal(new Amount(BigDecimal.valueOf(500.00)));
        account.withdrawal(new Amount(BigDecimal.valueOf(1000.00)));

        account.print();
        String actual = printed.getPrinted();
        assertThat(actual).isEqualTo("date || credit || debit || balance\n" +
                "12/01/2012 || || 1000.00 || -1500.00\n" +
                "10/01/2012 || || 500.00 || -500.00");
    }

    @Test
    public void deposit_1000_and_withdrawal_500_print_two_lines_of_statement() {
        account.deposit(new Amount(BigDecimal.valueOf(1000.00)));
        account.withdrawal(new Amount(BigDecimal.valueOf(500.00)));

        account.print();
        String actual = printed.getPrinted();
        assertThat(actual).isEqualTo("date || credit || debit || balance\n" +
                "12/01/2012 || || 500.00 || 500.00\n" +
                "10/01/2012 || 1000.00 || || 1000.00");
    }
}
