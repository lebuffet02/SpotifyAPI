package api.spotify.dto.artist;

import api.spotify.dto.ExternalUrlsDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ArtistInfoDTO {

    private ExternalUrlsDTO externalUrls;
    private String href;
    private String id;
    private String name;
    private String type;
    private String uri;

}
