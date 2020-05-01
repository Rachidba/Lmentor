package ma.lmentor.restapi.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mentees")
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Mentee extends Profile {

}
