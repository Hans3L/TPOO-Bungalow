package main.java.facade;

import main.java.dao.BungalowDao;
import main.java.dao.BungalowImpl;
import main.java.dto.BungalowDto;

import java.util.List;

public class BungalowFacade {
    private BungalowImpl bungalowImpl;

    public BungalowFacade() {
        this.bungalowImpl = new BungalowDao();
    }

    public void registerBungalow(BungalowDto bungalow) {
        bungalowImpl.registerBungalow(bungalow);
    }

    public BungalowDto getBungalow(int id) {
        return bungalowImpl.getBungalow(id);
    }

    public void updateBungalow(BungalowDto bungalow) {
        bungalowImpl.updateBungalow(bungalow);
    }

    public void deleteBungalow(int id) {
        bungalowImpl.deleteBungalow(id);
    }

    public List<BungalowDto> getAllBungalow() {
        return bungalowImpl.getAllBungalow();
    }

}
