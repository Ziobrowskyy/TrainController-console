package com.ziobrowski;

interface LambdaTest {
    int lambda(int x, int y);
}

public class Main {

    public static void main(String[] args) {


        TrainStationContainer container = new TrainStationContainer();
        container.addStation("ts1", 10);
        container.addStation("ts2", 20);
        container.addStation("ts3", 5);

        TrainStation ts1 = container.getStationByName("ts1");
        TrainStation ts2 = container.getStationByName("ts2");

        Train tt1 = new CargoTrain("c", 1, ts1, ts1);
        Train tt2 = new CargoTrain("c", 1, ts1, ts1);
        if(tt1 == tt2) {
            System.out.println("TAK SA TE SAME");
        } else {
            System.out.println("NIE SA TE SAME");
        }

        Train t1 = new CargoTrain("cargo 1", 50, ts1, ts1, new Time(5, 0));
        Train t2 = new PassengerTrain("pass 1", 100, ts1, ts2);
        Train t3 = new PassengerTrain("pass 2", 100, ts1, ts2);

        ts1.addTrain(t1, 10,20);
        ts1.addTrain(t1, 11, 30);

        ts1.addTrain(t2, 9, 10);


        container.printInfo();
        ts1.printInfo();
        System.out.println("----SORTED BY DEPART----");
        System.out.println(ts1.getSortedByDepartures());
        System.out.println("------------------------");
        System.out.println("----SORTED BY NAME----");
        System.out.println(ts1.getSortedByName());
        System.out.println("----------------------");




    }
}
