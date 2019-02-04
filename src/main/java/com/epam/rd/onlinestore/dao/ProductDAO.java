package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

    List<Product> findAll();

//    private List<Product> productList;
//
//    @PostConstruct
//    private void init() {
//        List<Product> products = new ArrayList<>();
//
//        products.add(new Product(0, "Elysium (Pandorum)", 1, 300000, "elysium_pandorum.jpg"));
//        products.add(new Product(1, "Death star (Star wars)", 1, 300000, "death_star.jpg"));
//        products.add(new Product(2, "Ещё большой корабль", 1, 300000, "elysium_pandorum.jpg"));
//        products.add(new Product(3, "Avalon (Passengers)", 1, 300000, "axiom_wall_e.jpg"));
//        products.add(new Product(4, "Axiom (WALL-E)", 1, 300000, "elysium_pandorum.jpg"));
//        products.add(new Product(5, "Tet (Oblivion)", 1, 300000, "tet_oblivion.jpg"));
//        products.add(new Product(6, "Ещё большой корабль", 1, 300000, "elysium_pandorum.jpg"));
//        products.add(new Product(7, "Ещё большой корабль", 1, 300000, "elysium_pandorum.jpg"));
//        products.add(new Product(8, "Ещё большой корабль", 1, 300000, "elysium_pandorum.jpg"));
//
//        products.add(new Product(9, "Alien ship (Prometheus)", 2, 300000, "alien_prometheus.jpg"));
//        products.add(new Product(10, "Rocinante (Expanse)", 2, 300000, "rocinante_expanse.jpg"));
//        products.add(new Product(11, "Alien ship (Prometheus)", 2, 300000, "alien_prometheus.jpg"));
//        products.add(new Product(12, "Alien ship (Prometheus)", 2, 300000, "alien_prometheus.jpg"));
//
//        products.add(new Product(13, "Восток-1 (Юрий Гагарин)", 3, 300000, "vostok_1_gagarin.jpg"));
//        products.add(new Product(14, "Пепелац (Кин-Дза-Дза)", 3, 300000, "pepelaz_kin_dza_dza.jpg"));
//        products.add(new Product(15, "BubbleShip (Oblivion)", 3, 300000, "bubbleship_oblivion.jpg"));
//        products.add(new Product(16, "Пепелац (Кин-Дза-Дза)", 3, 300000, "pepelaz_kin_dza_dza.jpg"));
//
//        Product.setMaxId(16);
//        this.productList = products;
//    }

//    public List<Product> findAll() {
//        return productList;
//    }
//
//    public Product save(Product product) {
//        Product productInList = findById(product.getId());
//        int index = productList.indexOf(productInList);
//        productList.set(index, product);
//        return product;
//    }
    Product save(Product product);


//
//    public Product findById(long id) {
//        return productList.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
//    }
//
    Product findById(long id);


//    public boolean deleteById(long id) {
//        return productList.removeIf(x -> x.getId()==id);
//    }
    boolean deleteById(long id);


//    public boolean add(Product product) {
//        product.generateId(product);
//        return productList.add(product);
//    }
    //boolean save(Product product);

//
//    public List<Product> findByName(String productName) {
//        return productList.stream().filter(o->o.getName().contains(productName)).collect(Collectors.toList());
//    }
    List<Product> findByName(String productName);

//
//    public List<Product> findByPrice(String productPrice) {
//        return productList.stream().filter(o->String.valueOf(o.getPrice()).contains(productPrice)).collect(Collectors.toList());
//    }

}
