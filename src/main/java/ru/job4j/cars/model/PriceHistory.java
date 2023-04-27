package ru.job4j.cars.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "price_history")
@Data
public class PriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int before;
    private int after;
    private Timestamp created;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "auto_user_id")
    private List<Post> posts = new ArrayList<>();
}
