package main.java.dao;

import main.java.dto.UsuarioDto;

import java.util.List;

public interface UsuarioImpl {
        void registerUsuario(UsuarioDto usuario);
        UsuarioDto getUsuario(int id);
        void updateUsuario(UsuarioDto usuario);
        void deleteUsuario(int id);
        List<UsuarioDto> getAllUsuario();
}
