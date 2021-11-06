package seafoodexchange.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private String type; //в будущем enum — рыба, икра, морепродукты
    private String fishFamily;
    private String coolingType; //в будущем enum — живая, охлажденная, мороженая
    private String name;


    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    private List<Position> positions;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders;
}
