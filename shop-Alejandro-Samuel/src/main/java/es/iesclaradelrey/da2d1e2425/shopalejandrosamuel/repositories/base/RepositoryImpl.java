package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.base;




import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RepositoryImpl<T extends Entity<ID>, ID> implements Repository<T, ID> {

    private Map<ID, T> map = new HashMap<>();


    @Override
    public long count() {
        return map.size();
    }

    @Override
    public void save(T t) {
        map.put(t.getId(), t);
    }

    @Override
    public Collection<T> findAll() {
        return map.values();
    }

    @Override
    public Optional<T> findById(ID id) {
        if (map.containsKey(id)) {
            return Optional.of(map.get(id));
        }
        return Optional.empty();
    }
}
