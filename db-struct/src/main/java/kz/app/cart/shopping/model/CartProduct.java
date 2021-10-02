package kz.app.cart.shopping.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "_cart_product")
public class CartProduct {

    @Id
    @Column(name = "id_cart_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "detail")
    private String detail;

//    @ManyToOne
//    private CartCategory cartCategory;
}
