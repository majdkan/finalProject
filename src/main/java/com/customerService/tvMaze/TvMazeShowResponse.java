package com.customerService.tvMaze;

import com.customerService.model.ShowResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TvMazeShowResponse {
    @JsonProperty("id")
    private Long tvShowId;
    @JsonProperty("url")
    private String tvShowUrl;
    @JsonProperty("name")
    private String tvShowName;

    public TvMazeShowResponse(Long tvShowId, String tvShowUrl, String tvShowName) {
        this.tvShowId = tvShowId;
        this.tvShowUrl = tvShowUrl;
        this.tvShowName = tvShowName;
    }

    public Long getTvShowId() {
        return tvShowId;
    }

    public String getTvShowUrl() {
        return tvShowUrl;
    }

    public String getTvShowName() {
        return tvShowName;
    }

    public void setTvShowId(Long tvShowId) {
        this.tvShowId = tvShowId;
    }

    public void setTvShowName(String tvShowName) {
        this.tvShowName = tvShowName;
    }

    public void setTvShowUrl(String tvShowUrl) {
        this.tvShowUrl = tvShowUrl;
    }

    public ShowResponse toShowResponse(){
        return new ShowResponse(
                this.tvShowId,
                this.tvShowUrl,
                this.tvShowName
        );
    }
}
