package kz.app.cart.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "_cart_product_category")
@AllArgsConstructor
@NoArgsConstructor
public class CartProductCategory {

    @Id
    @Column(name = "id_cart_product_category")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "category_name")
    private String categoryName;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

}
