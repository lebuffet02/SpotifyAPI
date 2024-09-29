package api.spotify.service;

import api.spotify.client.SpotifyClient;
import api.spotify.dto.album.AlbumAvailableMarketsDTO;
import api.spotify.dto.album.AlbumDTO;
import api.spotify.dto.album.AlbumResponseDTO;
import api.spotify.exception.AuthException;
import api.spotify.exception.SpotifyException;
import api.spotify.mapper.AlbumsMapper;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumsService {

    @Autowired
    SpotifyClient client;
    @Autowired
    AlbumsMapper albumsMapper;

    public AlbumResponseDTO newReleasesService(String auth, int limit, int offset) {
        try {
            return client.getAlbumsNewReleases(auth, limit, offset);
        } catch (RuntimeException | Error e) {
            throw e instanceof FeignException.Forbidden || e instanceof FeignException.Unauthorized ?
                    new AuthException(e.getMessage()) : new SpotifyException("Spotify API error ".concat(e.getMessage()));
        }
    }

    public List<String> allNewReleasesAvailablesMarketsService(String auth, int limit, int offset) {
        try {
            return Optional.ofNullable(client.getAlbumsNewReleases(auth, limit, offset))
                    .map(AlbumResponseDTO::getAlbums)
                    .map(AlbumDTO::getItems)
                    .orElse(new ArrayList<>())
                    .stream()
                    .flatMap(a -> albumsMapper.AlbumInfoDTOToString(a).stream())
                    .distinct()
                    .sorted().collect(Collectors.toList());
        } catch (RuntimeException | Error e) {
            throw new SpotifyException("Spotify API error ".concat(e.getMessage()));
        }
    }

    public List<AlbumAvailableMarketsDTO> newReleasesAvailablesByCountries(String auth, int limit, int offset) {
        try {
            return Optional.ofNullable(client.getAlbumsNewReleases(auth, limit, offset))
                    .map(AlbumResponseDTO::getAlbums)
                    .map(AlbumDTO::getItems).orElse(Collections.emptyList())
                    .stream().map(a -> albumsMapper.AlbumToAlbumAvailableMarketsDTO(a)).collect(Collectors.toList());
        } catch (RuntimeException | Error e) {
            throw new SpotifyException("Spotify API error ".concat(e.getMessage()));
        }
    }
}