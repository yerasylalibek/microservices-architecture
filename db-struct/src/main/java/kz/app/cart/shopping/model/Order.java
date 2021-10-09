package kz.app.cart.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "_order")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reference_no")
    private int referenceNo;

    @ManyToOne
    @JoinColumn(name = "curtomer_id")
    private Customer customer;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "expected_delivery_date")
    private Date expectedDeliveryDate;

    @Column(name = "number_of_items")
    private int numberOfItems;

    @Column(name = "total_amount")
    private int totalAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order_detail", referencedColumnName = "id_detail")
    private OrderDetail orderDetail;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
