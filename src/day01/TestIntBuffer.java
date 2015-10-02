package day01;

import java.nio.IntBuffer;

public class TestIntBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntBuffer buffer = IntBuffer.allocate(10);
		for (int i = 0; i < buffer.capacity();++i){
			int j = 2 * (i +1);
			buffer.put(j);
		}
		buffer.flip();
		while(buffer.hasRemaining()){
			int j = buffer.get();
			System.out.print(j + " ");
		}
	}

}
