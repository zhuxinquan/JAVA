package com.zxq.shiyanliu_qi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.channels.SocketChannel;


public class Handler implements Runnable{
	private SocketChannel socketChannel;
	public Handler(SocketChannel socketChannel) {
		this.socketChannel=socketChannel;
	}
	
	@Override
	public void run() {
//		System.out.println("start");
		handel(socketChannel);
	}

	public void handel(SocketChannel socketChannel) {
		try {
			Socket socket=socketChannel.socket();//获得与socketChannel关联的Socket对象。
			System.out.println("接收到客户的连接，来自"+socket.getInetAddress()+":"+socket.getPort());
			
			
			BufferedReader br=getReader(socket);
			
			PrintWriter pw=getWriter(socket);
			String msg=null;
			while((msg=br.readLine())!=null){
//				System.out.println(msg);
				
				pw.println(echo(msg));

				pw.flush();

//				System.out.println("回复完成");
				
				if(msg.equals("bye")){
					break;
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(socketChannel!=null){
					socketChannel.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	private String echo(String msg) {
		// TODO Auto-generated method stub
		return "echo:"+msg;
	}

	private PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream socketOut=socket.getOutputStream();
		
		return new PrintWriter(socketOut,true);
	}

	private BufferedReader getReader(Socket socket) throws IOException {
		InputStream socketIn=socket.getInputStream();
		
		
		return new BufferedReader(new InputStreamReader(socketIn));
	}
}
