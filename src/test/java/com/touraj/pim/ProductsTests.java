package com.touraj.pim;

import com.touraj.pim.Repository.CategoryRepository;
import com.touraj.pim.Repository.ProductRepository;
import com.touraj.pim.domain.Category;
import com.touraj.pim.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by toraj on 08/12/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveAndLoadProduct() {
        System.out.println("Test Save and Load Product!");
        Category category1 = new Category("CellPhones", 1000);
        categoryRepository.save(category1);
        Product product1 = new Product("69D8B","Samsung", category1, "good Cellphone", 7, "NO", 596.45, true);
        productRepository.save(product1);
        Product product = productRepository.findByName("Samsung");
        Assert.assertNotNull(product);
        Assert.assertEquals("Samsung", product.getName());
    }

    @Test
    public void testSaveAndDeleteProduct() {
        System.out.println("Test Save and Load Delete!");
        Category category1 = new Category("Mobile", 2000);
        categoryRepository.save(category1);
        Product product1 = new Product("39D77","LG", category1, "good Cellphone", 70, "NO", 326.15, true);
        productRepository.save(product1);
        Product product = productRepository.findByName("LG");
        Assert.assertNotNull(product);
        Assert.assertEquals("LG", product.getName());
        productRepository.delete(product);
        Product productAfterDelete = productRepository.findByName("LG");
        Assert.assertNull(productAfterDelete);
    }

    @Test
    public void testSaveAndUpdateProduct() {
        System.out.println("Test Save and Update Product!");
        Category category1 = new Category("Phone", 300);
        categoryRepository.save(category1);
        Product product1 = new Product("77231","HTC", category1, "very good Cellphone", 17, "NO", 300, true);
        productRepository.save(product1);
        Product product = productRepository.findByName("HTC");
        Assert.assertNotNull(product);
        Assert.assertEquals("HTC", product.getName());
        product.setName("HTC One");
        productRepository.save(product);
        Product productOld = productRepository.findByName("HTC");
        Assert.assertNull(productOld);
        Product productAfterUpdate = productRepository.findByName("HTC One");
        Assert.assertNotNull(productAfterUpdate);
    }
}
