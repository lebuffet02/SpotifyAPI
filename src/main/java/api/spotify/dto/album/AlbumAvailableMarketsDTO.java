package api.spotify.dto.album;

import api.spotify.dto.artist.ArtistDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class AlbumAvailableMarketsDTO {

    private String albumName;
    private List<ArtistDTO> name;
    private List<String> availableMarkets;
}
