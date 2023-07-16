package com.pada.learnproject.example.domain;

public enum ExampleEnum {

    POSITION_1("Position 1") {
        @Override
        public ExampleEnum toggle() {
            return POSITION_2;
        }
    },
    POSITION_2("Position 2") {
        @Override
        public ExampleEnum toggle() {
            return POSITION_3;
        }
    },
    POSITION_3("Position 3") {
        @Override
        public ExampleEnum toggle() {
            return POSITION_1;
        }
    };

    String value;


    ExampleEnum(String value) {
        this.value = value;
    }

    public abstract ExampleEnum toggle();
}
