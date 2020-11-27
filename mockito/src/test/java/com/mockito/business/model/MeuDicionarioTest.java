package com.mockito.business.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MeuDicionarioTest {

    @Mock
    private MeuDicionario mockMeuDicionario;

    @Test(expected = IllegalArgumentException.class)
    public void addException(){

        doThrow(IllegalArgumentException.class)
                .when(mockMeuDicionario)
                .add(anyString(), anyString());


        mockMeuDicionario.add("word", "meaning");
    }

    @Test(expected = Exception.class)
    public void getMeaningTestException(){

        when(mockMeuDicionario.getMeaning(anyString())).thenThrow(Exception.class);

        mockMeuDicionario.getMeaning(anyString());

    }

}
