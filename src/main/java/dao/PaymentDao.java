package main.java.dao;

import main.java.config.UConnection;
import main.java.dto.PaymentDto;
import main.java.dto.ProductosDto;
import main.java.dto.UsuarioDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDao implements PaymentImpl {

    UsuarioDao usuarioDao = new UsuarioDao();
    private double igv = 0.18;
    Connection con = null;
    PreparedStatement pstm = null;

    @Override
    public void registerPayment(PaymentDto paymentDto) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            //Obtengo el usuario por su ID
            UsuarioDto usuarioDto = usuarioDao.getUsuario(paymentDto.getUsuarioDto().getUserId());
            if (usuarioDto != null) {
                //calcular operacion del usuario
                //double monto =
                //double total = productosDto.getPriceUnit() * cantidad;
                //actualizar stock
               // int nuevoStock = productosDto.getStock() - cantidad;
                //productoDao.updateStock(idProducto, nuevoStock);
                String query = "INSERT INTO consumo (UserId, paymentDay, amount,voucherType, description) VALUES (?,CURRENT_DATE,?,?,?)";
                try (PreparedStatement statement = con.prepareStatement(query)) {
                   // statement.setInt(1, idUsuario);
                   // statement.setInt(2, idProducto);
                   // statement.setInt(3, idBungalow);
                   // statement.setInt(4, cantidad);
                    statement.executeUpdate();
                    con.commit();
                }
               // System.out.println("Operacion realizada con exito. Total " + total);
            } else {
                System.out.println("El producto no existe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) pstm.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
