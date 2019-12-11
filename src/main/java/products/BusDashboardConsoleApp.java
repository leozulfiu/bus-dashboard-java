package products;

import application.adapters.gateways.SearchApiGateway;
import application.adapters.presenters.ConsolePresenter;
import application.domain.Connection;
import application.usecases.ports.ViewDepartures;
import application.usecases.ViewDeparturesUseCase;


public class BusDashboardConsoleApp {

    private void start() {
        ConsolePresenter presenter = new ConsolePresenter();
        ViewDepartures viewDepartures = new ViewDeparturesUseCase(new SearchApiGateway(), presenter);

        viewDepartures.invokeWith(
                Connection.from("Zürich, Glaubtenstrasse").to("Zürich, Strassenverkehrsamt"),
                Connection.from("Zürich, Glaubtenstrasse").to("Zürich, Holzerhurd")
        );

        System.out.print(presenter.asPlainString());
    }

    public static void main(String[] args) {
        BusDashboardConsoleApp busDashboardConsoleApp = new BusDashboardConsoleApp();
        busDashboardConsoleApp.start();
    }
}
