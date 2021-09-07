package com.example;

import java.time.LocalDate;
import java.util.Optional;

public class Entry {
    private static final LocalDate GEN_ALPHA = LocalDate.ofYearDay(2010,1); //1
    private static final LocalDate GEN_Z = LocalDate.ofYearDay(1997, 1); //2
    private static final LocalDate GEN_MILLENIALS = LocalDate.ofYearDay(1981, 1); //3

    public static void main(String... args){
        //noCheckOpt(); //4
        //checkOpt(); //5
        //optChain(); //6
    }

    private static boolean isGenZ(LocalDate d){ //7
        return d.isBefore(GEN_ALPHA) && d.isAfter(GEN_MILLENIALS);
    }

    private static void noCheckOpt(){ //8
        Optional<LocalDate> opt = Optional.empty();

        LocalDate ogDate = opt.get(); //9

        if(isGenZ(ogDate)){
            LocalDate modifiedDate = ogDate
                    .plusYears(1)
                    .plusMonths(5)
                    .plusDays(10);
            System.out.println(modifiedDate);
        }
    }

    private static void checkOpt(){ //10
        Optional<LocalDate> opt = Optional.empty(); //11

        if(opt.isPresent()){ //12
            LocalDate ogDate = opt.get(); //13
            if(isGenZ(ogDate)){ //14
                LocalDate modifiedDate = ogDate //15
                        .plusYears(1)
                        .plusMonths(5)
                        .plusDays(10);
                System.out.println(modifiedDate);
            }
        }
    }

    private static void optChain(){ //16
        Optional.<LocalDate>empty() //17
                .filter(Entry::isGenZ) //18
                .map(d -> d.plusYears(1).plusMonths(5).plusDays(10)) //19
                .ifPresent(System.out::println); //20
    }

}
