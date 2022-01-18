package inventory.tracking.repositories;

import inventory.tracking.domain.CellPhones;
import org.springframework.stereotype.Repository;

@Repository
public interface CellPhonesRepo extends ProductElectronicsRepo<CellPhones> {
}
