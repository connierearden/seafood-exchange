package seafoodexchange.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer priceForKilogram;
    private Integer boxes;
    private Integer boxWeight;
    private String status; //в будущем enum — торги, автосделка, сделка)
    private String sentTo; //в будущем enum — TO_CUSTOMER, TO_COMPANY, BOTH)
    // поле нужно для того, чтобы при изменении цены заказ отправлялся на рассмотрени другой стороне.

}
