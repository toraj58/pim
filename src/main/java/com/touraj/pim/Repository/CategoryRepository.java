package com.touraj.pim.Repository;

import com.touraj.pim.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by toraj on 08/10/2018.
 * This Interface has the Default CRUD operation like Save, findAll, update and Delete
 * After Running the Project Spring Data will create Automatically CRUD Operation for the type
 * of the Database Specified in the application.properties file.
 * Easy you can switch from Database e.g. H2, Mysql, Oracle, Postgres and etc.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

    /**
     * You can use this method to find Categories base on Name.
     * @param name is the name of the Category you want to find
     * @return will return the Category found base on name
     */
    Category findByName(String name);
}
