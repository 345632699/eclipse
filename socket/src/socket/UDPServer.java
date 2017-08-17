package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.DatabaseMetaData;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(8888);
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		socket.receive(packet);
		String info = new String(data,0,packet.getLength());
		System.out.println("我是服务器，客户端说："+info);
	}
}
