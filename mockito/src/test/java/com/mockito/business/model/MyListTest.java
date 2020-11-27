package com.mockito.business.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MyListTest {

    @Mock
    private MyList myList;

    @Test
    public void addMockVoid(){
        doNothing().when(myList).add(anyInt(), anyString());

        myList.add(0,"");
        myList.add(0,"");

        verify(myList, times(2)).add(0,"");
    }

    @Test(expected = Exception.class)
    public void givenNull_AddThrows() {
       doThrow().when(myList).add(isA(Integer.class), isNull());

        myList.add(0, null);
    }

}
