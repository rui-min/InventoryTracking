package inventory.tracking.repositories;

import inventory.tracking.domain.Computers;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputersRepo extends ProductElectronicsRepo<Computers> {
}
