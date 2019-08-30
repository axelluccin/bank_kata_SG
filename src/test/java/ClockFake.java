import fr.lacombe.ClockOperation;

import java.util.LinkedList;
import java.util.Queue;

public class ClockFake implements ClockOperation {

    private final Queue<String> dateTimes;

    public ClockFake() {
        dateTimes = new LinkedList<>();
        dateTimes.add("10/01/2012");
        dateTimes.add("12/01/2012");
    }

    @Override
    public String dateTime() {
        return dateTimes.poll();
    }
}
