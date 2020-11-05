import java.util.*;

/**
 * Generic version of the MyQueue class.
 * @param <T> the type of the value being queued
 */

class MyQueue <T> {
	private T[] queue;	// array for queue elements
	private int front, // one counterclockwise from front
	            rear, 	// array position of rear element
		capacity;	// capacity of queue array

	/**
	 * Create an empty queue whose initial capacity is cap
	 */
	@SuppressWarnings("unchecked")
	MyQueue(int cap) {
		capacity = cap;
		queue = (T []) new Object [capacity];
		front = rear = 0;
	}

	/**
	 * If number of elements in the queue is 0, return true else return false
	 */
	boolean IsEmpty() {
// 원소의 수가 0이면 true를 리턴, 아니면 false를 리턴
// NEED TO IMPLEMENT
	if (front==rear)
        	return true;
    	return false;
   }

	/**
	 * Add x at rear of queue
	 */
	void Push (T x) throws Exception {
// Queue의 rear에 원소를 추가
            if ((rear+1)% capacity==front)
            {
		            //if queue full, throw the following message
		throw new Exception ("Queue is Full");
            }
            else{
		rear=(rear+1)%capacity;
        	queue[rear]=x;
	}
}

	/**
	 * Delete front element from queue
	 */
	T Pop() throws Exception {
        if (IsEmpty())
        {
		// if queue is empty, throw the following message
			throw new Exception("Queue is empty. Cannot delete.");
    }
// Queue의 front에서 원소를 제거하고, 제거된 원소를 return
      	else{
				front=(front+1)%capacity;
			}
        return queue[front];
	}


	public String toString() {
		String a = new String();
    // Queue의 내용을 front 부터 rear까지 차례로 표시. 이와 더불어 front 변
  //  수와 rear 변수의 값도 출력. 실제로는 출력된 내용을 String에 담아서 이를 return함.
		a ="MyQueue : ";
    		for(int i=(front+1)%capacity; i!=(rear+1)%capacity; i=(i+1)%capacity){
			a+=(queue[i]+" ");
		}
		a+=("\n"+"rear=" +rear+","+" " +"front="+front);

// NEED TO IMPLEMENT


		return a;
	}
};

