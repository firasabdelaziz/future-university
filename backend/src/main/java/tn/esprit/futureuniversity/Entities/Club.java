package tn.esprit.futureuniversity.Entities;

import javax.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private int clubId;

    @ManyToMany
    @JoinTable(
            name = "club_user",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> members = new HashSet<>();

}
