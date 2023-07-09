package main.java.facade;

import main.java.dao.ConsumptionDao;
import main.java.dao.ConsumptionImpl;
import main.java.dto.ConsumptionDto;

import java.util.List;

public class ConsumptionFacade {
    private ConsumptionImpl consumptionImpl;

    public ConsumptionFacade(){
        this.consumptionImpl = new ConsumptionDao();
    }

    public void addConsumption(ConsumptionDto consumption){
        consumptionImpl.registerConsumption(consumption);
    }

    public List<ConsumptionDto> listProductForIdUser(int id){
        return consumptionImpl.readConsumptionIdForDay(id);
    }

}
