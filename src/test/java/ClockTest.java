import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ClockTest {
    @Test
    public void ask_for_clock() {
        ClockFake clockFake = new ClockFake();

        String actual = clockFake.dateTime();
        Assertions.assertThat(actual).isEqualTo("10/01/2012");

    }
}
