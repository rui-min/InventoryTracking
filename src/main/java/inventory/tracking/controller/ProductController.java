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

    @GetMapping("/get/id/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws Throwable {
        return productService.getProductById(id);
    }

    @GetMapping("/get/name/{name}")
    public Product getProductById(@PathVariable("name") String name) throws Throwable {
        return productService.getProductByName(name);
    }

    @GetMapping("/get/electronics")
    public Optional<List<Product>> getAllElectronics() throws Throwable {
        return productService.getAllElectronics();
    }

    @GetMapping("/get/computers")
    public Optional<List<Product>> getAllComputers() throws Throwable {
        return productService.getAllComputers();
    }

    @GetMapping("/get/cellphones")
    public Optional<List<Product>> getAllCellPhones() throws Throwable {
        return productService.getAllCellPhones();
    }

    @GetMapping("/get/clothing")
    public Optional<List<Product>> getAllClothing() throws Throwable {
        return productService.getAllClothing();
    }

    @GetMapping("/get/menclothes")
    public Optional<List<Product>> getAllMenClothes() throws Throwable {
        return productService.getAllMenClothes();
    }

    @GetMapping("/get/womenclothes")
    public Optional<List<Product>> getAllWomenClothes() throws Throwable {
        return productService.getAllWomenClothes();
    }

    @GetMapping("/get/price")
    public Optional<List<Product>> getProductsByPrice(@RequestParam double lowPrice,
                                                      @RequestParam double highPrice) throws Throwable {
        return productService.getProductsByPrice(lowPrice, highPrice);
    }

    @GetMapping("/get/inventory")
    public Optional<List<Product>> getProductsByInventory(@RequestParam int lower,
                                                          @RequestParam int upper) throws Throwable {
        return productService.getProductsByInventory(lower, upper);
    }

    // C, U, R methods
    @PostMapping("/post")
    public void addNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @PutMapping("/put/id/{id}")
    public void updateIdProduct(@PathVariable("id") Long product_id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) Double price,
                              @RequestParam(required = false) Integer inventory,
                              @RequestParam(required = false) String type,
                              @RequestParam(required = false) String tag) throws Throwable {
        productService.updateIdProduct(product_id, name, price, inventory, type, tag);
    }

    @PutMapping("/put/name/{name}")
    public void updateNameProduct(@PathVariable("name") String name,
                                @RequestParam(required = false) Double price,
                                @RequestParam(required = false) Integer inventory,
                                @RequestParam(required = false) String type,
                                @RequestParam(required = false) String tag) throws Throwable {
        productService.updateNameProduct(name, price, inventory, type, tag);
        System.out.println("updated");
    }

    @DeleteMapping("/delete/id/{id}")
    public String removeProduct(@PathVariable("id") Long product_id) {
        productService.removeIdProduct(product_id);
        return "id: "+product_id+" deleted";
    }

    @DeleteMapping("/delete/name/{name}")
    public String removeProduct(@PathVariable("name") String name) {
        productService.removeNameProduct(name);
        return "name: \""+name+"\" deleted";
    }
}
