package inventory.tracking.repositories;

import inventory.tracking.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductElectronicsRepo<T extends Product> extends ProductRepo<T> {

}
