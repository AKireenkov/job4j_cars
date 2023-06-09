package ru.job4j.cars.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "history")
@Data
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    @ManyToOne
    @JoinColumn(name = "id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "id")
    private Car car;
}
