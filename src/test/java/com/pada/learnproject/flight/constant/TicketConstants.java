package com.pada.learnproject.flight.constant;

public interface TicketConstants {

     class FilteringFields {
         public static final String TICKET_CLASS = "ticketClass";
         public static final String BASE_PRICE = "basePrice";
         public static final String LUGGAGE_FEE = "luggageFee";
        private FilteringFields() {
        }
    }

    class Urls {
         public static final String TICKETS = "/tickets";

         public static String createUrlWithEntityId(Long id){
             return TICKETS + "/" + id;
         }
    }
}
