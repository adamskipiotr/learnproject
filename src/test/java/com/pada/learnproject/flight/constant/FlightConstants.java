package com.pada.learnproject.flight.constant;

import com.pada.learnproject.flight.domain.FlightStatus;

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

        public static String createUrlWithEntityIdAndStatus(Long id, FlightStatus status){
            return FLIGHTS + "/" + id + "/" + status;
        }
    }
}
