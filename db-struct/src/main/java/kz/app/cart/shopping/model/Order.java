package kz.app.cart.shopping.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "_order")
@Entity
@Data
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

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
}
