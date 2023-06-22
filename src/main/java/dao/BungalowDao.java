package main.java.dao;

import main.java.config.UConnection;
import main.java.dto.BungalowDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BungalowDao implements BungalowImpl {

    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    @Override
    public void registerBungalow(BungalowDto bungalow) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String insertBungalow = "INSERT INTO bungalow (bungalowId, category, priceDay, statusRoom) VALUES (?,?,?,?)";
            pstm = con.prepareStatement(insertBungalow);
            pstm.setInt(1, bungalow.getBungalowId());
            pstm.setInt(2, bungalow.getCategory());
            pstm.setDouble(3, bungalow.getPriceDay());
            pstm.setInt(4, bungalow.getStatusRoom());
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
    public BungalowDto getBungalow(int bungalowId) {
        BungalowDto bungalowDto = null;

        try (//Connection con = UConnection.getConnection();
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM bungalow WHERE bungalowId = ?")) {
            statement.setInt(1, bungalowId);
            //con = UConnection.getConnection();
            //String findIdBungalow = "SELECT bungalowId, category, priceDay, statusRoom FROM bungalow WHERE bungalowId = ? ";
            //pstm = con.prepareStatement(findIdBungalow);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    bungalowDto = new BungalowDto();
                    bungalowDto.setBungalowId(rs.getInt("bungalowId"));
                    bungalowDto.setCategory(rs.getInt("category"));
                    bungalowDto.setPriceDay(rs.getDouble("priceDay"));
                    bungalowDto.setStatusRoom(rs.getInt("statusRoom"));
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
        return bungalowDto;
    }

    @Override
    public void updateBungalow(BungalowDto bungalow) {
    }

    @Override
    public void deleteBungalow(int id) {
        try (Connection con = UConnection.getConnection();
             PreparedStatement pstm = con.prepareStatement("DELETE FROM bungalow WHERE bungalowId = ? ")) {
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
    public List<BungalowDto> getAllBungalow() {
        List<BungalowDto> bungalowList = new ArrayList<>();

        try {
            con = UConnection.getConnection();
            String findBungalow = "SELECT bungalowId, category, priceDay, statusRoom FROM bungalow ";
            pstm = con.prepareStatement(findBungalow);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BungalowDto bungalow = new BungalowDto();
                bungalow.setBungalowId(rs.getInt("bungalowId"));
                bungalow.setCategory(rs.getInt("category"));
                bungalow.setPriceDay(rs.getDouble("priceDay"));
                bungalow.setStatusRoom(rs.getInt("statusRoom"));
                bungalowList.add(bungalow);
            }
            return bungalowList;
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
