package main.java.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            // obtengo la conexion
            con = UConnection.getConnection();
            // seteo el autocommit en false
            con.setAutoCommit(false);
            // deno y ejecuto la sentencia DELETE
            String findBungalow = "SELECT bungalowId, category, priceDay, statusRoom FROM bungalow";
            pstm = con.prepareStatement(findBungalow);
            //pstm.setInt(1, 20);
            resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                System.out.print(resultSet.getInt("bungalowId") + ", ");
                System.out.print(resultSet.getInt("category") + ", ");
                System.out.print(resultSet.getDouble("priceDay") + ", ");
                System.out.println(resultSet.getInt("statusRoom"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            try {
                // rollback "por las dudas"
                if (resultSet != null) resultSet.close();
                if (pstm != null) pstm.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }

    }
}
