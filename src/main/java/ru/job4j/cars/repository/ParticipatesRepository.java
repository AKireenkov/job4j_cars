package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Participates;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class ParticipatesRepository {
    private final CrudRepository crudRepository;

    public Participates create(Participates model) {
        crudRepository.run(session -> session.persist(model));
        return model;
    }

    public void update(Participates participate) {
        crudRepository.run(session -> session.merge(participate));
    }

    public void delete(Integer id) {
        crudRepository.run(
                "delete from Participates where id = :fId",
                Map.of("fId", id)
        );
    }

    public List<Participates> findAll() {
        return crudRepository.query("from Participates", Participates.class).stream().toList();
    }

    public Optional<Participates> findById(Integer id) {
        return crudRepository.optional("from Participates order by id asc", Participates.class,
                Map.of("fId", id));
    }
}
