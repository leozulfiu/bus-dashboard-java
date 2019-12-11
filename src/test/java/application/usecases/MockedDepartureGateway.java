package application.usecases;

import application.domain.Connection;
import application.domain.Departure;
import application.domain.Departures;
import application.usecases.ports.DepartureTimesGateway;

import java.time.LocalDateTime;
import java.time.Month;

public class MockedDepartureGateway implements DepartureTimesGateway {

    @Override
    public Departures fetchDeparturesFor(Connection connection) {
        return new Departures().withNew(
                Departure.at(LocalDateTime.of(2019, Month.OCTOBER, 5, 14, 36))
                .withDelay(3)
        );
    }
}
