package com.zxq.shiyansan;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by zhuxinquan on 16-10-11.
 */
public class InetAddressDemo {
    public static void main (String [] args) throws UnknownHostException{
        //练习一，获得本地主机信息

//		InetAddress localAddress = InetAddress.getLocalHost();
//		System.out.println("本地主机信息：" + localAddress);

        //练习二，获得指定域名主机的信息

//		String host = "www.edu.cn";
//		InetAddress address = InetAddress.getByName(host);
//		System.out.println("指定域名主机（www.edu.cn）：" + address);

        //练习三，根据指定域名获得所有信息

//		String host = "www.edu.cn";     //注意获得的所有IP地址
//		InetAddress [] addresses = InetAddress.getAllByName(host);
//		for(InetAddress address : addresses)
//			System.out.println(address);
//
//        //练习四，比较根据localhost和计算机名获得信息的不同
//        String host = "zhuxinquan-Lenovo";    //更改localhost为你现在所使用计算机名，查看不同
//        InetAddress ia = null;
//        try {
//            ia = InetAddress.getByName (host);
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        System.out.println ("Canonical Host Name = " + ia.getCanonicalHostName ());
//        System.out.println ("Host Address = " + ia.getHostAddress ());
//        System.out.println ("Host Name = " + ia.getHostName ());
//        System.out.println ("Is Loopback Address = " + ia.isLoopbackAddress ());
        //练习五，获得本地主机所有IP地址
//
// 		Enumeration<NetworkInterface> netInterfaces = null;
// 		try {
//     		netInterfaces = NetworkInterface.getNetworkInterfaces();
//     		while (netInterfaces.hasMoreElements()) {
//         		NetworkInterface ni = netInterfaces.nextElement();
//         		System.out.println("DisplayName:" + ni.getDisplayName());
//         		System.out.println("Name:" + ni.getName());
//         		Enumeration<InetAddress> ips = ni.getInetAddresses();
//         		while (ips.hasMoreElements()) {
//             		System.out.println("IP:" + ips.nextElement().getHostAddress());
//         		}
//     		}
// 		} catch (Exception e) {
//     		e.printStackTrace();
// 		}

        //练习六，根据IP地址构造InetAddress

//		byte [] ip = new byte[] { (byte) 202, (byte) 117, (byte)128 , 7};  //可以更改数值超过255
//		InetAddress address1 = InetAddress.getByAddress(ip);
//		InetAddress address2 = InetAddress.getByName("www.xupt.edu.cn");
//		System.out.println(address1);
//		System.out.println(address2.getHostAddress());
//		System.out.println(address2.getHostName());
//		System.out.println(address2.getCanonicalHostName());

		String host = "www.myhost.com";
		InetAddress address = InetAddress.getByName(host);
		System.out.println(address);
    }
}

