package me.robert;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebSite {
    private String key = "o5H2BB6OwNlOEb5MpH1j05X743KZnDORhkO";

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
