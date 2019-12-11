package application.usecases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class Departure {
    private final LocalDateTime departureTime;
    private Delay departureDelay;

    private Departure(LocalDateTime departureTime) {
        this.departureTime = departureTime;
        this.departureDelay = Delay.ZERO;
    }

    public static Departure atExactTime(String departureDateTimeInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime departureTime = LocalDateTime.parse(departureDateTimeInput, formatter);
        return new Departure(departureTime);
    }

    public static Departure at(String departureDateTimeInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime departureTime = LocalDateTime.parse(departureDateTimeInput, formatter);
        return new Departure(departureTime);
    }

    public static Departure at(LocalDateTime departureTime) {
        return new Departure(departureTime);
    }

    public Departure withDelay(String delayInMinutes) {
        this.departureDelay = Delay.of(delayInMinutes);
        return this;
    }

    public Departure withDelay(int delayInMinutes) {
        this.departureDelay = Delay.of(delayInMinutes);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departure departure = (Departure) o;
        return departureTime.equals(departure.departureTime) &&
                departureDelay.equals(departure.departureDelay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureTime, departureDelay);
    }
}
