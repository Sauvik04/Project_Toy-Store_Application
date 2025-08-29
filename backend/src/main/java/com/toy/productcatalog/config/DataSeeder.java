package com.toy.productcatalog.config;

import com.toy.productcatalog.model.Category;
import com.toy.productcatalog.model.Product;
import com.toy.productcatalog.repository.CategoryRepository;
import com.toy.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        //create categories
        Category cars = new Category();
        cars.setName("Toy car");

        Category An1 = new Category();
        An1.setName("Anime figure");

        Category gun1 = new Category();
        gun1.setName("Toy gun");

        categoryRepository.saveAll(Arrays.asList(cars,An1,gun1));

        //create products

        Product hot1 = new Product();
        hot1.setName("Hotwheels Car");
        hot1.setDescription("Collectable hotwheels car");
        hot1.setImageUrl("/pagani.jpg");
        hot1.setPrice(49.99);
        hot1.setCategory(cars);

        Product hot2 = new Product();
        hot2.setName("Hotwheels Van");
        hot2.setDescription("Collectable rare hotwheels van");
        hot2.setImageUrl("/van.jpg");
        hot2.setPrice(79.99);
        hot2.setCategory(cars);

        Product zoro = new Product();
        zoro.setName("Zoro");
        zoro.setDescription("The Famous character from One Piece is here");
        zoro.setImageUrl("/zoro.jpg");
        zoro.setPrice(99.99);
        zoro.setCategory(An1);

        Product ak = new Product();
        ak.setName("Ak47 Toy gun");
        ak.setDescription("A collectable toy gun for your child");
        ak.setImageUrl("/ak47.jpg");
        ak.setPrice(29.99);
        ak.setCategory(gun1);

        productRepository.saveAll(Arrays.asList(hot1,hot2,zoro,ak));
    }
}
