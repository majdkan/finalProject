package com.customerService.lastFm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastFmTopArtistsResponse {
    @JsonProperty("toptracks")
    private LastFmTopTracks lastFmTopTracks;

    public LastFmTopArtistsResponse(){}

    public LastFmTopArtistsResponse(LastFmTopTracks lastFmTopTracks) {
        this.lastFmTopTracks = lastFmTopTracks;
    }

    public LastFmTopTracks getLastFmTopTracks() {
        return lastFmTopTracks;
    }

    public void setLastFmTopTracks(LastFmTopTracks lastFmTopTracks) {
        this.lastFmTopTracks = lastFmTopTracks;
    }
}
