package com.test.nonecache;

public class LottoNumber {
    public static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    public static final int LOTTO_NUMBER_UPPER_BOUND = 45;

    private final int number; 

    public LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (number < LOTTO_NUMBER_LOWER_BOUND 
            || number > LOTTO_NUMBER_UPPER_BOUND) {
                throw new IllegalArgumentException("LottoNumber가 유효하지 않습니다.");

            }
    }

    @Override
    public String toString() {
        return "number : " + Integer.toString(number);
    }
}