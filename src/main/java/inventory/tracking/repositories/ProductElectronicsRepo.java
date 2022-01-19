package inventory.tracking.repositories;

import inventory.tracking.domain.ProductElectronics;
import org.springframework.stereotype.Repository;
/**
 * Spring Data repository managing domain classes and providing methods
 * @param <T> generic types sub of ProductElectronics
 */
@Repository
public interface ProductElectronicsRepo<T extends ProductElectronics> extends ProductRepo<T> {

}
