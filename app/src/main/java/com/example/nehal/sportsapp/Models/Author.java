package com.example.nehal.sportsapp.Models;

import java.util.List;

/**
 * Created by nehal on 29/10/17.
 */

public class Author {
    public String value;
    public String matchLevel;
    public List<Object> matchedWords = null;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMatchLevel() {
        return matchLevel;
    }

    public void setMatchLevel(String matchLevel) {
        this.matchLevel = matchLevel;
    }

    public List<Object> getMatchedWords() {
        return matchedWords;
    }

    public void setMatchedWords(List<Object> matchedWords) {
        this.matchedWords = matchedWords;
    }
}
