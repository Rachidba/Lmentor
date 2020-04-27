package ma.lmentor.restapi.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Student extends Profile {

}
