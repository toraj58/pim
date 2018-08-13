package com.touraj.pim.util;

import com.touraj.pim.Repository.CategoryRepository;
import com.touraj.pim.Repository.ProductRepository;
import com.touraj.pim.domain.Category;
import com.touraj.pim.domain.Product;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by toraj on 08/12/2018.
 */

@Component
public class CSVImport {

    private String splitRegEx = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    List<Category> categories = new ArrayList<>();
    List<Product> products = new ArrayList<>();

    public CSVImport(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    private void readCSVAndPopulateCategories(String file) {
        parsFileAndPopulateData(file, "category");
    }

    private void readCSVAndPopulateProducts(String file) {
        parsFileAndPopulateData(file, "product");
    }

    private void parsFileAndPopulateData(String file, String type) {
        String line;
        String workingDir = System.getProperty("user.dir");
        boolean hasHeader= true;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(workingDir+"/"+file));
            while ((line = br.readLine()) != null) {
                if (hasHeader) {
                    hasHeader = false;
                    continue;
                }
                if (type.equalsIgnoreCase("category")) {
                addCategory(line);
                } else if (type.equalsIgnoreCase("product")) {
                    addProduct(line);
                } else {
                    System.out.println("Incorrect Type");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void addCategory(String line) {
        Category category = new Category();
        String[] dataSplited = line.split(splitRegEx, -1);
        category.setCategoryid(Long.parseLong(dataSplited[0]));
        category.setName(dataSplited[1]);
        categories.add(category);
    }

    private void addProduct(String line) {
        Product product = new Product();
        String[] dataSplited = line.split(splitRegEx, -1);
        product.setZamroid(dataSplited[0]);
        String name = dataSplited[1].replace("\"", "");
        product.setName(name);
        String description = dataSplited[2].replace("\"", "");
        product.setDescription(description);
        product.setMinorderquantity(Utility.parsInt(dataSplited[3]));
        product.setUnitofmeasure(dataSplited[4]);
        Optional<Category> category = Utility.findCategoryByID(categories, Long.parseLong(dataSplited[5]));
        product.setCategory(category.get());
        product.setPurchaseprice(Utility.parsDouble(dataSplited[6]));
        product.setAvailable(Utility.convertToBoolean(dataSplited[7]));
        products.add(product);
    }

    public void persisAllCategoriesBatch() {
        categoryRepository.save(categories);
    }

    public void persisAllProductsBatch() {
        productRepository.save(products);
    }

    public void importCSVDatatoPIM(String catFileName, String productFileName){
        readCSVAndPopulateCategories(catFileName);
        persisAllCategoriesBatch();
        readCSVAndPopulateProducts(productFileName);
        persisAllProductsBatch();
    }
}