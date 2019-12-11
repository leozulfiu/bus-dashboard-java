package application.usecases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartureTimeTableDocument {
    private final Map<Connection, Departures> allDepartures = new HashMap<>();

    void add(Connection connection, Departures departures) {
        allDepartures.put(connection, departures);
    }

    public List<Departure> departures() {
        List<Departure> allDeps = new ArrayList<>();
        for (Departures departures : this.allDepartures.values()) {
            allDeps.addAll(departures.asList());
        }

        return allDeps;
    }
}
