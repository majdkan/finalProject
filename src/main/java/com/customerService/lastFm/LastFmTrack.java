package com.customerService.lastFm;

public class LastFmTrack {
    private String name;
    private String playcount;
    private String listeners;
    private String url;

    public LastFmTrack(){}

    public LastFmTrack(String name, String playcount, String listeners, String url) {
        this.name = name;
        this.playcount = playcount;
        this.listeners = listeners;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getPlaycount() {
        return playcount;
    }

    public String getListeners() {
        return listeners;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
