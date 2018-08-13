package com.touraj.pim.controller;

import com.touraj.pim.Repository.CategoryRepository;
import com.touraj.pim.Repository.ProductRepository;
import com.touraj.pim.domain.Product;
import com.touraj.pim.util.CSVImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by toraj on 08/12/2018.
 */
@Controller
public class ProductController {

    private static final String CATFILENAME = "CategoryData.csv";
    private static final String PRODUCTFILENAME = "ProductData.csv";

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        return "home";
    }

    @RequestMapping("/import")
    public String importCSVData(Map<String, Object> model) {
        new CSVImport(categoryRepository, productRepository).importCSVDatatoPIM(CATFILENAME, PRODUCTFILENAME);
        return "import";
    }

    @RequestMapping("/products")
    public String products(Map<String, Object> model) {
        try {
            List<Product> products;
            products = (List<Product>) productRepository.findAll();
            model.put("products", products);
            return "products";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "products";
    }

    @RequestMapping("/download")
    public String download(Model model) {

        model.addAttribute("products", productRepository.findAll());
        return "";
    }
}
