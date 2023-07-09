package main.java.dao;

import main.java.dto.ConsumptionDto;

import java.util.List;

public interface ConsumptionImpl {
    void registerConsumption(ConsumptionDto consumptionDto);
    void readConsumptionId();
    List<ConsumptionDto> readConsumptionIdForDay(int userId);
}
