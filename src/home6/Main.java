package home6;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;
import java.util.HashMap;

//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//        Создать множество ноутбуков.
//        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
//        Например:
//        Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет …
//        Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
//        Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
//        Работу сдать как обычно ссылкой на гит репозиторий
//        Частые ошибки:
//        1. Заставляете пользователя вводить все существующие критерии фильтрации
//        2. Невозможно использовать более одного критерия фильтрации одновременно
//        3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
//        4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков или добавить еще ноутбук, то программа начинает работать некорректно
public class Main {
    public static void main(String[] args) {
        Set<Laptop> laps = new HashSet<>();
        Laptop lap1 = new Laptop();
        lap1.name = "lenovo 123";
        lap1.hdd = 512;
        lap1.ram = 8;
        lap1.os = "win10";
        lap1.colour = "белый";

        Laptop lap2 = new Laptop();
        lap2.name = "Asus 321";
        lap2.hdd = 1024;
        lap2.ram = 16;
        lap2.os = "win11";
        lap2.colour = "черный";

        Laptop lap3 = new Laptop();
        lap3.name = "acer 444";
        lap3.hdd = 2048;
        lap3.ram = 8;
        lap3.os = "win10";
        lap3.colour = "черный";

        Laptop lap4 = new Laptop();
        lap4.name = "hp 2123";
        lap4.hdd = 2048;
        lap4.ram = 16;
        lap4.os = "win11";
        lap4.colour = "белый";

        laps.add(lap1);
        laps.add(lap2);
        laps.add(lap3);
        laps.add(lap4);

        print(laps);

        Filter filter = new Filter();

        Scanner in = new Scanner(System.in);
        int i = 0;
        while (i!=4) {
            if (i==0) {
                System.out.printf("%nВыберете необходимый фильтр: %n"+
                        "1.Объем HDD %n" +
                        "2.Объем ОЗУ %n" +
                        "3.Поиск по параметрам %n" +
                        "4.Выход %n");
                i = in.nextInt();
            }
            else if (i==1){
                System.out.println("введите объем памяти от 500 до 2048");
                String HDD = in.next();
                filter.addHdd(HDD);
                i = 0;
            }
            else if (i==2) {
                System.out.println("введите объем памяти от 8 до 16");
                String Ram = in.next();
                filter.addRam(Ram);
                i = 0;
            }
            else if (i==3) {
                Set<Laptop> result = new HashSet<>();
                result = selectByFilter(laps,filter);
                if(result.isEmpty()) {
                    System.out.printf("%nНе найдено ноутбуков по заданным параметрам");
                    i = 0;
                }
                else {
                    System.out.printf("%nНоутбуки по заданным параметрам: ");
                    print(result);
                    i = 0;
                }

            }
            else{
                System.out.println("что-то не так попробуйте снова");
                i=0;
            }
        }



    }
    static Set<Laptop> selectByFilter(Set<Laptop> laps, Filter filter){
        Set<Laptop> result = new HashSet<>();
        for (Laptop lap: laps){
            if (lap.hdd >= filter.getHdd() && lap.ram >= filter.getRam()){
                result.add(lap);
            }
        }
        return result;
    }


    static void print (Set<Laptop> laptops){
        for (Laptop lap: laptops) {
            System.out.println(lap);

        }
    }

}
