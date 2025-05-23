package com.vrushali.lld.tbs.repository;

import com.vrushali.lld.tbs.model.SeatInventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SeatInventoryRepository {
    private final Map<String, SeatInventory> inventoryMap = new HashMap<>();

    public void save(SeatInventory inventory) {
        inventoryMap.put(inventory.getShowTimeId(), inventory);
    }

    public Optional<SeatInventory> findByShowTimeId(String showTimeId) {
        return Optional.ofNullable(inventoryMap.get(showTimeId));
    }

    public void deleteByShowTimeId(String showTimeId) {
        inventoryMap.remove(showTimeId);
    }

    public void clear() {
        inventoryMap.clear();
    }
}
