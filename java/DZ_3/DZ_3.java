package DZ_3;

import java.util.*;

public class DZ_3 {

    public static void main(String[] args) {
        // 1. Создать список объектов типа Notebook
        // Отсортировать его тремя способами:
        // 1.1 по ОЗУ (ram)
        // 1.2 по цене (price)
        // 1.3 сначала по ram, потом по price (если ram не равны, сортируем по ним; если равны, то по цене)

        // 2. Реализовать итератор для массива


        List<Notebook> notebooks = new ArrayList<>(List.of(new Notebook(1666, 5000),
                new Notebook(1666, 5500 ),
                new Notebook(1664, 6000),
                new Notebook(1333, 2300)));


        int[] source = {1, 2, 3, 4, 5, 6, 7};
        Iterator<Integer> intArrayIterator = new IntArrayIterator(source);
        while (intArrayIterator.hasNext()) {
            // FIXME: 20.01.2023 Должно работать!
            System.out.println(intArrayIterator.next());

        }

        Comparator<Notebook> compRAM= new Comparator<Notebook>() {
            @Override
            public int compare(Notebook o1, Notebook o2) {
                if(o1.getRam() > o2.getRam()){
                    return 1;
                }else if(o1.getRam() < o2.getRam()){
                    return -1;
                }else {
                    return 0;
                }


            }
        };
        Comparator<Notebook> compPrice= new Comparator<Notebook>() {
            @Override
            public int compare(Notebook o1, Notebook o2) {
                if(o1.getPrice() > o2.getPrice()){
                    return 1;
                }else if(o1.getPrice() < o2.getPrice()){
                    return -1;
                }else {
                    return 0;
                }


            }
        };
        Comparator<Notebook> compRAMPrice= new Comparator<Notebook>() {
            @Override
            public int compare(Notebook o1, Notebook o2) {
                if(o1.getRam() > o2.getRam()){
                    return 1;
                }else if(o1.getRam() < o2.getRam()){
                    return -1;
                }else {
                    if(o1.getPrice() > o2.getPrice()){
                        return 1;
                    }
                    else if(o1.getPrice() < o2.getPrice()){
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }


            }
        };
//        System.out.println("Сортировка по RAM:");
//        System.out.println(notebooks);
//        Collections.sort(notebooks,compRAM);
//        System.out.println(notebooks);
//        System.out.println("Сортировка по Price:");
//        System.out.println(notebooks);
//        Collections.sort(notebooks,compPrice);
//        System.out.println(notebooks);
        System.out.println("Сортировка по Ram, затем по Price:");
        System.out.println(notebooks);
        Collections.sort(notebooks,compRAMPrice);
        System.out.println(notebooks);

    }





}
