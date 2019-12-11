package application.adapters.gateways.dtos;

import application.domain.Departure;
import application.domain.Departures;

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
