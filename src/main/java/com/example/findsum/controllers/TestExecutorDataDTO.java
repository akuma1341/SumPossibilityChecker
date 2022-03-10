package com.example.findsum.controllers;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

public enum TestExecutorDataDTO {
    ;

    private interface Numbers {
        List<Integer> getNumbers();
    }

    private interface Result {
        Boolean getResult();
    }

    public enum Request {
        ;

        @Value
        public static class Check implements Numbers {
            List<Integer> numbers = new ArrayList<>();
        }
    }

    public enum Response {
        ;

        @Value
        public static class ResultOfCheck implements Result {
            Boolean result;
        }

        @Value
        public static class AllData implements Numbers, Result {
            List<Integer> numbers = new ArrayList<>();
            Boolean result;
        }
    }
}
