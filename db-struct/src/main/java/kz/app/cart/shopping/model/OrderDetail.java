package kz.app.cart.shopping.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "_order_detail")
@Entity
@Data
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;

//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "quantity_price")
    private int quantityPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "remarks")
    private String remarks;

//    @ManyToOne
//    @JoinColumn(name = "vender_id")
//    private Vender vender;
}
