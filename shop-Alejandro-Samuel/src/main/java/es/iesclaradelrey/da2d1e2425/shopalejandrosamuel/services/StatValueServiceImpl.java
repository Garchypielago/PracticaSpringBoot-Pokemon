package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.StatValue;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.StatValueRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StatValueServiceImpl implements StatValueService {
    private StatValueRepository statValueRepository;

    public StatValueServiceImpl(StatValueRepository statValueRepository) {
        this.statValueRepository = statValueRepository;
    }

    @Override
    public long count() {
        return statValueRepository.count();
    }

    @Override
    public void save(StatValue statValue) {
        statValueRepository.save(statValue);
    }

    @Override
    public Collection<StatValue> findAll() {
        return statValueRepository.findAll();
    }
}
