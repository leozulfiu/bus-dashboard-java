package products;

import application.presenters.DeparturePresenter;
import application.usecases.DepartureTimeTableDocument;

public class ConsolePresenter implements DeparturePresenter {

    private DepartureTimeTableDocument toPresent;

    @Override
    public void present(DepartureTimeTableDocument departureTimeTableDocument) {
        this.toPresent = departureTimeTableDocument;
    }


    public String asString() {
        StringBuilder stringBuilder = new StringBuilder();
        return null;
    }
}
