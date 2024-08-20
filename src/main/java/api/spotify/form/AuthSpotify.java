package api.spotify.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthSpotify(
        @JsonProperty("grant_type")
        String grantType,
        @JsonProperty("client_id")
        String clientId,
        @JsonProperty("client_secret")
        String clientSecret){}

