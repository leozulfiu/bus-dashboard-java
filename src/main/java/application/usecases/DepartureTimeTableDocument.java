package application.usecases;

import application.domain.Connection;
import application.domain.Departure;
import application.domain.Departures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartureTimeTableDocument {
    private final Map<Connection, Departures> allDepartures = new HashMap<>();

    void add(Connection connection, Departures departures) {
        allDepartures.put(connection, departures);
    }

    public void add(Connection connection, Departure... departures) {
        allDepartures.put(connection, Departures.of(departures));
    }

    public List<Departure> departures() {
        List<Departure> allDeps = new ArrayList<>();
        for (Departures departures : this.allDepartures.values()) {
            allDeps.addAll(departures.asList());
        }

        return allDeps;
    }

    public List<Connection> connections() {
        return new ArrayList<>(this.allDepartures.keySet());
    }

    public List<Departure> departuresFor(Connection connection) {
        return this.allDepartures.get(connection).asList();
    }
}
