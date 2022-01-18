package inventory.tracking.controller;

import inventory.tracking.domain.Product;
import inventory.tracking.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GetMappings (with filter links)
    @GetMapping("")
    public List<Product> index() {
        return productService.getAllProducts();
    }

    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws Throwable {
        return productService.getProductById(id);
    }

    @GetMapping("/name/{name}")
    public Product getProductById(@PathVariable("name") String name) throws Throwable {
        return productService.getProductByName(name);
    }

    @GetMapping("/electronics")
    public Optional<List<Product>> getAllElectronics() throws Throwable {
        return productService.getAllElectronics();
    }

    @GetMapping("/computers")
    public Optional<List<Product>> getAllComputers() throws Throwable {
        return productService.getAllComputers();
    }

    @GetMapping("/cellphones")
    public Optional<List<Product>> getAllCellPhones() throws Throwable {
        return productService.getAllCellPhones();
    }

    @GetMapping("/clothing")
    public Optional<List<Product>> getAllClothing() throws Throwable {
        return productService.getAllClothing();
    }

    @GetMapping("/menclothes")
    public Optional<List<Product>> getAllMenClothes() throws Throwable {
        return productService.getAllMenClothes();
    }

    @GetMapping("/womenclothes")
    public Optional<List<Product>> getAllWomenClothes() throws Throwable {
        return productService.getAllWomenClothes();
    }

    @GetMapping("/price")
    public Optional<List<Product>> getProductsByPrice(@RequestParam double lowPrice,
                                                      @RequestParam double highPrice) throws Throwable {
        return productService.getProductsByPrice(lowPrice, highPrice);
    }

    @GetMapping("/inventory")
    public Optional<List<Product>> getProductsByInventory(@RequestParam int lower,
                                                          @RequestParam int upper) throws Throwable {
        return productService.getProductsByInventory(lower, upper);
    }

    // C, U, R methods
    @PostMapping("/post")
    public void addNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @PutMapping("/put/{id}")
    public void updateProduct(@PathVariable("id") Long product_id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) Double price,
                              @RequestParam(required = false) Integer inventory) throws Throwable {
        productService.updateProduct(product_id, name, price, inventory);
        System.out.println("updated");
    }

    @PutMapping("/put/name")
    public Product updateInventory(@RequestParam String name,
                                @RequestParam Integer inventory) throws Throwable {
        productService.updateInventory(name,inventory);
        return productService.getProductByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public String removeProduct(@PathVariable("id") Long product_id) {
        productService.removeProduct(product_id);
        return "id: "+product_id+" deleted";
    }
}
