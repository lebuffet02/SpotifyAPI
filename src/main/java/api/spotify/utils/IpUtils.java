package api.spotify.utils;

import lombok.experimental.UtilityClass;
import java.net.InetAddress;
import java.net.UnknownHostException;

@UtilityClass
public class IpUtils {

    public static String getAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            return "Can't possible generate ip address.";
        }
    }
}