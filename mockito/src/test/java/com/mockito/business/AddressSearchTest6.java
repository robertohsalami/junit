package com.mockito.business;

import com.mockito.business.model.Address;
import com.mockito.business.model.ZipCode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AddressSearchTest6 {

    @Mock
    private AddressSearchService mockAddressSearchService;

    @InjectMocks
    private AddressSearch addressSearch;

    @Before
    public void setUp(){
        String addressResult = "Rua Beira Rio|São Paulo|SP|12345678";
        //“quando o método searchByZipCode, do objeto mockAddressSearchService, for invocado com uma String qualquer, devolva esse resultado”.
        when(mockAddressSearchService.searchByZipCode(anyString())).thenReturn(addressResult);
    }

    @Test
    public void shouldFindAddressByZipCode() {
        Address address = addressSearch.findBy(new ZipCode("12345678"));

        assertEquals("Rua Beira Rio", address.getStreet());
        assertEquals("São Paulo", address.getCity());
        assertEquals("SP", address.getState());
        assertEquals(new ZipCode("12345678"), address.getZipCode());
    }



}
