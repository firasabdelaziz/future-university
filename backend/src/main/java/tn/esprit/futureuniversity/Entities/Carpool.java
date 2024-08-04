package tn.esprit.futureuniversity.Entities;

import javax.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Carpool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;
    private Date departureTime;
    private int availableSeats;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User driver;

    @ManyToMany
    @JoinTable(
            name = "carpool_passenger",
            joinColumns = @JoinColumn(name = "carpool_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    private Set<User> passengers = new HashSet<>();

    // Getters and setters
}
