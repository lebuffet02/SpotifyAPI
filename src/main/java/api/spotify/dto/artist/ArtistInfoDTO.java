package api.spotify.dto.artist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArtistInfoDTO {

    private String name;
    private String type;
}
