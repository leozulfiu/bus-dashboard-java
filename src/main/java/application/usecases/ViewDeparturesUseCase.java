package application.usecases;

import application.ports.DepartureTimesGateway;
import application.presenters.DeparturePresenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewDeparturesUseCase implements ViewDepartures {
    private static final Logger LOG = LoggerFactory.getLogger(ViewDeparturesUseCase.class);

    private final DepartureTimesGateway departureTimesGateway;
    private final DeparturePresenter presenter;

    public ViewDeparturesUseCase(DepartureTimesGateway departureTimesGateway, DeparturePresenter presenter) {
        this.departureTimesGateway = departureTimesGateway;
        this.presenter = presenter;
    }

    @Override
    public void invokeWith(Connection... connections) {
        LOG.info("View Departures Use Case started...");

        DepartureTimeTableDocument departureTimeTableDocument = new DepartureTimeTableDocument();

        for (Connection connection : connections) {
            Departures departures = departureTimesGateway.fetchDeparturesFor(connection);
            departureTimeTableDocument.add(connection, departures);
        }

        presenter.present(departureTimeTableDocument);
    }
}
