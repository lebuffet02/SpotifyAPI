package api.spotify.controller;

import api.spotify.dto.AuthSpotifyDTO;
import api.spotify.form.AuthSpotify;
import api.spotify.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("/token")
    public ResponseEntity<AuthSpotifyDTO> token(@RequestBody AuthSpotify authSpotify) {
        return ResponseEntity.ok(service.tokenService(authSpotify));
    }
}