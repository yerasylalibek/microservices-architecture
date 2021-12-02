package  kz.app.cart.shopping.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Builder
@Entity
@Table(name = "inventory")
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "productCode", nullable = false, unique = true)
    private String productCode;
    @Column(name = "quantity")
    private Integer availableQuantity = 0;
}
