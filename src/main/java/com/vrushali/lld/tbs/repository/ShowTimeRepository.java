package com.vrushali.lld.tbs.repository;

import com.vrushali.lld.tbs.model.ShowTime;

import java.util.*;

/*
* Manage in-memory persistence of ShowTime objects.

Support basic operations: save, findById, findAll, delete, and optionally, findByEventId.


* */
public class ShowTimeRepository {
    private final Map<String, ShowTime> showTimeStore = new HashMap<>();

    public void save(ShowTime showTime){
        showTimeStore.put(showTime.getId(), showTime);
    }

    public Optional<ShowTime> findById(String id){
        return Optional.ofNullable(showTimeStore.get(id));
    }

    public List<ShowTime> findAll(){
        return new ArrayList<>(showTimeStore.values());
    }

    public List<ShowTime> findEventById(String eventId){
        List<ShowTime> result = new ArrayList<>();
        for (ShowTime showTime : showTimeStore.values()){
            if (showTime.getEventId().equals(eventId)){
                result.add(showTime);
            }
        }
        return result;
    }

    public void deleteById(String id) {
        showTimeStore.remove(id);
    }

    public void clear() {
        showTimeStore.clear();
    }
}
