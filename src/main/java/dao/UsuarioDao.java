package main.java.dao;

import main.java.config.UConnection;
import main.java.dto.UsuarioDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements UsuarioImpl{
    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    @Override
    public void registerUsuario(UsuarioDto usuario) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String insertUsuario = "INSERT INTO usuario (UserId, FirstName, LastName, Dni, Telefono) VALUES (?,?,?,?,?)";
            pstm = con.prepareStatement(insertUsuario);
            pstm.setInt(1, usuario.getUserId());
            pstm.setString(2, usuario.getName());
            pstm.setString(3, usuario.getLastName());
            pstm.setString(4, usuario.getDni());
            pstm.setString(5, usuario.getTelefono());
            int outcome = pstm.executeUpdate();
            if (outcome == 1) {
                con.commit();
                System.out.println("Se agrego una habitacion!");
            } else {
                throw new RuntimeException("No se pudo agregar habitacion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstm != null) pstm.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public UsuarioDto getUsuario(int usuarioId) {
        UsuarioDto usuarioDto = null;

        try (//Connection con = UConnection.getConnection();
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE UserId = ?")) {
            statement.setInt(1, usuarioId);
            //con = UConnection.getConnection();
            //String findIdBungalow = "SELECT bungalowId, category, priceDay, statusRoom FROM bungalow WHERE bungalowId = ? ";
            //pstm = con.prepareStatement(findIdBungalow);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    usuarioDto = new UsuarioDto();
                    usuarioDto.setUserId(rs.getInt("UserId"));
                    usuarioDto.setName(rs.getString("FirstName"));
                    usuarioDto.setLastName(rs.getString("LastName"));
                    usuarioDto.setDni(rs.getString("Dni"));
                    usuarioDto.setTelefono(rs.getString("Telefono"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return usuarioDto;
    }

    @Override
    public void updateUsuario(UsuarioDto usuario) {
    }

    @Override
    public void deleteUsuario(int id) {
        try (Connection con = UConnection.getConnection();
             PreparedStatement pstm = con.prepareStatement("DELETE FROM usuario WHERE UserId = ? ")) {
            con.setAutoCommit(false); //no sea por defecto el modo autocommit
            //String deleteRoom = "DELETE FROM bungalow WHERE bungalowId = ? ";
            //PreparedStatement pstm = con.prepareStatement(deleteRoom);
            pstm.setInt(1, id);
            int outcome = pstm.executeUpdate();

            if (outcome == 1) {
                con.commit(); //aceptamos la transaccion
            } else {
                throw new RuntimeException("Error al eliminar...");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                //if (con != null) con.rollback();
                if (pstm != null) pstm.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<UsuarioDto> getAllUsuario() {
        List<UsuarioDto> usuarioList = new ArrayList<>();

        try {
            con = UConnection.getConnection();
            String findUsuario = "SELECT UserId, FirstName, LastName, Dni, Telefono FROM usuario ";
            pstm = con.prepareStatement(findUsuario);
            rs = pstm.executeQuery();
            while (rs.next()) {
                UsuarioDto usuario = new UsuarioDto();
                usuario.setUserId(rs.getInt("UserId"));
                usuario.setName(rs.getString("FirstName"));
                usuario.setLastName(rs.getString("LastName"));
                usuario.setDni(rs.getString("Dni"));
                usuario.setTelefono(rs.getString("Telefono"));
                usuarioList.add(usuario);
            }
            return usuarioList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
