package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.History;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class HistoryRepository {
    private final CrudRepository crudRepository;

    public History create(History history) {
        crudRepository.run(session -> session.persist(history));
        return history;
    }

    public void update(History history) {
        crudRepository.run(session -> session.merge(history));
    }

    public void delete(int historyId) {
        crudRepository.run(
                "delete from History where id = :fId",
                Map.of("fId", historyId)
        );
    }

    public List<History> findAllOrderById() {
        return crudRepository.query("from History order by id asc", History.class);
    }

    public Optional<History> findById(int historyId) {
        return crudRepository.optional(
                "from History where id = :fId", History.class,
                Map.of("fId", historyId)
        );
    }
}
