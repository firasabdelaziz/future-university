package tn.esprit.futureuniversity.Entities;

import javax.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Date date;
    private String location;

//    @ElementCollection
//    private List<String> imagePaths = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @OneToMany(mappedBy = "event")
    private Set<TeamBuildingActivity> activities = new HashSet<>();

}