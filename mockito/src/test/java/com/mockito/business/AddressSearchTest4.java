package com.mockito.business;

import com.mockito.business.model.Address;
import com.mockito.business.model.ZipCode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

//utilizar um TestRunner do Mockito
//@RunWith (do JUnit), passando como parâmetro a classe MockitoJUnitRunner do Mockito.
//configuração mais fácil de utilizar no Mockito, simplifica o código do teste.
// Mas pode haver situações em que você quer utilizar mocks, porém o seu teste já utiliza o TestRunner de algum outro
// framework (o JUnit permite parametrizar apenas um runner).. Nesses casos, saber criar mocks sem utilizar o MockitoJUnitRunner pode ser útil.
@RunWith(MockitoJUnitRunner.class)
public class AddressSearchTest4 {

    @Mock
    private AddressSearchService mockAddressSearchService;

    //Nos exemplos acima, estamos injetando manualmente nosso mock dentro do objeto que estamos testando, através do construtor da classe AddressSearch.
    //Esse é um trabalho que o Mockito também é capaz de realizar, com o uso da anotação @InjectMocks
    //O atributo anotado com @InjectMocks será instanciado pelo Mockito,
    //e todos os atributos anotados com @Mock são considerados dependências desse objeto.
    @InjectMocks
    private AddressSearch addressSearch;


    @Test
    public void shouldFindAddressByZipCode(){
        String zipCode = "12345678";

        String addressResult = "Rua Beira Rio|São Paulo|SP|12345678";

        //Configurando mock pra devolver o endereço esperado
        //um mock é um objeto que devolve respostas pré-configuradas
        //O que estamos dizendo ao Mockito é essencialmente: “quando o método searchByZipCode, do objeto mockAddressSearchService,
        // for invocado com um argumento igual a ‘12345678’, devolva esse resultado”
        Mockito.when(mockAddressSearchService.searchByZipCode(zipCode)).thenReturn(addressResult);

        Address address = addressSearch.findBy(new ZipCode(zipCode));
        Assert.assertEquals("Rua Beira Rio", address.getStreet());
        Assert.assertEquals("São Paulo", address.getCity());
        Assert.assertEquals("SP", address.getState());
        Assert.assertEquals(new ZipCode("12345678"), address.getZipCode());
    }

}
