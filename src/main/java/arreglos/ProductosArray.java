package main.java.arreglos;

import main.java.clases.Productos;

import java.util.ArrayList;

public class ProductosArray {

    private ArrayList<Productos> cp;
    private String archivo;


    public ProductosArray(String archivo) {
        cp = new ArrayList<Productos>();

        cp.add(new Productos(20001, "Cerveza inglesa 250 ml", 10, 15.5));
        cp.add(new Productos(20002, "Snack mix Gigante", 8, 20.5));
        cp.add(new Productos(20003, "Botella de Champange", 2, 50.0));
        cp.add(new Productos(20004, "Wisky Label Red", 20, 200.0));
        cp.add(new Productos(20005, "Preservativos Piel", 150, 25.0));

        this.archivo = archivo;

    }


    //adicionar

    public void add(Productos productos) {

        cp.add(productos);
    }

    //eliminar

    public void delete(Productos productos) {

        cp.remove(productos);

    }

    //tamaño

    public int size() {

        return cp.size();

    }

    //obtener

    public Productos obtain(int index) {

        return cp.get(index);

    }


    //buscar

    public Productos search(int i) {
        Productos cp;
        for (int j = 0; j < size(); j++) {
            cp = obtain(j);
            if (cp.getProductId() == i)
                return cp;
        }
        return null;
    }
}
