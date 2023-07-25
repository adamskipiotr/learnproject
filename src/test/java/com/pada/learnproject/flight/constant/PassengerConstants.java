package com.pada.learnproject.flight.constant;

public interface PassengerConstants {

     class FilteringFields {
         public static final String NAME = "name";
         public static final String WEATHER_CONDITION = "weatherCondition";

        private FilteringFields() {
        }
    }

    class Urls {
         public static final String AIRPORTS = "/airports";

         public static String createUrlWithEntityId(Long id){
             return AIRPORTS + "/" + id;
         }
    }
}
