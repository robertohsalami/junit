package com.mockito.business.model;

import java.util.HashMap;
import java.util.Map;

public class MeuDicionario {

    private Map<String, String> wordMap = new HashMap<>();

    public void add(String word, String meaning) {
        wordMap.put(word, meaning);
    }

    public String getMeaning(String word) {
        return wordMap.get(word);
    }

}
