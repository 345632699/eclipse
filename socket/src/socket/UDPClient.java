package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.print.DocFlavor.STRING;
import javax.xml.crypto.Data;

import org.omg.Messaging.SyncScopeHelper;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		/**
		 * 客户端发送
		 */
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8888;
		byte[] data = "user:admin;password:admin123;".getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		
		/**
		 * 客户端接收
		 */
		byte[] response = new byte[1024];
		DatagramPacket resopnsePacket = new DatagramPacket(response, response.length);
		socket.receive(resopnsePacket);
		String responseString = new String(response, 0, resopnsePacket.getLength());
		System.out.println(responseString);
		socket.close();
	}
}
