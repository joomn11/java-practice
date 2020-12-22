package com.test.lamda.example02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.test.lamda.example01.Product;

public class LamdaExpression02 {
    public static void main(String[] args) {
        
        List<Product> products = new ArrayList<>();
        products.add(new Product("새우깡", 1200, true, "농심", "이마트"));
        products.add(new Product("감자깡", 1200, true, "농심", "이마트"));
        products.add(new Product("양파링", 1000, true, "농심", "홈플러스"));
        products.add(new Product("고구마칩", 3000, true, "오리온", "홈플러스"));
        products.add(new Product("자갈치", 800, true, "오리온", "홈플러스"));
        products.add(new Product("가위", 4000, false, "문방구", "코스트코"));
        products.add(new Product("청소기", 70000, false, "LG", "코스트코"));
        products.add(new Product("양주", 30000, true, "진로", "코스트코"));
        products.add(new Product("곰젤리", 4000, true, "Bear", "코스트코"));

        Collections.sort(products, new Comparator<Product>(){

			@Override
			public int compare(Product o1, Product o2) {
				return o1.getPrice() - o2.getPrice();
			}
            
        });


        products.sort(new Comparator<Product>(){

            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
            
        }); 
        products.sort((p1,p2)->p1.getPrice() - p2.getPrice());


        // Example 2 

        Thread th = new Thread(new Runnable(){
            
            @Override
            public void run() {
                System.out.println("new Thread!! ");
            }
        });
        th.run();

        Thread th2 = new Thread(()-> System.out.println("new Thread @@ "));
        th2.run();

    }
}
