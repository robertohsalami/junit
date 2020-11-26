package com.mockito.business;

import com.mockito.business.model.Address;
import com.mockito.business.model.ZipCode;

public class AddressSearch {

    // serviço de pesquisa de endereços a partir de um CEP.
    //serviço externo pode ser um banco de dados dos endereços brasileiros (acessado por JDBC), ou um web service SOAP/REST disponibilizado por outra empresa.
    private final AddressSearchService addressSearchService;

    public AddressSearch(AddressSearchService addressSearchService){
        this.addressSearchService = addressSearchService;
    }

    public Address findBy(ZipCode zipCode){
        //o cara ser MOCKADO PQ é um serviço externo
        String addressAsString = addressSearchService.searchByZipCode(zipCode.getValue());

        String[] parts = addressAsString.split("\\|");

        Address address = new Address();
        address.setStreet(parts[0]);
        address.setCity(parts[1]);
        address.setState(parts[2]);
        address.setZipCode(new ZipCode(parts[3]));

        return address;
    }

    public Address findBy(String street, String city, String state){
        String addressAsString = addressSearchService.searchZipCodeByAddress(street, city, state);

        String[] parts = addressAsString.split("\\|");

        Address address = new Address();
        address.setStreet(parts[0]);
        address.setCity(parts[1]);
        address.setState(parts[2]);
        address.setZipCode(new ZipCode(parts[3]));

        return address;

    }

}
