package main.java.dao;

import main.java.config.UConnection;
import main.java.dto.ProductosDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao implements ProductoImpl {
    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    @Override
    public void registerProducto(ProductosDto producto) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String insertProducto = "INSERT INTO producto (Producto_id,Producto_detail,Producto_Stock,Producto_PrecioUnit) VALUES (?,?,?,?)";
            pstm = con.prepareStatement(insertProducto);
            pstm.setInt(1, producto.getProductId());
            pstm.setString(2, producto.getDetail());
            pstm.setInt(3, producto.getStock());
            pstm.setDouble(4, producto.getPriceUnit());

            int outcome = pstm.executeUpdate();
            if (outcome == 1) {
                con.commit();
                System.out.println("Se agrego el producto!");
            } else {
                throw new RuntimeException("No se pudo agregar el producto");
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
    public ProductosDto getProducto(int producto) {
        ProductosDto productosDto = null;

        try (//Connection con = UConnection.getConnection();
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM producto WHERE Producto_id = ?")) {
            statement.setInt(1, producto);
            //con = UConnection.getConnection();
            //String findIdBungalow = "SELECT bungalowId, category, priceDay, statusRoom FROM bungalow WHERE bungalowId = ? ";
            //pstm = con.prepareStatement(findIdBungalow);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    productosDto = new ProductosDto();
                    productosDto.setProductId(rs.getInt("Producto_id"));
                    productosDto.setDetail(rs.getString("Producto_Detail"));
                    productosDto.setStock(rs.getInt("Producto_Stock"));
                    productosDto.setPriceUnit(rs.getDouble("Producto_PrecioUnit"));
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
        return productosDto;

    }

    @Override
    public void updateProducto(ProductosDto producto) {

    }

    @Override
    public void deleteProducto(int producto) {
        try (Connection con = UConnection.getConnection();
             PreparedStatement pstm = con.prepareStatement("DELETE FROM producto WHERE Producto_id = ? ")) {
            con.setAutoCommit(false); //no sea por defecto el modo autocommit
            //String deleteRoom = "DELETE FROM bungalow WHERE bungalowId = ? ";
            //PreparedStatement pstm = con.prepareStatement(deleteRoom);
            pstm.setInt(1, producto);
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
    public List<ProductosDto> getAllProducto() {
        List<ProductosDto> productoList = new ArrayList<>();

        try {
            con = UConnection.getConnection();
            String findProducto = "SELECT Producto_id,Producto_Detail,Producto_Stock,Producto_PrecioUnit FROM producto ";
            pstm = con.prepareStatement(findProducto);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ProductosDto producto = new ProductosDto();
                producto.setProductId(rs.getInt("Producto_id"));
                producto.setDetail(rs.getString("Producto_Detail"));
                producto.setStock(rs.getInt("Producto_Stock"));
                producto.setPriceUnit(rs.getDouble("Producto_PrecioUnit"));
                productoList.add(producto);
            }
            return productoList;
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

    @Override
    public void updateStock(int idProd, int cantidad) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String query = "UPDATE producto SET Producto_Stock = ? WHERE Producto_id=?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, cantidad);
            pstm.setInt(2, idProd);

            int outcome = pstm.executeUpdate();

            if (outcome == 1) {
                con.commit();
                System.out.println("Se actualizo stock!");
            } else {
                throw new RuntimeException("No se pudo actualizar el stock");
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
}

