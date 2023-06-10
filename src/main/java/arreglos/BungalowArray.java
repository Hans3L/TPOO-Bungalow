package main.java.arreglos;

import main.java.clases.Bungalow;

import java.util.ArrayList;

public class BungalowArray {
    private ArrayList<Bungalow> cb;
    private String file;

    public BungalowArray(String file) {
        cb = new ArrayList<Bungalow>();
        cb.add(new Bungalow(30001, 0, 100, 0));
        cb.add(new Bungalow(30002, 1, 200, 0));
        cb.add(new Bungalow(30003, 2, 500, 0));
        this.file = file;
    }

    public void add(Bungalow bungalow) {
        cb.add(bungalow);
    }

    public void delete(Bungalow bungalow) {
        cb.remove(bungalow);
    }

    public int size() {
        return cb.size();
    }

    public Bungalow obtain(int index) {
        return cb.get(index);
    }

    public Bungalow search(int i) {
        Bungalow cb;
        for (int j = 0; j < size(); j++) {
            cb = obtain(i);
            if (cb.getBungalowId() == j)
                return cb;
        }
        return null;
    }
}
