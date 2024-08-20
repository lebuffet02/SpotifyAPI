package api.spotify.client;

import api.spotify.config.OpenFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${spring.application.name}", url = "${spotify.endpoint.albums.new-releases}", configuration = OpenFeignConfig.class)
public interface SpotifyClient {
}
