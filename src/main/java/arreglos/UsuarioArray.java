package main.java.arreglos;

import main.java.clases.Usuario;

import java.util.ArrayList;

public class UsuarioArray {
    private ArrayList<Usuario> cu;
    private String file;

    public UsuarioArray(String file) {
        cu = new ArrayList<Usuario>();
        cu.add(new Usuario(10001, "70069905", "Ana", "gamboa", "99999999"));
        cu.add(new Usuario(10002, "70068505", "Sofia", "Lanzaduri", "98989898"));
        cu.add(new Usuario(10003, "70048305", "Kiara", "Benavente", "9797979797"));
        cu.add(new Usuario(10004, "70168305", "Rebeca", "Maldini", "9696969696"));
        this.file = file;
    }

    public void add(Usuario e) {

        cu.add(e);
    }

    //eliminar

    public void delete(Usuario cl) {

        cu.remove(cl);

    }

    //tamaño

    public int size() {

        return cu.size();

    }

    //obtener

    public Usuario obtain(int index) {

        return cu.get(index);

    }


    //buscar

    public Usuario search(int i) {
        Usuario cu;
        for (int j = 0; j < size(); j++) {
            cu = obtain(j);
            if (cu.getUserId() == i)
                return cu;
        }
        return null;
    }
}
