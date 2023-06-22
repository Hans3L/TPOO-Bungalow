package main.java.arreglos;

import main.java.dto.BungalowDto;

import java.util.ArrayList;

public class BungalowArray {
    private ArrayList<BungalowDto> cb;
    private String file;

    public BungalowArray(String file) {
        cb = new ArrayList<BungalowDto>();
        cb.add(new BungalowDto(30001, 0, 100, 0));
        cb.add(new BungalowDto(30002, 1, 200, 0));
        cb.add(new BungalowDto(30003, 2, 500, 0));
        this.file = file;
    }

    public void add(BungalowDto bungalow) {
        cb.add(bungalow);
    }

    public void delete(BungalowDto bungalow) {
        cb.remove(bungalow);
    }

    public int size() {
        return cb.size();
    }

    public BungalowDto obtain(int index) {
        return cb.get(index);
    }

    public BungalowDto search(int i) {
        BungalowDto cb;
        for (int j = 0; j < size(); j++) {
            cb = obtain(i);
            if (cb.getBungalowId() == j)
                return cb;
        }
        return null;
    }
}
