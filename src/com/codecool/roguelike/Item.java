package com.codecool.roguelike;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class Item extends GameObject {

    private String name;
    private String symbol;

<<<<<<< HEAD

    public Item(int width, int height, String name, String symbol, Coordinates pivot) {
=======
    public Item(String name, String symbol, Coordinates pivot) {
>>>>>>> 02e5d8cd3b58b60e62246d719aa624ba3a52726b
        super(pivot, symbol);
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.symbol;

    }


}
