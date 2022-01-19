package inventory.tracking.repositories;

import inventory.tracking.domain.Computers;
import org.springframework.stereotype.Repository;
/**
 * Spring Data repository managing domain classes and providing methods
 */
@Repository
public interface ComputersRepo extends ProductElectronicsRepo<Computers> {
}
