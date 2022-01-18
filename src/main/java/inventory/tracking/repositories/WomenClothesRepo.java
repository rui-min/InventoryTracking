package inventory.tracking.repositories;

import inventory.tracking.domain.WomenClothes;
import org.springframework.stereotype.Repository;

@Repository
public interface WomenClothesRepo extends ProductClothingRepo<WomenClothes> {
}
