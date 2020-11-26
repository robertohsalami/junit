package com.mockito.business;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class AddressSearchTest3 {

    //O MockitoRule realiza o mesmo processamento de anotações demonstrado nos exemplos anteriores.
    // Também é útil ter essa opção se você não puder utilizar o MockitoJUnitRunner (lembre que os campos anotados com @Rule devem ser públicos!).
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private AddressSearchService mockAddressSearchService;

    public AddressSearch addressSearch;

    @Before
    public void setUp(){
        addressSearch = new AddressSearch(mockAddressSearchService);
    }

    @Test
    public void shouldFindAddressByZipCode(){

    }

}
