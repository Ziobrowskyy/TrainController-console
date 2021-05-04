package com.ziobrowski;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TrainStation {

    String name;
    Map<Train, List<Time>> trains = new HashMap<>();
    int maximalCapacity;

    TrainStation(String name, int capacity) {
        this.name = name;
        this.maximalCapacity = capacity;
    }

    public boolean addTrain(Train train, int hour, int minute) {
        if (trains.size() < maximalCapacity) {
            trains.putIfAbsent(train, new ArrayList<>());
            trains.get(train).add(new Time(hour, minute));
            trains.get(train).sort(Time::compareTo);
            return true;
        }
        System.out.println("Nie można dodać nowego pociągu - stacja jest pełna!");
        return false;
    }

    public boolean addTrain(Train train) {
        return this.addTrain(train, 13, 37);
    }

    public Train findTrainByName(String name) {
        for (Train train : trains.keySet()) {
            if (train.name.compareTo(name) == 0)
                return train;
        }
        System.out.println("Nie znaleziono pociągu o podanej nazwie!");
        return null;
    }

    public List<Train> findTrainsByName(String name) {
        return this.trains.keySet()
                .stream()
                .filter(train -> train.name.contains(name))
                .collect(Collectors.toList());
    }


    public List<Train> findTrainsByState(TrainState state) {
        return this.trains.keySet()
                .stream()
                .filter(train -> train.state == state)
                .collect(Collectors.toList());
    }

    public List<Train> getSortedByName() {
        return this.trains.keySet()
                .stream()
                .sorted(Train::compareTo)
                .collect(Collectors.toList());
    }

    public List<Train> getSortedByDepartures() {
        return this.trains.entrySet()
                .stream()
                .sorted((p1, p2) -> Integer.compare(p2.getValue().size(), p1.getValue().size()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public boolean removeEarliestDeparture(Train train) {

        if (trains.containsKey(train)) {
            List<Time> times = trains.get(train);

            if (times.size() > 0) {
                times.remove(0);

                if (times.size() == 0) {
                    System.out.println("Usunięto ostatni odzjazd ze stacji");
                    this.removeTrain(train);
                }
                return true;
            }

            System.out.println("Pociąg nie ma odjazdów ze stacji!");
            return false;
        }
        System.out.println("Nie znaleziono danego pociągu na stacji!");
        return false;
    }

    public boolean removeTrain(Train train) {
        return trains.remove(train) == null;
    }

    public void printInfo() {
        System.out.println("----TRAIN STATION INFO:----");
        for(Train train : trains.keySet()) {
            System.out.println(train.toString());
        }
        System.out.println("---------------------------");
    }
}
