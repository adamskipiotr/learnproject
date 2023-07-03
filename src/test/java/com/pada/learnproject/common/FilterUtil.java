package com.pada.learnproject.common;

import java.util.ArrayList;
import java.util.List;

public class FilterUtil {

    public static FilterBuilder filterBy() {
        return new FilterBuilder();
    }

    public static class FilterBuilder {
        private final List<String> filters = new ArrayList<>();

        public FilterBuilder param(String name, Object value) {
            filters.add(name + "=" + value);
            return this;
        }

        public FilterBuilder param(String name, List<String> values) {
            filters.add(name + "=" + String.join(",", values));
            return this;
        }

        public boolean isEmpty() {
            return filters.isEmpty();
        }

        public String toQueryString() {
            if (isEmpty()) {
                return "";
            } else {
                return "?" + this;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < filters.size(); i++) {
                sb.append(filters.get(i));
                if (i + 1 != filters.size()) {
                    sb.append("&");
                }
            }
            return sb.toString();
        }
    }
}
