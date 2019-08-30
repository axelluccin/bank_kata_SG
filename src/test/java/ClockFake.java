import fr.lacombe.ClockOperation;

public class ClockFake implements ClockOperation {
    @Override
    public String dateTime() {
        return "10/01/2012";
    }
}
