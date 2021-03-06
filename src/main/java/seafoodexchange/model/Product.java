package seafoodexchange.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;
import seafoodexchange.model.enums.CoolingType;
import seafoodexchange.model.enums.TypeProduct;

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
    @Enumerated(EnumType.STRING)
    private TypeProduct type;
    private String fishFamily;
    @Enumerated(EnumType.STRING)
    private CoolingType coolingType;
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



