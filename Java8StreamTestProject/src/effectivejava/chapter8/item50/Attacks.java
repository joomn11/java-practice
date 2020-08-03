package effectivejava.chapter8.item50;

import java.util.Date;

public class Attacks {
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();

        Period p = new Period(start, end);
        System.out.println(p);

        end.setYear(88);
        System.out.println(p);

        p.end().setYear(34);
        System.out.println(p);
    }
}