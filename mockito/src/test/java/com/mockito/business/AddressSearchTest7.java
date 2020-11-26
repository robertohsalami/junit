package com.mockito.business;

import com.mockito.business.model.Address;
import com.mockito.business.model.ZipCode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressSearchTest7 {

    @Mock
    private AddressSearchService mockAddressSearchService;

    @InjectMocks
    private AddressSearch addressSearch;

    @Before
    public void setUp(){
        String addressResult = "Rua Beira Rio|São Paulo|SP|12345678";
        // se o método que estamos configurando possui mais de um argumento, e queremos utilizar argument matchers, teremos que utilizá-los em todos os argumentos
        when(mockAddressSearchService.searchZipCodeByAddress(anyString(), eq("São Paulo"), eq("SP"))).thenReturn(addressResult);
    }

    @Test
    public void shouldFindAddressByZipCode() {
        Address address = addressSearch.findBy("", "São Paulo", "SP");

        assertEquals("Rua Beira Rio", address.getStreet());
        assertEquals("São Paulo", address.getCity());
        assertEquals("SP", address.getState());
        assertEquals(new ZipCode("12345678"), address.getZipCode());
    }


}
