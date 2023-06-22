package main.java.dto;

public class ProductosDto {
    private int productId;
    private String detail;
    private int stock;
    private double priceUnit;

    public ProductosDto(int productId, String detail, int stock, double priceUnit) {
        this.productId = productId;
        this.detail = detail;
        this.stock = stock;
        this.priceUnit = priceUnit;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "Codigo =" + productId +
                ", Detalles ='" + detail + '\'' +
                ", Stock =" + stock +
                ", Precio Unitario =" + priceUnit +
                '}';
    }
}
