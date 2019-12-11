package application.usecases.ports;

import application.domain.Connection;

public interface ViewDepartures {
    void invokeWith(Connection... connections);
}
