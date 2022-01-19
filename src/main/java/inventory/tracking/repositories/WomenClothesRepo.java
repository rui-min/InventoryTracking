package inventory.tracking.repositories;

import inventory.tracking.domain.WomenClothes;
import org.springframework.stereotype.Repository;
/**
 * Spring Data repository managing domain classes and providing methods
 */
@Repository
public interface WomenClothesRepo extends ProductClothingRepo<WomenClothes> {
}
