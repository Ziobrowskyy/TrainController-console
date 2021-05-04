package com.ziobrowski;

enum TrainState {
    LATE,
    NEW,
    BROKEN,
    UNDEFINED
}

enum TrainType {
    PASSENGER,
    CARGO
}

abstract public class Train implements Comparable<Train> {
    TrainState state;
    String name;
    int capacity;
    TrainStation origin;
    TrainStation destination;
    TrainType type;
    Time travelTime;

    public Train(TrainType type, TrainState state, String name, int capacity, TrainStation origin, TrainStation destination, Time travelTime) {
        this.type = type;
        this.state = state;
        this.name = name;
        this.capacity = capacity;
        this.origin = origin;
        this.destination = destination;
        this.travelTime = travelTime;
    }


    @Override
    public String toString() {
        return String.format("""
                Name: %s
                Type: %s
                State: %s
                Capacity: %d
                Origin: %s, Destination: %s
                Travel time: %s
                """.stripIndent(), name, type, state, capacity, origin.name, destination.name, travelTime);
    }

    @Override
    public int compareTo(Train o) {
        return this.name.compareTo(o.name);
    }

}
