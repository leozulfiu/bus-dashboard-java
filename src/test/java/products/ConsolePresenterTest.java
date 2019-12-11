package products;

import application.adapters.presenters.ConsolePresenter;
import application.domain.Connection;
import application.domain.Departure;
import application.usecases.DepartureTimeTableDocument;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConsolePresenterTest {

    @Test
    void happyPath() {
        ConsolePresenter consolePresenter = new ConsolePresenter();

        consolePresenter.present(aDocument());

        String output = consolePresenter.asPlainString();
        assertThat(output).isEqualTo(
                "From 'Zürich, Schwert' to 'Zürich, Wartau'\n" +
                "-----------------------------------------------\n" +
                "08:36           in 7 minutes\n" +
                "08:46           in 7 minutes\n\n"
        );
    }

    private DepartureTimeTableDocument aDocument() {
        DepartureTimeTableDocument document = new DepartureTimeTableDocument();
        document.add(
                Connection.from("Zürich, Schwert").to("Zürich, Wartau"),
                Departure.at("2019-07-21 08:36"),
                Departure.at("2019-07-21 08:46"));
        return document;
    }
}
