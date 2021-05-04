package com.ziobrowski;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainStationContainer {
    Map<String, TrainStation> trainStationMap = new HashMap<>();

    public void addStation(String name, int capacity) {
        trainStationMap.putIfAbsent(name, new TrainStation(name, capacity));
    }

    public TrainStation getStationByName(String name) {
        return trainStationMap.get(name);
    }
    public void removeStationByName(String name) {
         trainStationMap.remove(name);
    }
    public List<TrainStation> getEmpty() {
        return trainStationMap.values()
                .stream()
                .filter(ts -> ts.trains.isEmpty())
                .collect(Collectors.toList());
    }
    public void printInfo() {
        System.out.println("----TRAIN STATION CONTAINER INFO:----");
        for(TrainStation trainStation : trainStationMap.values()) {
            System.out.println("TS name: " + trainStation.name);
            System.out.println("Load: " + trainStation.trains.size() + "/" + trainStation.maximalCapacity);
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }
}
