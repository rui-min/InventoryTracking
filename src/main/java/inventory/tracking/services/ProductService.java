package inventory.tracking.services;

import inventory.tracking.domain.Product;
import inventory.tracking.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Business logic
 */
@Service
public class ProductService {
    private final ProductRepo<Product> productRepo;
    @Autowired
    public ProductService(ProductRepo<Product> productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() { return productRepo.findAll();}

    public Optional<List<Product>> getAllElectronics() { return productRepo.findByType("electronics");}
    public Optional<List<Product>> getAllComputers() { return productRepo.findByTagContaining("computer");}
    public Optional<List<Product>> getAllCellPhones() { return productRepo.findByTagContaining("cellphone");}

    public Optional<List<Product>> getAllClothing() { return productRepo.findByType("clothing");}
    public Optional<List<Product>> getAllMenClothes() { return productRepo.findByTagContaining("mencloth");}
    public Optional<List<Product>> getAllWomenClothes() { return productRepo.findByTagContaining("womencloth");}

    public Product getProductById(Long product_id) throws IllegalStateException {
        return productRepo.findById(product_id).orElseThrow(() -> new IllegalStateException(
                String.format("No product with product_id %d exists", product_id))); }

    public Product getProductByName(String name) throws IllegalStateException {
        return productRepo.findByName(name).orElseThrow(() -> new IllegalStateException(
                String.format("No product with name %s exists", name))); }

    public Optional<List<Product>> getProductsByPrice(double lowPrice, double highPrice) {
        return productRepo.findByPriceBetween(lowPrice,highPrice);
    }

    public Optional<List<Product>> getProductsByInventory(int lower, int upper) {
        return productRepo.findByInventoryBetween(lower, upper);
    }

    @Transactional
    public Product addNewProduct(Product product){
        Optional<Product> propOpt = productRepo.findByName(product.getName());
        if(propOpt.isPresent()){
            throw new IllegalStateException("Product with this name exists. ");
        }
        return productRepo.save(product);
    }

    @Transactional
    public Product updateIdProduct(Long product_id, String name, Double price, Integer inventory,
                              String type, String tag) throws IllegalStateException {
        Product product = productRepo.findById(product_id).orElseThrow(() -> new IllegalStateException(
                String.format("No product with product_id %d exists", product_id)));
        if (name != null)
            product.setName(name);
        if (price!=null)
            product.setPrice(price);
        if (inventory != null)
            product.setInventory(inventory);
        if (type != null)
            product.setType(type);
        if (tag != null)
            product.setTag(tag);
        return product;
    }

    @Transactional
    public Product updateNameProduct(String name, Double price, Integer inventory,
                                String type, String tag) throws IllegalStateException {
        Product product = productRepo.findByName(name).orElseThrow(() -> new IllegalStateException(
                String.format("No product with name %s exists", name)));
        if (price!=null)
            product.setPrice(price);
        if (inventory != null)
            product.setInventory(inventory);
        if (type != null)
            product.setType(type);
        if (tag != null)
            product.setTag(tag);
        return product;
    }

    @Transactional
    public void removeIdProduct(Long product_id) throws IllegalStateException{
        if(! productRepo.existsById(product_id)){
            throw new IllegalStateException(String.format("No product with product_id %d exists", product_id));
        }
        productRepo.deleteById(product_id);
        
    }

    @Transactional
    public void removeNameProduct(String name) throws IllegalStateException{
        if(! productRepo.existsByName(name)){
            throw new IllegalStateException(String.format("No product with name %s exists", name));
        }
        productRepo.deleteByName(name);

    }
}
