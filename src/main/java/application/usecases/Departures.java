package application.usecases;

import java.util.ArrayList;
import java.util.List;

public class Departures {
    private final List<Departure> departures = new ArrayList<>();

    public Departures withNew(Departure departure) {
        this.departures.add(departure);
        return this;
    }

    public List<Departure> asList() {
        return this.departures;
    }
}
