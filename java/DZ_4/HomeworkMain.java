package DZ_4;

public class HomeworkMain {

    public static void main(String[] args) {
//        Box<String> stringBox = new Box(); // запрещено!

        Box<Apple> apples = new Box();
        apples.add(new Apple(1.0, "Красное"));
        apples.add(new Apple(2.0,"Зеленое"));
        apples.add(new Apple(3.0, "Желтое"));
//        apples.add(new Orange(3.0, "few")); // запрещено!!!
        apples.add(new GoldenApple(3.0, "Коричневое")); // разрешено
        System.out.println(apples.toString());
        System.out.println(apples.getSumWeight()); // 9.0
//
        Box<Orange> orangeBox = new Box();
        orangeBox.add(new Orange(1.0, "Синее"));
//        orangeBox.add(new Apple(1.0, "erg")); // запрещено!!!
        System.out.println(orangeBox.getSumWeight()); // 1.0

        Box<GoldenApple> goldenAppleBox = new Box();
        goldenAppleBox.add(new GoldenApple(2.0, "Желтое"));
//       goldenAppleBox.add(new Apple(2.0, "ggre")); // запрещено!
        System.out.println(goldenAppleBox.getSumWeight()); // 2.0
//
//
        goldenAppleBox.moveTo(apples); // можно
        System.out.println(goldenAppleBox.getSumWeight()); // 0.0
        System.out.println(apples); // 9.0 + 2.0 = 11.0
//
////        apples.moveTo(goldenAppleBox); // нельзя!
//        orangeBox.moveTo(apples); // нельзя
    }

}
