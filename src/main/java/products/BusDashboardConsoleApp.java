package products;

import application.adapters.SearchApiGateway;
import application.usecases.Connection;
import application.usecases.ViewDepartures;
import application.usecases.ViewDeparturesUseCase;

import java.io.Console;


public class BusDashboardConsoleApp {

    private void start() {
        ConsolePresenter presenter = new ConsolePresenter();
        ViewDepartures viewDepartures = new ViewDeparturesUseCase(new SearchApiGateway(), presenter);

        viewDepartures.invokeWith(
                Connection.from("Zürich, Glaubtenstrasse").to("Zürich, Strassenverkehrsamt"),
                Connection.from("Zürich, Glaubtenstrasse").to("Zürich, Holzerhurd")
        );

        Console console = System.console();
        console.printf(presenter.asString());
    }

    public static void main(String[] args) {
        BusDashboardConsoleApp busDashboardConsoleApp = new BusDashboardConsoleApp();
        busDashboardConsoleApp.start();
    }
}
