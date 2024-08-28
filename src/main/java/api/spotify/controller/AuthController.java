package api.spotify.controller;

import api.spotify.dto.auth.AuthSpotifyDTO;
import api.spotify.form.AuthSpotifyForm;
import api.spotify.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/token")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping
    public ResponseEntity<AuthSpotifyDTO> token(@RequestBody AuthSpotifyForm authSpotifyForm) {
        return ResponseEntity.ok(service.tokenService(authSpotifyForm));
    }
}