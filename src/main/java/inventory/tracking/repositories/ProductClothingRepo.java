package inventory.tracking.repositories;

import inventory.tracking.domain.ProductClothing;
import org.springframework.stereotype.Repository;
/**
 * Spring Data repository managing domain classes and providing methods
 * @param <T> generic types sub of ProductClothing
 */
@Repository
public interface ProductClothingRepo<T extends ProductClothing> extends ProductRepo<T> {
}