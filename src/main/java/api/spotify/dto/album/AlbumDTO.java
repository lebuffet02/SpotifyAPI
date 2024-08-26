package api.spotify.dto.album;

import api.spotify.dto.artist.ArtistDTO;
import api.spotify.dto.ExternalUrlsDTO;
import api.spotify.dto.ImageDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AlbumDTO {
    private String albumType;
    private int totalTracks;
    private List<String> availableMarkets;
    private ExternalUrlsDTO externalUrls;
    private String href;
    private String id;
    private List<ImageDTO> images;
    private String name;
    private String releaseDate;
    private String releaseDatePrecision;
    private String type;
    private String uri;
    private List<ArtistDTO> artists;
}