package ma.lmentor.restapi.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "experiences")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    private String role;
    @Column(name = "start_year")
    private int startYear;
    @Column(name = "start_month")
    private int startMonth;
    @Column(name = "end_year")
    private int endYear;
    @Column(name = "end_month")
    private int endMonth;
    private String description;
    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private Mentor mentor;
}