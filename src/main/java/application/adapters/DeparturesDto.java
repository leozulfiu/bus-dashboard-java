package application.adapters;

import application.usecases.Departure;
import application.usecases.Departures;

import java.util.List;

public class DeparturesDto {
    public List<ConnectionDto> connections;

    public Departures toDepartures() {
        Departures departures = new Departures();
        for (ConnectionDto connectionDto : connections) {
            Departure departure = Departure.atExactTime(connectionDto.departure).withDelay(connectionDto.departure_delay);
            departures = departures.withNew(departure);
        }
        return departures;
    }
}
