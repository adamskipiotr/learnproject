package com.pada.learnproject.flight.constant;

public interface FlightConstants {

     class FilteringFields {

        private FilteringFields() {
        }
    }

    class Urls {
         public static final String FLIGHTS = "/flights";

         public static String createUrlWithEntityId(Long id){
             return FLIGHTS + "/" + id;
         }
    }
}
