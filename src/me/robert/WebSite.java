package me.robert;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebSite {
    private String key = "server_api_key";

    public String getContent(String pname) throws IOException {
        URL url = new URL("https://minecraft-mp.com/api/?object=votes&element=claim&key=" + this.key + "&username=" + pname);
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while (sc.hasNext())
            sb.append(sc.next());
        String result = sb.toString();
        return result;
    }

}
