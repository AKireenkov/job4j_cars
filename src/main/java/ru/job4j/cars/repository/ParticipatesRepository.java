package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class ParticipatesRepository {
    private final CrudRepository crudRepository;

    public <T> T create(T model) {
        crudRepository.run(session -> session.persist(model));
        return model;
    }

    public <T> void update(T participate) {
        crudRepository.run(session -> session.merge(participate));
    }

    public void delete(Integer id) {
        crudRepository.run(
                "delete from Participates where id = :fId",
                Map.of("fId", id)
        );
    }

    public <T> List<Post> findAll() {
        return crudRepository.query("from Participates", Post.class).stream().toList();
    }

    public Optional<Post> findById(Integer id) {
        return crudRepository.optional("from Participates order by id asc", Post.class,
                Map.of("fId", id));
    }
}
