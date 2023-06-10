package main.java.clases;

public class Bungalow {

    private int bungalowId;
    private int category;
    private double priceDay;
    private int statusRoom;

    public Bungalow(int bungalowId, int category, double priceDay, int statusRoom) {
        this.bungalowId = bungalowId;
        this.category = category;
        this.priceDay = priceDay;
        this.statusRoom = statusRoom;
    }

    public int getBungalowId() {
        return bungalowId;
    }

    public void setBungalowId(int bungalowId) {
        this.bungalowId = bungalowId;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(double priceDay) {
        this.priceDay = priceDay;
    }

    public int getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(int statusRoom) {
        this.statusRoom = statusRoom;
    }

    @Override
    public String toString() {
        return "Bungalow{" +
                "Codigo =" + bungalowId +
                ", Categoria =" + category +
                ", precio x Dia =" + priceDay +
                ", Estado =" + statusRoom +
                '}';
    }
}
