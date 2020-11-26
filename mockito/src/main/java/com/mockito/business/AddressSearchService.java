package com.mockito.business;

public interface AddressSearchService {

    public String searchByZipCode(String zipCode);

    public String searchZipCodeByAddress(String street, String city, String state);

}
