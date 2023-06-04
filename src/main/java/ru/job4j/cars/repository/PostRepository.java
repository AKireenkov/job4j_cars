package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.time.LocalDateTime.*;

@AllArgsConstructor
public class PostRepository {

    private final CrudRepository crudRepository;

    public static final String DATE_TIME_WITHOUT_LAST_DAY = now().minus(1, ChronoUnit.DAYS).toString();

    /**
     * Объявления за последний день.
     *
     * @return объявление за последний день.
     */
    public List<Post> postFromLastDay() {
        return new ArrayList<>(crudRepository.query(
                "from Post where where created > :fDateTime", Post.class,
                Map.of("fDateTime", DATE_TIME_WITHOUT_LAST_DAY)
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
