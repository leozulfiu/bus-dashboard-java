package application.usecases.ports;

import application.domain.Departures;
import application.domain.Connection;

public interface DepartureTimesGateway {
    Departures fetchDeparturesFor(Connection connection);
}
