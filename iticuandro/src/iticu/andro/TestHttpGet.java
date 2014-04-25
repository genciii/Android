package iticu.andro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestHttpGet {

    //private static final String targetUri = "http://www.iticu.edu.tr";
    private static final String targetUri = "http://www.iticu.edu.tr/tr/duyuru/liste/";

    //private static final String targetUri = "http://www.iticu.edu.tr/Pages/Duyuru-Detay.aspx/?AnnouncementID=525";

    public String getInternetData() throws Exception {
        BufferedReader in = null;
        String data = null;
        boolean isNextLineAnnouncement = false;
        try {
            HttpClient client = new DefaultHttpClient();
            URI website = new URI(targetUri);
            HttpGet request = new HttpGet();
            request.setURI(website);
            HttpResponse response = client.execute(request);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String l = "";
            String nl = System.getProperty("line.separator");

            while ((l = in.readLine()) != null) {
                if (isNextLineAnnouncement) {
                    String announcement = l.replaceAll("</a>", "");
                    //System.out.println("___DUYURU___: " + announcement);
                    sb.append(announcement + nl);
                    isNextLineAnnouncement = false;
                } else {
                    String sss = "  <a href=' /tr/Duyuru/Detay/Kategori/id/0/id/";
                    if (l.lastIndexOf(sss) > 0) {
                        isNextLineAnnouncement = true;
                    } else {
                        isNextLineAnnouncement = false;
                    }
                }
            }

            in.close();
            data = sb.toString();
            return data;
        } finally {
            if (in != null) {
                try {
                    in.close();
                    return data;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}