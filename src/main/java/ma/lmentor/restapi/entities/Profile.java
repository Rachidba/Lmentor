package ma.lmentor.restapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profiles")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "profile_id")
    private Integer profileId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Profile(User user) {
        this.user = user;
    }
}
