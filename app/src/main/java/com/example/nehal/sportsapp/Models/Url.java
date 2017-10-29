package com.example.nehal.sportsapp.Models;

import java.util.List;

/**
 * Created by nehal on 29/10/17.
 */

public class Url {

    public String value;
    public String matchLevel;
    public boolean fullyHighlighted;
    public List<String> matchedWords = null;

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

    public boolean isFullyHighlighted() {
        return fullyHighlighted;
    }

    public void setFullyHighlighted(boolean fullyHighlighted) {
        this.fullyHighlighted = fullyHighlighted;
    }

    public List<String> getMatchedWords() {
        return matchedWords;
    }

    public void setMatchedWords(List<String> matchedWords) {
        this.matchedWords = matchedWords;
    }
}
