package day01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Program {
	static private final byte message[] = { 0x39, 111, 109, 101, 32, 98, 121, 116, 101, 115, 46 };

	public static void main(String[] args) throws Exception {

		FileOutputStream fileOutputStream = new FileOutputStream("F:\\test.txt");
		FileChannel fileChannel = fileOutputStream.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.put(message[0]);
		buffer.flip();  
		fileChannel.write(buffer);

		FileInputStream fileInputStream = new FileInputStream("F:\\test.txt");
		// 获取通道
		FileChannel fChannel = fileInputStream.getChannel();
		// 创建缓冲区
		ByteBuffer buffer2 = ByteBuffer.allocate(1024);
		// 读取数据到缓冲区
		fChannel.read(buffer2);
		fileInputStream.close();
		fileOutputStream.close();
		buffer.flip();
			
		while (buffer.remaining() > 0) {
			byte b = buffer.get();
			System.out.print(((char) b));
		}

	}

}
