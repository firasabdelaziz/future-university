package tn.esprit.futureuniversity.Entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class TeamBuildingActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
