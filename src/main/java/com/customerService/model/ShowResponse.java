package com.customerService.model;


public class ShowResponse {
    private Long showId;
    private String showUrl;
    private String showName;

    public ShowResponse(Long showId, String showUrl, String showName) {
        this.showId = showId;
        this.showUrl = showUrl;
        this.showName = showName;
    }

    public Long getShowId() {
        return showId;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }
}
