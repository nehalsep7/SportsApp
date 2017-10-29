package com.example.nehal.sportsapp.Models;

/**
 * Created by nehal on 29/10/17.
 */

public class HighlightResult {

    public Title title;
    public Url url;
    public Author author;
    public StoryText storyText;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public StoryText getStoryText() {
        return storyText;
    }

    public void setStoryText(StoryText storyText) {
        this.storyText = storyText;
    }
}
