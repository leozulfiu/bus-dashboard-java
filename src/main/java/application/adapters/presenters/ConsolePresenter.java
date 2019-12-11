package application.adapters.presenters;

import application.domain.Connection;
import application.domain.Departure;
import application.usecases.ports.DeparturePresenter;
import application.usecases.DepartureTimeTableDocument;

public class ConsolePresenter implements DeparturePresenter {

    private DepartureTimeTableDocument toPresent;

    @Override
    public void present(DepartureTimeTableDocument departureTimeTableDocument) {
        this.toPresent = departureTimeTableDocument;
    }

    public String asPlainString() {
        StringBuilder output = new StringBuilder();
        for (Connection connection : toPresent.connections()) {
            output.append("From '");
            output.append(connection.from());
            output.append("' to '");
            output.append(connection.to());
            output.append("'\n");
            output.append("-----------------------------------------------\n");
            for (Departure departure : toPresent.departuresFor(connection)) {
                output.append(departure.time());
                output.append("           in ");
                int delay = 7;
                output.append(delay);
                output.append(" minutes\n");
            }
            output.append("\n");
        }

        return output.toString();
    }
}
