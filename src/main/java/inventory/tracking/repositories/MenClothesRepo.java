package inventory.tracking.repositories;

import inventory.tracking.domain.MenClothes;
import org.springframework.stereotype.Repository;
/**
 * Spring Data repository managing domain classes and providing methods
 */
@Repository
public interface MenClothesRepo extends ProductClothingRepo<MenClothes> {
}
