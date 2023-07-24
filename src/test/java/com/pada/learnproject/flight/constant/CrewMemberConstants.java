package com.pada.learnproject.flight.constant;

public interface CrewMemberConstants {

     class FilteringFields {
         public static final String FIRSTNAME = "firstName";
         public static final String LASTNAME = "lastName";
         public static final String AGE = "age";

        private FilteringFields() {
        }
    }

    class Urls {
         public static final String CREW_MEMBERS = "/crew-members";

         public static String createUrlWithEntityId(Long id){
             return CREW_MEMBERS + "/" + id;
         }
    }
}
