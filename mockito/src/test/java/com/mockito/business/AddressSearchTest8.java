package com.mockito.business;

import com.mockito.business.model.Address;
import com.mockito.business.model.ZipCode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.regex.Matcher;

@RunWith(MockitoJUnitRunner.class)
public class AddressSearchTest8 {

    @InjectMocks
    private AddressSearch addressSearch;

    @Mock
    private AddressSearchService mockAddressSearchService;

    @Test
    public void findByTest(){
        String zipCode = "12345678";

        String addressResult = "Rua Beira Rio|São Paulo|SP|12345678";

        Mockito.when(mockAddressSearchService.searchByZipCode(zipCode)).thenReturn(addressResult);

        Address address = addressSearch.findBy(new ZipCode(zipCode));

        Assert.assertEquals("Rua Beira Rio", address.getStreet());
        Assert.assertEquals("São Paulo", address.getCity());
        Assert.assertEquals("SP", address.getState());
        Assert.assertEquals(new ZipCode("12345678"), address.getZipCode());

        //Podemos garantir que nosso mock foi invocado da maneira que configuramos
        //O método verify do Mockito, como o nome sugere, verifica se aquele método, daquele mock,
        // foi chamado com aqueles argumentos; se não, é lançada uma exceção (quebrando o teste).
        Mockito.verify(mockAddressSearchService).searchByZipCode(zipCode);

    }



}
