package tn.esprit.futureuniversity.Entities;

import lombok.Data;
import tn.esprit.futureuniversity.Enums.Skillstype;
import javax.persistence.*;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "employability")
public class Employability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "job_description", columnDefinition = "TEXT", nullable = false)
    private String jobDescription;

    @Column(name = "application_deadline", nullable = false)
    private LocalDateTime applicationDeadline;


    @Column(name = "skillsrequired", length = 20)
    private Skillstype skillstype;

    @Column(name = "experiencerequired ", nullable = false)
    private int experiencerequired ;


    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}

