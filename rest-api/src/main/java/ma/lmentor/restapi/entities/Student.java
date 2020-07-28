package ma.lmentor.restapi.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Data
@EqualsAndHashCode
@SuperBuilder
public class Student extends Profile {

    @OneToMany(targetEntity = Subcategory.class)
    private Set<Subcategory> interestAreas;

    public Student(User user) {
        this.user = user;
    }
}
