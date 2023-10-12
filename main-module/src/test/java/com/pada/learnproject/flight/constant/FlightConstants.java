package com.pada.learnproject.flight.constant;

public interface FlightConstants {

     class FilteringFields {
         public static final String FLIGHT_START_LOWER_BOUNDARY = "flightStartLowerBoundary";
         public static final String FLIGHT_START_UPPER_BOUNDARY = "flightStartUpperBoundary";

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
