package com.customerService.lastFm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "lastFmService",
        url = "${externalApi.lastFM.url}"
)
public interface LastFmService {

    @GetMapping("/")
    LastFmTopArtistsResponse getTopTracksByArtistName(@RequestParam String method,
                                  @RequestParam String artist,
                                  @RequestParam(value = "api_key") String apiKey,
                                  @RequestParam String format
    );
}
