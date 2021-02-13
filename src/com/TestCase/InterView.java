package com.TestCase;

import java.util.ArrayList;
import java.util.List;

abstract class Car {
    protected double speed = 0;

    abstract void pushAccelerate(double pressure);

    abstract void pushBreake(double pressure);

    public double getSpeed() {
        return speed;
    }
}

class Ferrari extends Car{
    final double maximumLimit = 250;

    @Override
    void pushAccelerate(double pressure){
        speed += 0.5 * pressure;
        if(speed > maximumLimit) {
            speed = maximumLimit;
        }
    }

    @Override
    void pushBreake(double pressure) {

    }

    @Override
    public String toString() {
        return "Italian Ferrari";
    }
}

public class InterView {
    public static void main(String[] args) {
        List<Car> myCarCollection = new ArrayList<Car>();
        myCarCollection.add(new Ferrari());
        
        int n = 1000;
        for (int i = 0; i < n; i++) {
            double pressure = 10;
            for (Car car : myCarCollection) {
                car.pushAccelerate(pressure);
                System.out.println("Speed of "+car+" is "+car.getSpeed());
            }
            System.out.println();
        }
    }
}
