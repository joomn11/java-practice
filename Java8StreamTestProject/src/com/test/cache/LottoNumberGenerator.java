package com.test.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private static final int VALID_SIZE = 6;

    public static List<LottoNumber> generate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumber.values());
        
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, VALID_SIZE);

    }

    public static void main(String[] args) {
        List<LottoNumber> list = LottoNumberGenerator.generate();

        for(LottoNumber num : list) {
            System.out.println(num.toString());
        }
    }
}