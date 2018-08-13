package com.touraj.pim;

import com.touraj.pim.Repository.CategoryRepository;
import com.touraj.pim.domain.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriesTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void testSaveAndLoadCategory() {
		System.out.println("Test Save and Load Category!");
		Category category1 = new Category("House", 100);
		categoryRepository.save(category1);
		Category cat = categoryRepository.findByName("House");
		Assert.assertNotNull(cat);
		Assert.assertEquals("House", cat.getName());
	}

	@Test
	public void testSaveAndDeleteCategory() {
		System.out.println("Test Delete Category!");
		Category category1 = new Category("Tool", 101);
		categoryRepository.save(category1);
		Category cat = categoryRepository.findByName("Tool");
		Assert.assertNotNull(cat);
		Assert.assertEquals("Tool", cat.getName());
		categoryRepository.delete(cat);
		Category catAfterDelete = categoryRepository.findByName("Tool");
		Assert.assertNull(catAfterDelete);
	}

	@Test
	public void testSaveAndUpdateCategory() {
		System.out.println("Test Update Category!");
		Category category1 = new Category("Car", 102);
		categoryRepository.save(category1);
		Category cat = categoryRepository.findByName("Car");
		Assert.assertNotNull(cat);
		Assert.assertEquals("Car", cat.getName());
		cat.setName("BigCar");
		categoryRepository.save(cat);
		Category catOld = categoryRepository.findByName("Car");
		Assert.assertNull(catOld);
		Category catAfterUpdate = categoryRepository.findByName("BigCar");
		Assert.assertNotNull(catAfterUpdate);
	}
}
