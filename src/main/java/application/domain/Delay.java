package application.domain;

import java.time.Duration;
import java.util.Objects;

public class Delay {
    static final Delay ZERO = new Delay(Duration.ZERO);

    private final Duration delay;

    private Delay(Duration delay) {
        this.delay = delay;
    }

    static Delay of(String prefixedDelayInMinutes) {
        String delayInMinutes = prefixedDelayInMinutes.substring(1);
        return new Delay(Duration.ofMinutes(Long.parseLong(delayInMinutes)));
    }

    static Delay of(int delayInMinutes) {
        return new Delay(Duration.ofMinutes(delayInMinutes));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delay delay1 = (Delay) o;
        return Objects.equals(delay, delay1.delay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delay);
    }
}
