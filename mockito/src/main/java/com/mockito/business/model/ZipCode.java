package com.mockito.business.model;

import java.util.Objects;

public class ZipCode {

    private String value;

    public ZipCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode = (ZipCode) o;
        return value.equals(zipCode.value);
    }

}
