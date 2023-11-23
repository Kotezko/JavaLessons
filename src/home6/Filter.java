package home6;

import java.util.HashMap;

public class Filter {
    private HashMap<Integer, String> params = new HashMap<>();

    //1 - Объем ЖД
//2 - ОЗУ
//3 - Операционная система
//4 - Цвет …

    public void addHdd(String Hdd) {
        params.put(1, Hdd);
    }
    public void addRam(String Ram) {
        params.put(2, Ram);
    }

    public int getHdd() {
        int hdd = 0;
        if(params.get(1)==null){
            return hdd;
        }
        else {
            hdd = Integer.parseInt(params.get(1));
            return hdd;
        }
    }
    public int getRam() {
        int ram = 0;
        if(params.get(2)==null){
            return ram;
        }
        else {
            ram = Integer.parseInt(params.get(2));
            return ram;
        }
    }
}
