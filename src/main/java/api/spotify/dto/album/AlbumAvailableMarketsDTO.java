package api.spotify.dto.album;

import api.spotify.dto.artist.ArtistInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AlbumAvailableMarketsDTO {

    private String albumName;
    private List<ArtistInfoDTO> name;
    private List<String> availableMarkets;
}
