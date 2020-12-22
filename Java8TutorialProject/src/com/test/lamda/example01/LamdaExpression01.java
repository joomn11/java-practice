package com.test.lamda.example01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LamdaExpression01 {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("새우깡", 1200, true, "농심", "이마트"));
        products.add(new Product("감자깡", 1200, true, "농심", "이마트"));
        products.add(new Product("양파링", 1000, true, "농심", "홈플러스"));
        products.add(new Product("고구마칩", 3000, true, "오리온", "홈플러스"));
        products.add(new Product("자갈치", 800, true, "오리온", "홈플러스"));
        products.add(new Product("가위", 4000, false, "문방구", "코스트코"));
        products.add(new Product("청소기", 70000, false, "LG", "코스트코"));
        products.add(new Product("양주", 30000, true, "진로", "코스트코"));
        products.add(new Product("곰젤리", 4000, true, "Bear", "코스트코"));

        List<Product> filteredByName = filterByName(products, "새우깡");
        List<Product> filterByPrice = filterByPrice(products, 1000);
        List<Product> filterByStoreAndName = filterByStoreAndName(products, "오리온", "자갈치");
        List<Product> filterByStoreAndNameAndFood = filterByStoreAndNameAndFood(products, "오리온", "자갈치", true);

        System.out.println(filteredByName.toString());
        System.out.println(filterByPrice.toArray().toString());
        System.out.println(filterByStoreAndName.toString());
        System.out.println(filterByStoreAndNameAndFood.toString());

        // Strategy Pattern Example
        List<Product> filteredByName01 = filter(products, new NameFilter("새우깡"));
        List<Product> filterByPrice01 = filter(products, new NameAndStoreFilter("새우깡", "owner"));

        System.out.println(filteredByName01);
        System.out.println(filterByPrice01);

        // Lamda Example
        // List<Product> filteredByName01 = filter(products, new NameFilter("새우깡"));
        List<Product> filteredByName011 = filter(products, p -> p.getName().equals("새우깡"));

        // List<Product> filterByPrice01 = filter(products, new
        // NameAndStoreFilter("새우깡", "owner"));
        List<Product> filterByPrice011 = filter(products,
                p -> p.getName().equals("새우깡") && p.getStore().equals("owner"));

        System.out.println(filteredByName011);
        System.out.println(filterByPrice011);

        // Predicat <T> interface
        List<Product> filterByName02 = filterPredicate(products, p->p.getName().equals("새우깡"));
        System.out.println(filterByName02);
    }

    public static ArrayList<Product> filterPredicate(ArrayList<Product> products, Predicate<Product> filter) {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (filter.test(product)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public static ArrayList<Product> filter(ArrayList<Product> products, FilterPredicate filterInterface) {
        ArrayList<Product> filteredProducts = new ArrayList<>();

        for (Product product : products) {
            if (filterInterface.filter(product)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public static List<Product> filterByName(List<Product> products, String name) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {

            if (product.getName().equals(name)) {
                filteredProducts.add(product);
            }
        }

        return filteredProducts;
    }

    public static List<Product> filterByPrice(List<Product> products, int price) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {

            if (product.getPrice() <= price) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public static List<Product> filterByStoreAndName(List<Product> products, String name, String store) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {

            if (product.getName().equals(name) && product.getStore().equals(store)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public static List<Product> filterByStoreAndNameAndFood(List<Product> products, String name, String store,
            boolean isFood) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(name) && product.getStore().equals(store) && product.isFood() == isFood) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

}
