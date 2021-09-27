package kz.app.cart.shopping.model;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

@Data
@Entity
@Table(name = "_cart")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {

    @Id
    @Column(name = "id_cart")
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
}
