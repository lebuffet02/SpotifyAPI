package api.spotify.service;

import api.spotify.client.SpotifyClient;
import api.spotify.dto.AlbumAvailableMarketsDTO;
import api.spotify.dto.album.Album;
import api.spotify.dto.album.AlbumResponseDTO;
import api.spotify.dto.artist.ArtistInfoDTO;
import api.spotify.exception.SpotifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumsService {

    @Autowired
    SpotifyClient client;

    public AlbumResponseDTO newReleasesService(String auth, int limit, int offset) {
        try {
            return client.getAlbumsNewReleases(auth, limit, offset);
        } catch (RuntimeException | Error e) {
            throw new SpotifyException("Spotify API error...");
        }
    }

    public List<String> allNewReleasesAvailablesMarketsService(String auth, int limit, int offset) {
        try {
            List<String> availableMarkets = new ArrayList<>();
            AlbumResponseDTO albumResponseDTO = client.getAlbumsNewReleases(auth, limit, offset);
            if (!CollectionUtils.isEmpty(albumResponseDTO.getAlbums().getItems())) {
                albumResponseDTO.getAlbums().getItems()
                        .stream().flatMap(a -> a.getAvailableMarkets().stream())
                        .distinct().sorted().forEach(availableMarkets::add);
            }
            return availableMarkets;
        } catch (RuntimeException | Error e) {
            throw new SpotifyException("Spotify API error...");
        }
    }

    public List<AlbumAvailableMarketsDTO> newReleasesAvailablesByCountries(String auth, int limit, int offset) {
        try {
            return Optional.ofNullable(client.getAlbumsNewReleases(auth, limit, offset))
                    .map(AlbumResponseDTO::getAlbums)
                    .map(Album::getItems)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(album -> new AlbumAvailableMarketsDTO(
                            album.getName(),
                            album.getArtists()
                                    .stream()
                                    .map(artist -> new ArtistInfoDTO(artist.getName().toUpperCase(),
                                            artist.getType().toUpperCase()))
                                    .collect(Collectors.toList()),
                            album.getAvailableMarkets()
                                    .stream()
                                    .distinct()
                                    .sorted()
                                    .collect(Collectors.toList())))
                    .collect(Collectors.toList());
        } catch (RuntimeException | Error e) {
            throw e instanceof NullPointerException ? new RuntimeException((e).getMessage()) :
                    new SpotifyException("Spotify API error...");
        }
    }
}