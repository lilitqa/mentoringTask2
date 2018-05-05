import java.util.*;


public class Speed {
	private List<String> list = new ArrayList<String>();
	private List<String> linkedlist = new LinkedList<String>();
	private int maxSize = 11111;
	
	/**
	 * Check add speed for ArrayList
	 */
	public void checkSpeedOfArrayList(){
		long startTime = System.nanoTime();
		long endTime;
		for(int i=0; i <= maxSize; i++){
			list.add(""+i);
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList:Speed for add is: " + (endTime -startTime));
	}
	
	/**
	 * Check add speed for LinkedList
	 */
	public void checkSpeedOfLinkedList(){
		long startTime = System.nanoTime();
		long endTime;
		for(int i=0; i <= maxSize; i++){
			linkedlist.add(""+i);
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList:Speed for add is: " + (endTime-startTime));
	}
	
	/**
	 * Check remove speed for ArrayList
	 */
	public void checkSpeedDeleteOfArrayList(){
		for(int i=0; i <= maxSize; i++){
			list.add(""+i);
		}
		long startTime = System.nanoTime();
		long endTime;
		for(int i=0; i <= maxSize; i++){
			list.remove(i);
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList:Speed for delete is: " + (endTime-startTime));
	}
	
	/**
	 * Check remove speed for LinkedList
	 */
	public void checkSpeedDeleteOfLinkedList(){
		for(int i=0; i <= maxSize; i++){
			linkedlist.add(""+i);
		}
		long startTime = System.nanoTime();
		long endTime;
		for(int i=0; i <= maxSize; i++){
			linkedlist.remove(i);
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList:Speed for delete is: " + (endTime-startTime));
	}
	
	/**
	 * Check get speed for ArrayList
	 */
	public void checkSpeedGetOfArrayList(){
		for(int i=0; i <= maxSize; i++){
			list.add(""+i);
		}
		long startTime = System.nanoTime();
		long endTime;
		for(int i=0; i <= maxSize; i++){
			list.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList:Speed for get is: " + (endTime-startTime));
	}
	
	/**
	 * Check get speed for LinkedList
	 */
	public void checkSpeedGetOfLinkedList(){
		for(int i=0; i <= maxSize; i++){
			linkedlist.add(""+i);
		}
		long startTime = System.nanoTime();
		long endTime;
		for(int i=0; i <= maxSize; i++){
			linkedlist.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList:Speed for get is: " + (endTime-startTime));
	}

}
