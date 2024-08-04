package tn.esprit.futureuniversity.Entities;

import lombok.Data;

import javax.persistence.*;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "cv_job_matches")
public class CVJobMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "employability_id")
    private Employability employability;

    @Column(name = "match_score")
    private int matchScore;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
