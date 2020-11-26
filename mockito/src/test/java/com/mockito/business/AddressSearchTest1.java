package com.mockito.business;

import com.mockito.business.model.Address;
import com.mockito.business.model.ZipCode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

//Uma maneira é por configuração programática,
public class AddressSearchTest1 {

    private AddressSearch addressSearch;

    private AddressSearchService mockAddressSearchService;

    @Before
    public void setUp(){
        //mockAddressSearchService = Mockito.mock(AddressSearchService.class);
        mockAddressSearchService = mock(AddressSearchService.class);
        addressSearch = new AddressSearch(mockAddressSearchService);
    }

    @Test
    public void shouldFindAddressByZipCode(){

//        String zipCode = "12345678";
//
//        String addressResult = "Rua Beira Rio|São Paulo|SP|12345678";
//
//        Mockito.when(mockAddressSearchService.searchByZipCode(zipCode)).thenReturn(addressResult);
//
//        Address address = addressSearch.findBy(new ZipCode(zipCode));
//
//        Assert.assertEquals("Rua Beira Rio", address.getStreet());
//        Assert.assertEquals("São Paulo", address.getCity());
//        Assert.assertEquals("SP", address.getState());
//        Assert.assertEquals(new ZipCode("12345678"), address.getZipCode());



    }
}
