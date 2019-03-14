import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



class BlockingBuffer implements Buffer {
	private final ArrayBlockingQueue<Integer> buffer;

	public BlockingBuffer() {
		buffer = new ArrayBlockingQueue<Integer>(1);
	}

	@Override
	public void blockingPut(int value) throws InterruptedException {
		// TODO Auto-generated method stub
		buffer.put(value);
		System.out.printf("%s%2d\t%s%d%n", "Producer wirtes", value, 
				"Buffer cells occupied: ", buffer.size());
	}

	@Override
	public int blockingGet() throws InterruptedException {
		// TODO Auto-generated method stub
		int readValue = buffer.take();
		System.out.printf("%s %2d\t%s%d%n","Consumer reads ", readValue, 
				"Buffer cells occupied: ", buffer.size());
		return readValue;
	}
}


public class BlockingBufferTest{
	public static void main(String[] args) throws InterruptedException{
		
		ExecutorService es = Executors.newCachedThreadPool();
		Buffer sharedLocation = new BlockingBuffer();
		
	}
}