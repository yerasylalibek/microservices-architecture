package kz.app.cart.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "_cart")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {

    @Id
    @Column(name = "id_cart")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 1000)
    private String description;

//    private CartCategory cartCategory;

    @Column(name = "status")
    private String status;

    @Lob
    @Column(name = "images")
    private byte[] images;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user;

    @OneToMany(mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CartCategory> cartCategories = new ArrayList<>();
}
