package inventory.tracking.services;

import inventory.tracking.domain.Product;
import inventory.tracking.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired private ProductRepo<Product> productRepo;

    public List<Product> getAllProducts() { return productRepo.findAll();}

    public Optional<List<Product>> getAllElectronics() { return productRepo.findByType("electronics");}
    public Optional<List<Product>> getAllComputers() { return productRepo.findByTag("computers");}
    public Optional<List<Product>> getAllCellPhones() { return productRepo.findByTag("cellphones");}

    public Optional<List<Product>> getAllClothing() { return productRepo.findByType("clothing");}
    public Optional<List<Product>> getAllMenClothes() { return productRepo.findByTag("menclothes");}
    public Optional<List<Product>> getAllWomenClothes() { return productRepo.findByTag("womenclothes");}

    public Product getProductById(Long product_id) throws Throwable {
        return productRepo.findById(product_id).orElseThrow(() -> new IllegalStateException(
                String.format("No product with product_id %d exists", product_id))); }

    public Product getProductByName(String name) throws Throwable {
        return productRepo.findByName(name).orElseThrow(() -> new IllegalStateException(
                String.format("No product with name %s exists", name))); }

    public Optional<List<Product>> getProductsByPrice(double lowPrice, double highPrice) {
        return productRepo.findByPriceBetween(lowPrice,highPrice);
    }

    public Optional<List<Product>> getProductsByInventory(int lower, int upper) {
        return productRepo.findByInventoryBetween(lower, upper);
    }

    public void addNewProduct(Product product){
        Optional<Product> propOpt = productRepo.findByName(product.getName());
        if(propOpt.isPresent()){
            throw new IllegalStateException("Product with this name exists. ");
        }
        productRepo.save(product);
    }

    public void removeProduct(Long product_id){
        if(! productRepo.existsById(product_id)){
            throw new IllegalStateException(String.format("No product with product_id %d exists", product_id));
        }
        productRepo.deleteById(product_id);
    }

    @Transactional
    public void updateProduct(Long product_id, String name, Double price, Integer inventory) throws Throwable {
        Product product = productRepo.findById(product_id).orElseThrow(() -> new IllegalStateException(
                String.format("No product with product_id %d exists", product_id)));
        if (name != null)
            product.setName(name);
        if (price!=null)
            product.setPrice(price);
        if (inventory != null)
            product.setInventory(inventory);
    }

    @Transactional
    public void updateInventory(String name, Integer inventory) throws Throwable {
        Product product = productRepo.findByName(name).orElseThrow(() -> new IllegalStateException(
                String.format("No product with name %s exists", name)));
        if (inventory== null)
            throw new IllegalStateException("Input inventory is null");
        product.setInventory(inventory);
    }

}
