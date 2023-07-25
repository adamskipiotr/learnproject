package com.pada.learnproject.flight.constant;

public interface PassengerConstants {

     class FilteringFields {
         public static final String FIRSTNAME = "firstName";
         public static final String LASTNAME = "lastName";
         public static final String AGE = "age";
         public static final String IS_PREMIUM = "isPremium";

        private FilteringFields() {
        }
    }

    class Urls {
         public static final String PASSENGERS = "/passengers";

         public static String createUrlWithEntityId(Long id){
             return PASSENGERS + "/" + id;
         }
    }
}
