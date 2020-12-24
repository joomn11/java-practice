package com.test.lamda.example03;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.test.lamda.example01.Product;

public class LamdaExpression03 {
    
    public static void main(String[] args) {
        Predicate<String> isEmptyString = s-> s.isEmpty() ;

        Consumer<Integer> println = i -> System.out.println("" + i) ;

        Function<String, Integer> strCnt = s -> s.length();

        Supplier<Product> makeObj = () -> new Product("", 2, true, "madeby", "storeName");

        UnaryOperator<Integer> sum = i -> i+i;

        IntPredicate iPredicate = i -> i % 2 == 0 ;
        Predicate<Integer> iPredicate2 = i -> i % 2 ==0 ; // auto boxing ! 
        
        IntPredicate ff = new IntPredicate(){
            
            int test = 99 ;

            @Override
            public boolean test(int value) {
                return false;
            }
            
        };
        
        System.out.println(isEmptyString);
        System.out.println(println);
        System.out.println(strCnt);
        System.out.println(makeObj);
        System.out.println(sum);
        System.out.println(iPredicate);
        System.out.println(iPredicate2);

        // method reference 

    }
}
