package com.customerService.controller;

import com.customerService.lastFm.LastFmService;
import com.customerService.lastFm.LastFmTopArtistsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArtistController {

    private static String LAST_FM_API_KEY = "003d3380281e5c0cf60e37451eadaeb8";
    private static String LAST_FM_METHOD = "artist.gettoptracks";
    private static String LAST_FM_FORMAT = "json";

    @Autowired
    LastFmService lastFmService;

    @GetMapping(value = "/artist/{artistName}")
    LastFmTopArtistsResponse getTopTracksByArtistName(@PathVariable String artistName){
        return lastFmService.getTopTracksByArtistName(LAST_FM_METHOD, artistName, LAST_FM_API_KEY, LAST_FM_FORMAT);
    }
}
