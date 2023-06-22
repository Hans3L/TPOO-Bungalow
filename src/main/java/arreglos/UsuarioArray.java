package main.java.arreglos;

import main.java.dto.UsuarioDto;

import java.util.ArrayList;

public class UsuarioArray {
    private ArrayList<UsuarioDto> cu;
    private String file;

    public UsuarioArray(String file) {
        cu = new ArrayList<UsuarioDto>();
        cu.add(new UsuarioDto(10001, "70069905", "Ana", "gamboa", "99999999"));
        cu.add(new UsuarioDto(10002, "70068505", "Sofia", "Lanzaduri", "98989898"));
        cu.add(new UsuarioDto(10003, "70048305", "Kiara", "Benavente", "9797979797"));
        cu.add(new UsuarioDto(10004, "70168305", "Rebeca", "Maldini", "9696969696"));
        this.file = file;
    }

    public void add(UsuarioDto e) {

        cu.add(e);
    }

    //eliminar

    public void delete(UsuarioDto cl) {

        cu.remove(cl);

    }

    //tamaño

    public int size() {

        return cu.size();

    }

    //obtener

    public UsuarioDto obtain(int index) {

        return cu.get(index);

    }


    //buscar

    public UsuarioDto search(int i) {
        UsuarioDto cu;
        for (int j = 0; j < size(); j++) {
            cu = obtain(j);
            if (cu.getUserId() == i)
                return cu;
        }
        return null;
    }
}
