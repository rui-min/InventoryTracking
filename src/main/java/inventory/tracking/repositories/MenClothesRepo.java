package inventory.tracking.repositories;

import inventory.tracking.domain.MenClothes;
import org.springframework.stereotype.Repository;

@Repository
public interface MenClothesRepo extends ProductClothingRepo<MenClothes> {
}
