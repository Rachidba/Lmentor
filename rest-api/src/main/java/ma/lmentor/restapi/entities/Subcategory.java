package ma.lmentor.restapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "subcategories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subcategoryName", nullable = false, unique = true)
    private String subcategoryName;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    public Long getId() {
        return this.id;
    }
    public String getSubcategoryName() {
        return this.subcategoryName;
    }

    public String getCategoryName() {
        return this.category.getCategoryName();
    }
}
