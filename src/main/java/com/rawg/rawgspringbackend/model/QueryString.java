package com.rawg.rawgspringbackend.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

public class QueryString {

    private final String pageNumber;
    private final String searchString;
    private final String ordering;
    private final String dates;
    private final String page_size;
    private final String tags;

    private static final List<String> orderingParams = Arrays
            .asList("released", "added", "created", "rating", "name",
                    "-released", "-added", "-created", "-rating", "-name", "");

    public QueryString(String pageNumber, String searchString,
                       String ordering, String dates, String page_size, String tags) {
        this.pageNumber = pageNumber;
        this.searchString = searchString;
        this.ordering = ordering;
        this.dates = dates;
        this.page_size = page_size;
        this.tags = tags;

    }

    public String getQueryString() {
        String gamesURL = "https://api.rawg.io/api/games";
        String fullPath = "?page=" + pageNumber
                + "&search=" + searchString + "&ordering=" + ordering
                + "&dates=" + dates + "&page_size=" + page_size;

        if (!tags.equals("")) {
            return gamesURL
                    + fullPath + "&tags=" + tags;
        } else {
            return gamesURL
                    + fullPath;
        }
    }

}
