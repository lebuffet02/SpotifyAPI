package api.spotify.controller;

import api.spotify.dto.album.AlbumResponseDTO;
import api.spotify.service.AlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumsController {

    @Autowired
    AlbumsService service;

    @GetMapping("/releases")
    public ResponseEntity<AlbumResponseDTO> newReleasesController(
            @RequestHeader("Authorization") String auth,
            @RequestParam(value = "limit", required = false, defaultValue = "20") int limit,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset) {
        return ResponseEntity.ok(service.newReleasesService(auth, limit, offset));
    }

    @GetMapping("/releases/availables")
    public ResponseEntity<?> allNewReleasesAvailablesMarketsController(
            @RequestHeader("Authorization") String auth,
            @RequestParam(value = "limit", required = false, defaultValue = "20") int limit,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset) {
        return ResponseEntity.ok(service.allNewReleasesAvailablesMarketsService(auth, limit, offset));
    }

    @GetMapping("/releases/availables/by-countries")
    public ResponseEntity<?> newReleasesAvailablesByCountriesController(
            @RequestHeader("Authorization") String auth,
            @RequestParam(value = "limit", required = false, defaultValue = "20") int limit,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset) {
        return ResponseEntity.ok(service.newReleasesAvailablesByCountries(auth, limit, offset));
    }
}