package url;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by zhuxinquan on 16-8-17.
 */
public class URLDemo {
    public static void main(String[] args) {
        try {
            //根据网址构造URL对象
            URL url = new URL("http://pic1.5442.com/2013/0713/05/17.jpg");
            System.out.println("Host : " + url.getHost());
            System.out.println("Path : " + url.getPath());
            System.out.println("Protocol : " + url.getProtocol());
            System.out.println("Port : " + url.getPort());

            URLConnection urlConnection = url.openConnection();
            urlConnection.getInputStream();
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
