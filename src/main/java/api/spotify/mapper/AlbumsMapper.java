package api.spotify.mapper;

import api.spotify.dto.album.AlbumAvailableMarketsDTO;
import api.spotify.dto.album.AlbumInfoDTO;
import api.spotify.dto.artist.ArtistInfoDTO;
import api.spotify.dto.artist.ArtistDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlbumsMapper {

    public List<String> AlbumInfoDTOToString(AlbumInfoDTO albumInfoDTO) {
            return new ArrayList<>(albumInfoDTO.getAvailableMarkets());
    }

    public AlbumAvailableMarketsDTO AlbumToAlbumAvailableMarketsDTO(AlbumInfoDTO albumInfoDTO) {
        return AlbumAvailableMarketsDTO.builder()
                .albumName(albumInfoDTO.getName())
                .name(getArtistDTO(albumInfoDTO.getArtists()))
                .availableMarkets(!CollectionUtils.isEmpty(albumInfoDTO.getAvailableMarkets()) ?
                        albumInfoDTO.getAvailableMarkets()
                                .stream()
                                .distinct()
                                .sorted()
                                .collect(Collectors.toList()) :
                        new ArrayList<>()).build();
    }

    private List<ArtistDTO> getArtistDTO(List<ArtistInfoDTO> artistInfoDTO) {
        return artistInfoDTO.stream()
                .map(this::toMapperArtistInfoDTO).collect(Collectors.toList());
    }

    private ArtistDTO toMapperArtistInfoDTO(ArtistInfoDTO artistInfoDTO) {
        return ArtistDTO.builder()
                .name(artistInfoDTO.getName() != null ? artistInfoDTO.getName().toUpperCase() : null)
                .type(artistInfoDTO.getType() != null ? artistInfoDTO.getType().toUpperCase() : null)
                .build();
    }
}