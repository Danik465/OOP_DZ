package DZ_1.example.example2;

public class Main {
    public static void main(String[] args) throws  CheckFuelException {
        Car car = new Car("BMW",100 );
        String status = car.toString();
        System.out.println(status);

        car.StartBottun();

    }
}
