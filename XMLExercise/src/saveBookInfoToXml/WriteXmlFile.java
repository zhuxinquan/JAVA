package saveBookInfoToXml;

import java.beans.XMLEncoder;
import java.io.*;

/**
 * Created by zhuxinquan on 16-2-21.
 */
public class WriteXmlFile {
    Book b = null;

    public WriteXmlFile(Book b){
        this.b = b;
        try {
            OutputStream out = new FileOutputStream(b.getName() + ".xml");
            BufferedOutputStream bos = new BufferedOutputStream(out);
            XMLEncoder encoder = new XMLEncoder(bos);
            encoder.writeObject(b);
            encoder.flush();
            encoder.close();
            bos.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
