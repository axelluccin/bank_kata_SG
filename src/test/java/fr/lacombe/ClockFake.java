package fr.lacombe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ClockFake implements ClockOperation {

    private final Queue<String> dateTimes;

    public ClockFake(String... dateTimes) {
        this.dateTimes = new LinkedList<>(Arrays.asList(dateTimes));
    }

    @Override
    public String dateTime() {
        return dateTimes.poll();
    }
}
