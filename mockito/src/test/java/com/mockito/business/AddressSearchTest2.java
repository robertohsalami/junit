package com.mockito.business;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.MockitoAnnotations.*;

//Outra maneira é declarar os mocks utilizando anotações:
public class AddressSearchTest2 {

    //Adicionamos a anotação @Mock ao atributo.
    @Mock
    private AddressSearchService mockAddressSearchService;

    private AddressSearch addressSearch;

    //no setup do nosso teste, incluímos uma chamada para a classe MockitoAnnotations, que é responsável por processar as anotações da classe
    //enviada para o método initMocks
    @Before
    public void setUp(){
        //MockitoAnnotations.initMocks(this);
        initMocks(this);
        addressSearch = new AddressSearch(mockAddressSearchService);
    }

    @Test
    public void shouldFindAddressByZipCode(){

    }
}
