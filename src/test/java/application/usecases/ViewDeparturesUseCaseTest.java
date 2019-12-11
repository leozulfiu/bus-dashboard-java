package application.usecases;

import application.presenters.DeparturePresenter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ViewDeparturesUseCaseTest {

    @Test
    void happyPath() {
        TestDeparturePresenter presenter = new TestDeparturePresenter();
        ViewDepartures viewDepartures = new ViewDeparturesUseCase(new MockedDepartureGateway(), presenter);

        Connection connection = Connection.from("Zürich, Rathaus").to("Zürich, Bucheggplatz");
        viewDepartures.invokeWith(connection);

        List<Departure> departuresToPresent = presenter.getDocument().departures();
        assertThat(departuresToPresent).contains(Departure.at("2019-12-05 14:36").withDelay(3));
    }

    private static class TestDeparturePresenter implements DeparturePresenter {
        private DepartureTimeTableDocument document;

        DepartureTimeTableDocument getDocument() {
            return document;
        }

        @Override
        public void present(DepartureTimeTableDocument departureTimeTableDocument) {
            this.document = departureTimeTableDocument;
        }
    }
}
