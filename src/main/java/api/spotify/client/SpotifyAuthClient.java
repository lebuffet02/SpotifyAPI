package api.spotify.client;

import api.spotify.config.OpenFeignConfig;
import api.spotify.dto.AuthSpotifyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${spring.application.auth}", url = "${spotify.endpoint.auth}", configuration = OpenFeignConfig.class)
public interface SpotifyAuthClient {

    @PostMapping
    AuthSpotifyDTO getDadosSpotify(
            @RequestParam("client_id") String clientId,
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_secret") String clientSecret);
}