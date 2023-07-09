package main.java.dto;

import java.util.Date;

public class ConsumptionDto {
    private int consumptionId;
    private UsuarioDto usuarioDto;
    private BungalowDto bungalowDto;
    private ProductosDto productosDto;
    private Date consumptionDate;
    private int quantity;


    public ConsumptionDto() {
    }

    public ConsumptionDto(UsuarioDto usuarioDto, BungalowDto bungalowDto, ProductosDto productosDto, Date consumptionDate, int quantity) {
        this.usuarioDto = usuarioDto;
        this.bungalowDto = bungalowDto;
        this.productosDto = productosDto;
        this.consumptionDate = consumptionDate;
        this.quantity = quantity;
    }

    public ConsumptionDto(int consumptionId, UsuarioDto usuarioDto, BungalowDto bungalowDto, ProductosDto productosDto, Date consumptionDate, int quantity) {
        this.consumptionId = consumptionId;
        this.usuarioDto = usuarioDto;
        this.bungalowDto = bungalowDto;
        this.productosDto = productosDto;
        this.consumptionDate = consumptionDate;
        this.quantity = quantity;
    }

    public int getConsumptionId() {
        return consumptionId;
    }

    public void setConsumptionId(int consumptionId) {
        this.consumptionId = consumptionId;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public BungalowDto getBungalowDto() {
        return bungalowDto;
    }

    public void setBungalowDto(BungalowDto bungalowDto) {
        this.bungalowDto = bungalowDto;
    }

    public ProductosDto getProductosDto() {
        return productosDto;
    }

    public void setProductosDto(ProductosDto productosDto) {
        this.productosDto = productosDto;
    }

    public Date getDate() {
        return consumptionDate;
    }

    public void setDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ConsumptionDto{" +
                "consumptionId=" + consumptionId +
                ", usuarioDto=" + usuarioDto +
                ", bungalowDto=" + bungalowDto +
                ", productosDto=" + productosDto +
                ", consumptionDate=" + consumptionDate +
                ", quantity=" + quantity +
                '}';
    }
}
