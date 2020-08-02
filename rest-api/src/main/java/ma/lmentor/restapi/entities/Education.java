package ma.lmentor.restapi.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "educations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String school;
    private String degree;
    @Column(name = "field_of_study")
    private String fieldOfStudy;
    @Column(name = "start_year")
    private int startYear;
    @Column(name = "end_year")
    private int endYear;
    private String description;
    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private Mentor mentor;
}
