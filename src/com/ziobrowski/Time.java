package com.ziobrowski;

public class Time implements Comparable<Time> {
    int hour;
    int minute;

    Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int Funkcolambda(LambdaTest a) {
        return a.lambda(10,20);
    }

    @Override
    public String toString() {
        return "" + padLeft(hour) + ":" + padLeft(minute);
    }

    @Override
    public int compareTo(Time o) {
        if (this.hour == o.hour) {
            return Integer.compare(this.minute, o.minute);
        }
        return Integer.compare(this.hour, o.hour);
    }

    public boolean equals(Time o) {
        return this.hour == o.hour && this.minute == o.minute;
    }

    private String padLeft(int n) {
        return String.format("%02d", n);
    }
}

