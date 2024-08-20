package api.spotify.service;

import api.spotify.client.SpotifyAuthClient;
import api.spotify.dto.AuthSpotifyDTO;
import api.spotify.exception.AuthException;
import api.spotify.form.AuthSpotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    SpotifyAuthClient client;

    public AuthSpotifyDTO tokenService(AuthSpotify auth) {
        try {
            return client.getDadosSpotify(auth.clientId(), auth.grantType(), auth.clientSecret());
        } catch (RuntimeException ex) {
            throw new AuthException("Error when validating token");
        }
    }
}