package com.test.nonecache;

import static com.test.nonecache.LottoNumber.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    private static final int VALID_SIZE = 6;
    
    public static List<LottoNumber> generate() {
        return new Random().ints(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND + 1)
                            .distinct()
                            .limit(VALID_SIZE)
                            .mapToObj(LottoNumber::new)
                            .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<LottoNumber> list = LottoNumberGenerator.generate();

        for(LottoNumber num : list) {
            System.out.println(num.toString());
        }
    }
}