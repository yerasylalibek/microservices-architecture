package  kz.app.cart.shopping.repository;
import kz.app.cart.shopping.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    Optional<InventoryItem> findByProductCode(String productCode);
}