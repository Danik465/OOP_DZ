package DZ_4;

import java.util.ArrayList;
import java.util.List;

public class Box <E extends Fruit>{



    // Реализовать хранение фруктов в коробке.
    // Должны быть доступны следующие возможности
    // Добавление фрукта
    // Должен быть конструктор
    // Метод, который пересыпает фрукты из текущей коробки в другую коробку
    // Для внутреннего хранения можно использовать например List

    private List<E> list;
        public Box(){
            list = new ArrayList<>();
        }


    public void add(E fruit) {
        // TODO: 24.01.2023
        list.add(fruit);
    }
    
    public double getSumWeight() {
        // TODO: 24.01.2023 Просуммировать веса всех фруктов в коробке
        double sum = 0;
        for (int i = 0; i < list.size() ; i++) {
            sum += list.get(i).getWeight();
        }
        return sum;
    }

    public void moveTo(Box <E> anotherBox) {
        // TODO: 24.01.2023
        // Пересыпать фрукты из текущей коробки в anotherBox

    }

    @Override
    public String toString() {
        return "Список фруктов " + list.toString();
    }
}
