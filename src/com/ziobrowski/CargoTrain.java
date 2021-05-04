package com.ziobrowski;

public class CargoTrain extends Train {
    public CargoTrain(String name, int capacity, TrainStation origin, TrainStation destination) {
        this(TrainState.NEW, name, capacity, origin, destination, new Time(1, 0));
    }
    public CargoTrain(String name, int capacity, TrainStation origin, TrainStation destination, Time travelTime) {
        this(TrainState.NEW, name, capacity, origin, destination, travelTime);
    }
    public CargoTrain(TrainState state, String name, int capacity, TrainStation origin, TrainStation destination, Time travelTime) {
        super(TrainType.CARGO, state, name, capacity, origin, destination, travelTime);
    }
}
