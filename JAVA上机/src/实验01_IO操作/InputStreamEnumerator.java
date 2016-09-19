package 实验01_IO操作;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by zhuxinquan on 16-9-18.
 */
public class InputStreamEnumerator implements Enumeration {

    private Enumeration files;

    public InputStreamEnumerator(Vector files){
        this.files = files.elements();
    }

    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    public Object nextElement() {
        try {
            return new FileInputStream(files.nextElement().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
