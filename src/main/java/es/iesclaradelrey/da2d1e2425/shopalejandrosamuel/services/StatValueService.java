package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.StatValue;

import java.util.Collection;
import java.util.List;

public interface StatValueService {
    long count();
    void save(StatValue statValue);
    Collection<StatValue> findAll();
}
