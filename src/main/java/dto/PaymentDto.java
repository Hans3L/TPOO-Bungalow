package main.java.dto;

import java.util.Date;

public class PaymentDto {
    private int PayId;
    private UsuarioDto usuarioDto;
    private BungalowDto bungalowDto;
    private Date date;
    private double amount;
    private String voucher;
    private String description;

    public PaymentDto(){}

    public PaymentDto(int payId, UsuarioDto usuarioDto, BungalowDto bungalowDto, Date date, double amount, String voucher, String description) {
        PayId = payId;
        this.usuarioDto = usuarioDto;
        this.bungalowDto = bungalowDto;
        this.date = date;
        this.amount = amount;
        this.voucher = voucher;
        this.description = description;
    }

    public int getPayId() {
        return PayId;
    }

    public void setPayId(int payId) {
        PayId = payId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
