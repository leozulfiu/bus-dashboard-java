package application.ports;

import application.usecases.Departures;
import application.usecases.Connection;

public interface DepartureTimesGateway {
    Departures fetchDeparturesFor(Connection connection);
}
