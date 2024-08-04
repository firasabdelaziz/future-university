package tn.esprit.futureuniversity.Entities;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startTime;
    private Date endTime;

    private String space_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and setters
}
