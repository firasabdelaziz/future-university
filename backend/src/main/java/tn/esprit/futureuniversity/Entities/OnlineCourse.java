package tn.esprit.futureuniversity.Entities;

import lombok.Data;
import javax.persistence.*;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "online_courses")
public class OnlineCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    
    @Column(columnDefinition = "certification", nullable = false)
    private String certification;

    @Column(name = "trainingduration", nullable = false)
    private LocalDateTime trainingdurationt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
