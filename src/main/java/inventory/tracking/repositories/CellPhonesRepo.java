package inventory.tracking.repositories;

import inventory.tracking.domain.CellPhones;
import org.springframework.stereotype.Repository;
/**
 * Spring Data repository managing domain classes and providing methods
 */
@Repository
public interface CellPhonesRepo extends ProductElectronicsRepo<CellPhones> {
}
