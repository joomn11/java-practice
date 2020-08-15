package com.test.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    

    public static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    public static final int LOTTO_NUMBER_UPPER_BOUND = 45;

    private static final List<LottoNumber> CACHE = new ArrayList<>();

    static {
        for (int i = LOTTO_NUMBER_LOWER_BOUND; i <= LOTTO_NUMBER_UPPER_BOUND; i++) {
            CACHE.add(new LottoNumber(i));
        }
    }

    private final int number ;
    
    public LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (number < LOTTO_NUMBER_LOWER_BOUND ||
            number > LOTTO_NUMBER_UPPER_BOUND) {
                throw new IllegalAccessError("LottoNumber가 유효하지 않습니다.");

            }
    }

    public static LottoNumber valueOf(final int number) {
        LottoNumber lottoNumber = CACHE.get(number);

        if(Objects.isNull(lottoNumber)) {
            lottoNumber = new LottoNumber(number);
        }

        return lottoNumber;
    }

	public static List<LottoNumber> values() {
		return CACHE;
    }
    
    @Override
    public String toString() {
        return "number : " + Integer.toString(number);
    }
}