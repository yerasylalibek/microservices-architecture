package kz.app.cart.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Data
@Entity
@Table(name = "_cart_product")
@AllArgsConstructor
@NoArgsConstructor
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private CartCategory cartCategory;
}
