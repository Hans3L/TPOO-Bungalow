package main.java.dao;

import main.java.config.UConnection;
import main.java.dto.ConsumptionDto;
import main.java.dto.ProductosDto;
import main.java.dto.UsuarioDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsumptionDao implements ConsumptionImpl {
    ProductoDao productoDao = new ProductoDao();
    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;


    @Override
    public void registerConsumption(ConsumptionDto consumptionDto) {
        try {
            calculateAmount(consumptionDto.getUsuarioDto().getUserId(), consumptionDto.getBungalowDto().getBungalowId(), consumptionDto.getProductosDto().getProductId(), consumptionDto.getQuantity());
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

    public void calculateAmount(int idUsuario, int idBungalow, int idProducto, int cantidad) throws SQLException {
        con = UConnection.getConnection();
        con.setAutoCommit(false);
        //Obtengo el producto por su ID
        ProductosDto productosDto = productoDao.getProducto(idProducto);
        if (productosDto != null) {
            //calcular operacion de producto
            double total = productosDto.getPriceUnit() * cantidad;
            //actualizar stock
            int nuevoStock = productosDto.getStock() - cantidad;
            productoDao.updateStock(idProducto, nuevoStock);
            String query = "INSERT INTO consumo (UserId, Producto_id, bungalowId,consumptionDate, quantity,total) VALUES (?,?,?,CURRENT_DATE,?,?)";
            try (PreparedStatement statement = con.prepareStatement(query)) {
                statement.setInt(1, idUsuario);
                statement.setInt(2, idProducto);
                statement.setInt(3, idBungalow);
                statement.setInt(4, cantidad);
                statement.setDouble(5, total);
                statement.executeUpdate();
                con.commit();
            }
            System.out.println("Operacion realizada con exito. Total " + total);
        } else {
            System.out.println("El producto no existe");
        }
    }

    @Override
    public void readConsumptionId() {

    }

    @Override
    public List<ConsumptionDto> readConsumptionIdForDay(int userId) {
        List<ConsumptionDto> consumptionDtoList = new ArrayList<>();

        try {
            con = UConnection.getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT usuario.FirstName, usuario.LastName, producto.Producto_Detail, consumo.quantity, consumo.consumptionDate FROM usuario INNER JOIN consumo ON consumo.UserId = usuario.UserId INNER JOIN producto ON consumo.Producto_id = producto.Producto_id WHERE consumo.consumptionDate = current_date() and consumo.UserId = ?");
            statement.setInt(1,userId);
            rs = statement.executeQuery();
            while (rs.next()) {
                ConsumptionDto consumptionDto = new ConsumptionDto();
                UsuarioDto usuarioDto = new UsuarioDto();
                ProductosDto productosDto = new ProductosDto();

                usuarioDto.setName(rs.getString("FirstName"));
                usuarioDto.setLastName(rs.getString("LastName"));
                productosDto.setDetail(rs.getString("Producto_Detail"));

                consumptionDto.setUsuarioDto(usuarioDto);
                consumptionDto.setProductosDto(productosDto);

                consumptionDto.setQuantity(rs.getInt("quantity"));
                consumptionDto.setDate(rs.getDate("consumptionDate"));
                consumptionDtoList.add(consumptionDto);
            }
            return consumptionDtoList;
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
