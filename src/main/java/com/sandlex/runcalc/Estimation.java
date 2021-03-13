package com.sandlex.runcalc;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter(AccessLevel.PACKAGE)
public class Estimation {

    private long seconds;
    private double kilometers;

    void addSeconds(long increment) {
        this.seconds += increment;
    }

    void addKilometers(double increment) {
        this.kilometers += increment;
    }

    public String getFormattedTime() {
        long sec = seconds;
        long hours = TimeUnit.SECONDS.toHours(sec);
        sec -= TimeUnit.HOURS.toSeconds(hours);
        long minutes = TimeUnit.SECONDS.toMinutes(sec);
        sec -= TimeUnit.MINUTES.toSeconds(minutes);

        return String.format("%02d:%02d:%02d", hours, minutes, sec);
    }

    public long getTimeInSeconds() {
        return seconds;
    }

    public double getDistanceInUnits() {
        return kilometers;
    }

    @Override
    public String toString() {
        return String.format("Estimated distance - %.2f%s, time - %s", kilometers, "km", getFormattedTime());
    }
}
