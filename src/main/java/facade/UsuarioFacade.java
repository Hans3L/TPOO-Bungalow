package main.java.facade;

import main.java.dao.UsuarioDao;
import main.java.dao.UsuarioImpl;
import main.java.dto.UsuarioDto;

import java.util.List;

public class UsuarioFacade {
    private UsuarioImpl usuarioImpl;

    public UsuarioFacade() {
        this.usuarioImpl = new UsuarioDao();
    }

    public void registerBungalow(UsuarioDto usuario) {
        usuarioImpl.registerUsuario(usuario);
    }

    public UsuarioDto getUsuario(int id) {
        return usuarioImpl.getUsuario(id);
    }

    public void updateBungalow(UsuarioDto usuario) {
        usuarioImpl.updateUsuario(usuario);
    }

    public void deleteBungalow(int id) {
        usuarioImpl.deleteUsuario(id);
    }

    public List<UsuarioDto> getAllBungalow() {
        return usuarioImpl.getAllUsuario();
    }
}
