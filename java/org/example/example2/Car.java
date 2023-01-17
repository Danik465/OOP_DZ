package org.example.example2;

public class Car {
    private String model;
    private int fuel;
    private int chargeFuel;

    private void checkFuel(int fail) throws CheckFuelException {
        if(fail< 0){
             throw new CheckFuelException("Низкий уровень топлива");
        }

    }

    public Car(String mod , int fl,  int chargeFuel){
        this.model = mod;

        try{
            checkFuel(fl);
            this.fuel = fl;
        }catch (CheckFuelException e){
            System.err.println(e.getMessage());
        }
        this.chargeFuel = chargeFuel;
    }
    public Car(String mod, int fl){
        this(mod, fl, 15);
    }

    public String getModel() {
        return model;
    }

    public int getFuel() {
        return fuel;
    }
    public void StartBottun(){

        if(AvailFuel()){
            EngineOn();
        }
        System.out.println("Машина заведена");
    }
    private void EngineOn(){
        System.out.println("Двигатель включен!");
        fuel = fuel - chargeFuel;

    }
    private boolean AvailFuel(){
        if(fuel <=chargeFuel){
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Модель автомобиля - "+ getModel() + ", Топливо в автомобиле - " + getFuel();
    }
}
