package ma.lmentor.restapi.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.lmentor.restapi.models.GenderType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mentors")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@SuperBuilder
public class Mentor extends Profile {
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    private String title;
    private String description;
    private String city;
    @ManyToMany
    @JoinTable(
            name = "mentor_subcategory",
            joinColumns = @JoinColumn(name = "mentor_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    private Set<Subcategory> expertiseAreas;
    @OneToMany(mappedBy = "mentor", fetch = FetchType.EAGER)
    private Set<Education> educations;
    @OneToMany(mappedBy = "mentor", fetch = FetchType.EAGER)
    private Set<Experience> experiences;
    @Column(name = "linkedin_url")
    private String linkedinUrl;

    public Mentor(User user) {
        super(user);
    }

    public Integer getProfileId() {
        return profileId;
    }
}
