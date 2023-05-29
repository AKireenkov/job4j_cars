package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
                "delete from Post where id = :fId",
                Map.of("fId", id)
        );
    }

    public <T> List<Post> findAll() {
        return new ArrayList<>(crudRepository.query("from Post", Post.class));
    }

    public Optional<Post> findById(Integer id) {
        return crudRepository.optional("from Post order by id asc", Post.class,
                Map.of("fId", id));
    }
}
