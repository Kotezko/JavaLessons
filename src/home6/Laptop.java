package home6;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Laptop {
    String name;
    int ram;
    int hdd;
    String os;
    String colour;

    @Override
    public String toString() {
        return name + ", ram= " + ram + ", hdd= " + hdd + ", os= " + os + ", colour= " + colour;
    }

}


