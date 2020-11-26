package com.mockito.business;

import com.mockito.business.model.Address;
import com.mockito.business.model.ZipCode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddressSearchTest5 {

    @Mock
    private AddressSearchService mockAddressSearchService;

    @InjectMocks
    private AddressSearch addressSearch;

    @Test
    public void shouldFindAddressByZipCode(){
        String zipCode = "12345678";

        String addressResult = "Rua Beira Rio|São Paulo|SP|12345678";

        when(mockAddressSearchService.searchByZipCode(zipCode)).thenReturn(addressResult);

        Address address = addressSearch.findBy(new ZipCode(zipCode));
        assertEquals("Rua Beira Rio", address.getStreet());
        assertEquals("São Paulo", address.getCity());
        assertEquals("SP", address.getState());
        Assert.assertEquals(new ZipCode("12345678"), address.getZipCode());
    }
}
