package main.java.dao;

import main.java.dto.BungalowDto;

import java.util.List;

public interface BungalowImpl {
    void registerBungalow(BungalowDto bungalow);
    BungalowDto getBungalow(int id);
    void updateBungalow(BungalowDto bungalow);
    void deleteBungalow(int id);
    List<BungalowDto> getAllBungalow();
}
