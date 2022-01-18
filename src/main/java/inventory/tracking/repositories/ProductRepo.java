package inventory.tracking.repositories;

import inventory.tracking.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo<T extends Product> extends JpaRepository<T,Long> {
    Optional<T> findByName(String name);
    Optional<List<T>> findByInventoryBetween(int lower, int upper);
    Optional<List<T>> findByPriceBetween(double lowPrice, double highPrice);
    Optional<List<T>> findByType(String type);
    Optional<List<T>> findByTagContaining(String tag);
    boolean existsByName(String name);
    @Transactional
    Long deleteByName(String name);
}
