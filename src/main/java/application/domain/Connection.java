package application.domain;

public class Connection {
    private Station from;
    private Station to;

    public static Connection from(String fromStationInput) {
        Connection newConnection = new Connection();
        newConnection.from = new Station(fromStationInput);

        return newConnection;
    }

    public Connection to(String toStationInput) {
        if (this.from == null) {
            throw new RuntimeException("From was not specified");
        }
        this.to = new Station(toStationInput);
        return this;
    }

    public String from() {
        return from.asString();
    }

    public String to() {
        return to.asString();
    }
}
