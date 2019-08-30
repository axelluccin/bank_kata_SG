package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BankAcceptanceTest {
    @Test
    public void deposit_and_withdrawal_on_account_print_the_statement() {
        // Setup
        PrinterFake printer = new PrinterFake();
        OperationsHistory operationsHistory = new OperationsHistory();
        ClockFake clockOperation = new ClockFake("10/01/2012", "13/01/2012", "14/01/2012");
        Account account = new Account(printer, operationsHistory, new FormatterOperation(), clockOperation);
        account.deposit(new Amount(1000.00));
        account.deposit(new Amount(2000.00));
        account.withdrawal(new Amount(500.00));

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
