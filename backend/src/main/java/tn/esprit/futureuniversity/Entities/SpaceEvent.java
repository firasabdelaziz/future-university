package tn.esprit.futureuniversity.Entities;

import javax.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class SpaceEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private int capacity;

    // Getters and setters
}
