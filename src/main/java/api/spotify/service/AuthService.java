package api.spotify.service;

import api.spotify.client.SpotifyAuthClient;
import api.spotify.dto.auth.AuthSpotifyDTO;
import api.spotify.exception.AuthException;
import api.spotify.exception.SpotifyException;
import api.spotify.form.AuthSpotifyForm;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    SpotifyAuthClient client;

    public AuthSpotifyDTO tokenService(AuthSpotifyForm auth) {
        try {
            return client.getDadosSpotify(auth.clientId(), auth.grantType(), auth.clientSecret());
        } catch (RuntimeException | Error e) {
            throw e instanceof FeignException.BadRequest ? new AuthException(e) :
                    new SpotifyException("Error when validating token...".concat(e.getMessage()));
        }
    }
}