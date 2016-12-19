package com.zxq.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.*;

/**
 * Created by zhuxinquan on 16-12-18.
 */
public class Client {
    public static void main(String [] argv){
        Socket s = null;
        ObjectOutputStream os = null;
        try{
            s = new Socket("localhost", 8888);
            os = new ObjectOutputStream(s.getOutputStream());
            KeyPairGenerator kgen = KeyPairGenerator.getInstance("DSA");
            kgen.initialize(512);
            KeyPair kpair = kgen.generateKeyPair();
            Signature sig = Signature.getInstance("SHA/DSA");
            PublicKey pub = kpair.getPublic();
            PrivateKey priv = kpair.getPrivate();
            sig.initSign(priv);
            FileInputStream fis = new FileInputStream("StuDB.dat");
            byte [] arr = new byte[fis.available()];
            fis.read(arr);
            sig.update(arr);
            SignedObj obj = new SignedObj(arr, sig.sign(), pub);
            os.writeObject(obj);
            //将签名内容保存在文件中
			/*FileOutputStream fos = new FileOutputStream("SigDB.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.flush();
			oos.close();
			*/
            os.flush();
            os.close();
            fis.close();
            s.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
