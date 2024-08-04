package tn.esprit.futureuniversity.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import tn.esprit.futureuniversity.Enums.Priority;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Section implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Enumerated(EnumType.STRING) // For flexibility with future enum values
    private Priority priority = Priority.MEDIUM; // Set default

    @Column(nullable = false)
    private Timestamp dueDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private Timestamp updatedAt;

    @ManyToOne(fetch = FetchType.EAGER) // Consider eager fetching if needed
    @JoinColumn(name = "user_id", nullable = false) // Foreign key constraint
    private User userId;


}