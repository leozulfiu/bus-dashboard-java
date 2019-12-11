package application.usecases;

public class Station {
    private final String stationName;

    public Station(String stationName) {
        this.stationName = stationName;
    }

    public String asString() {
        return stationName;
    }
}
