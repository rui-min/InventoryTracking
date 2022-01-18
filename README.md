# Inventory Tracking Documentation
 * This is an inventory tracking web application (backend) for a logistics company with CRUD operations. Built with Java, Maven, Spring Boot, Spring Data, Spring Web, Hibernate and MySQL.
 * There are totally 7 classes in the domain directory(/src/main/java/inventory/tracking/domain/), forming a single inheritance tree(see below graph). The backend server provides RESTful APIs to the frontend. Domain classes can be added in future maintenance.
 
![showcase](/docs/domain.jpg)

# Feature
**Filtering based on fields/inventory count/tags/other metadata**. Please see API section "get" methods for more information. Note both id & name are unique for each row of the database table.

# Preparation before running
* Get an IDE: Any IDE that can code Java, obtain Maven and Spring Framework plugins is accpetable. I use IntelliJ Ultimate: https://www.jetbrains.com/idea/download/
* Get and Configure MySQL database: application.properties & pom.xml are configured with MySQL. Download server and workbench from: https://dev.mysql.com/downloads/. **Attention**: open the application.properties file under "/src/main/resources/" and make sure lines 3-5 conform with your local MySQL's configuration (localhost port, username, password). You can change the lines or change your local MySQL settings (do NOT change the "/tracking" part in line 3 if you want to follow below step).
* Import sample MySQL database file: for testing purpose, a sample .sql file "/docs/exampleData.sql" can be imported with MySQL workbench. Note the schema name is "tracking", which is configured in line 3 of application.properties.
* Get Postman for testing APIs: download Postman from https://www.postman.com/downloads/. Need to create an account or login.

# Quick Start
* Ensure the whole repo is cloned or downloaded and unzipped. Open as a project in your IDE and reload Maven file pom.xml. Then run _TrackingApplication.java_ under "/src/main/java/inventory/tracking/" directory.
* Open MySQL server and MySQL workbench. Ensure MySQL database is running and sample data is imported (see above "preparation" section). If you want to create data from scratch, see applicatoin.properties file configuration. Assigned schema name is "tracking".
* Assigned API port is localhost:8090, which can be changed in application.properties. Now open postman, and you can test all APIs in below section.
* Below is my demonstration:

![showcase](/docs/demonstration_get3.jpg)

# APIs
**You can copy & paste the bold links below to Postman url section. Remember to switch to correct method section in the dropdown menu. Also make sure to replace all url portions wrapped with "{}" with values in proper types. The italic parts in some urls are optional(put methods only).** 

1. Get method (read): 
    1. **localhost:8090/api/product/get**  -> return all products' JSON data from the database.
    2. **localhost:8090/api/product/get/id/{Long id}** -> return the specified id product's JSON data from the database.
    3. **localhost:8090/api/product/get/name/{String name}** -> return the specified name product's JSON data from the database(name cannot duplicate).
    4. **localhost:8090/api/product/get/electronics** -> return eletronics type products' JSON data from the database.
    5. **localhost:8090/api/product/get/computers** -> return computers tagged products' JSON data from the database.
    6. **localhost:8090/api/product/get/cellphones** -> return cellphones tagged products' JSON data from the database.
    7. **localhost:8090/api/product/get/clothing** -> return clothing type products' JSON data from the database.
    8. **localhost:8090/api/product/get/menclothes** -> return menclothes tagged products' JSON data from the database.
    9. **localhost:8090/api/product/get/womenclothes** -> return womenclothes tagged products' JSON data from the database.
    10. **localhost:8090/api/product/get/price?lowPrice={double lowPrice}&highPrice={double highPrice}** -> return all products' JSON data falling within the price range from the database.
    11. **localhost:8090/api/product/get/inventory?lower={int lower}&higher={int higher}** -> return all products' JSON data falling within the inventory range from the database.
2. Post method (create): 
    1. **localhost:8090/api/product/post**  -> add a new record to the database and return it. Please provide a JSON body in Postman such as:     
    {"name": "Pixel6", "price": 500.0, "inventory": 999, "type": "electronics", "tag": "cellphone", "id": null}
    
3. Put method (update): 
    1. **localhost:8090/api/product/put/id/{Long id}_?name={String name}&price={Double price}&inventory={Integer inventory}&type={String type}&tag={String tag}_** -> update the specified id product's fields in the database. The to-be-updated attributes are selective and optional(shown as italic).
    2. **localhost:8090/api/product/put/name/{String name}_?price={Double price}&inventory={Integer inventory}&type={String type}&tag={String tag}_** -> update the specified name product's fields in the database. The to-be-updated attributes are selective and optional(shown as italic).

4. Delete method (delete): 
    1. **localhost:8090/api/product/delete/id/{Long id}** -> delete based on id and return a message if successfully deleted
    2. **localhost:8090/api/product/delete/name/{String name}** -> delete based on unique name(name of products cannot duplicate) and return a message if successfully deleted 
