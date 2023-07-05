package com.pada.learnproject.example.constant;

public interface ExampleEntityConstants {

     class FilteringFields {
        public static final String NAME = "name";
        public static final String VALUE = "companyName";

        private FilteringFields() {
        }
    }

    class Urls {
         public static final String EXAMPLES = "/examples";

         public static String createUrlWithEntityId(Long id){
             return EXAMPLES + "/" + id;
         }
    }
}
