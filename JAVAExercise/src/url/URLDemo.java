package url;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
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

            //通过URL打开链接
            URLConnection urlConnection = url.openConnection();
            BufferedInputStream bis = new BufferedInputStream(urlConnection.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(url.getPath().substring(url.getPath().lastIndexOf("/") + 1)));

            byte[] bytes = new byte[1024 * 10];
            int len = -1;
            while((len = bis.read(bytes)) != -1){
                bos.write(bytes, 0, len);
                bos.flush();
            }
            bos.close();
            bis.close();
            System.out.println("success");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
