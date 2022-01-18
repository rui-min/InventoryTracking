//package inventory.tracking.bootstrap;
//
//import inventory.tracking.domain.*;
//import inventory.tracking.services.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Random;
//
//@Component
//public class BootStrapData implements CommandLineRunner {
//
//    private final ProductService productService;
//
//    @Autowired
//    public BootStrapData(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Started in Bootstrap");
//        Random r = new Random();
//
//        Product computer1 = new Computers(null,"Lenovo"+r.nextInt(100),1500,10,null,null);
//        Product computer2 = new Computers(null,"Dell"+r.nextInt(100),2000,100,null,null);
//        productService.addNewProduct(computer1);
//        productService.addNewProduct(computer2);
//
//        Product cellphone1 = new CellPhones(null,"Google"+r.nextInt(100),500,10,null,null);
//        Product cellphone2 = new CellPhones(null,"Samsung"+r.nextInt(100),900,100,null,null);
//        productService.addNewProduct(cellphone1);
//        productService.addNewProduct(cellphone2);
//
//        Product mencloth1 = new MenClothes(null,"Bearmen"+r.nextInt(100),70,10,null,null);
//        Product mencloth2 = new MenClothes(null,"Snowmen"+r.nextInt(100),100,100,null,null);
//        productService.addNewProduct(mencloth1);
//        productService.addNewProduct(mencloth2);
//
//        Product womencloth1 = new WomenClothes(null,"Bearwomen"+r.nextInt(100),70,10,null,null);
//        Product womencloth2 = new WomenClothes(null,"Snowwomen"+r.nextInt(100),100,100,null,null);
//        productService.addNewProduct(womencloth1);
//        productService.addNewProduct(womencloth2);
//
//        System.out.println("Number of products: "+productService.getAllProducts().size());
//        if (productService.getAllElectronics().isPresent())
//            System.out.println("Number of electronics "+productService.getAllElectronics().get().size());
//    }
//
//}
