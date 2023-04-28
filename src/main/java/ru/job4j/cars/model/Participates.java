package ru.job4j.cars.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "participates")
@Data
public class Participates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int post_id;
    private int user_id;
}
