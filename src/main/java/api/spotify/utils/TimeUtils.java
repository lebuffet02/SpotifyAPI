package api.spotify.utils;

import lombok.experimental.UtilityClass;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class TimeUtils {

    private static final String REGEX_TIME = "(dd-MM-yyyy)'T'(HH:mm:ss.SSSSSSXXX)' ['VV']'";

    public static String getZoneTimeWithClock() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        return zonedDateTime.format(DateTimeFormatter.ofPattern(REGEX_TIME));
    }
}