package api.spotify.client;

import api.spotify.config.OpenFeignConfig;
import api.spotify.dto.album.AlbumResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${spring.application.name}", url = "${spotify.endpoint.albums.new-releases}", configuration = OpenFeignConfig.class)
public interface SpotifyClient {

    @GetMapping
    AlbumResponseDTO getAlbumsNewReleases(
            @RequestHeader("Authorization") String auth,
            @RequestParam(value = "limit") int limit,
            @RequestParam(value = "offset") int offset);
}