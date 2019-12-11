package application.domain;

class Station {
    private final String stationName;

    Station(String stationName) {
        this.stationName = stationName;
    }

    String asString() {
        return stationName;
    }
}
