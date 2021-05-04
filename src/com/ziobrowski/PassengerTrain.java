package com.ziobrowski;

public class PassengerTrain extends Train {

    public PassengerTrain(String name, int capacity, TrainStation origin, TrainStation destination) {
        this(TrainState.NEW, name, capacity, origin, destination, new Time(1, 0));
    }
    public PassengerTrain(String name, int capacity, TrainStation origin, TrainStation destination, Time travelTime) {
        this(TrainState.NEW, name, capacity, origin, destination, travelTime);
    }
    public PassengerTrain(TrainState state, String name, int capacity, TrainStation origin, TrainStation destination, Time travelTime) {
        super(TrainType.PASSENGER, state, name, capacity, origin, destination, travelTime);
    }
}
