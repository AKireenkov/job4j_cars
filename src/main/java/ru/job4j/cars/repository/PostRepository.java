package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class PostRepository {

    private final CrudRepository crudRepository;

    /**
     * Объявления за последний день.
     *
     * @return объявление за последний день.
     */
    public List<Post> postFromLastDay() {
        return new ArrayList<>(crudRepository.query(
                "from Post where where created = CURRENT_DATE", Post.class
        ));
    }

    /**
     * Объявления с фото.
     */
    public List<Post> postWithPhoto() {
        return new ArrayList<>(crudRepository.query(
                "from Post where photo is not null", Post.class
        ));
    }

    /**
     * Объявления определенной марки.
     *
     * @param mark mark.
     * @return Optional or post.
     */
    public Optional<Post> findByLIkeMark(String mark) {
        return crudRepository.optional(
                "from Post where mark = :fMark", Post.class,
                Map.of("fMark", mark)
        );
    }
}
