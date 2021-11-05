package seafoodexchange.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "growers")
@Data
public class Grower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;
    @ManyToMany
    @JoinTable(
            name = "growers_positions",
            joinColumns = @JoinColumn(name = "grower_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    private List<Position> positions;

    private Double balance;
}
