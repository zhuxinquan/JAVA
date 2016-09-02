package url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by zhuxinquan on 16-8-17.
 */
public class URLDemo2 {
    public static void main(String[] args) {
        String url = "http://www.baidu.com?name=朱新全";
        try {
            System.out.println(url = URLEncoder.encode(url, "UTF-8"));
            System.out.println(URLDecoder.decode(url, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
