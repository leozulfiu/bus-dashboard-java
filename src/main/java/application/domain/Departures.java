package application.domain;

import java.util.ArrayList;
import java.util.List;

public class Departures {
    private final List<Departure> departures = new ArrayList<>();

    public static Departures of(Departure... departures) {
        Departures newDepartures = new Departures();
        for (Departure departure : departures) {
            newDepartures.withNew(departure);
        }
        return newDepartures;
    }

    public Departures withNew(Departure departure) {
        this.departures.add(departure);
        return this;
    }

    public List<Departure> asList() {
        return this.departures;
    }
}
