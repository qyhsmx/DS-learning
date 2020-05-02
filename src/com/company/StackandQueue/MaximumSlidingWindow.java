package com.company.StackandQueue;


import java.util.*;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class MaximumSlidingWindow {
    public static void main(String[] args) {

//        PriorityQueue<Integer> queue = new PriorityQueue<>(3, (o1, o2) -> o2-o1);
//        queue.offer(3);
//        queue.offer(8);
//        queue.offer(0);
//        System.out.println(queue.peek());
        int[] arr = {2,10,1,3,4,5,6};
        System.out.println(max_2(arr,3));
//        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 5, 3, 4));
//        System.out.println(deque.getFirst());
//        System.out.println(deque.pollFirst());


    }

    private static List<Integer> max_2(int[] arr,int k){
        if(arr.length==0)return null;
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if(i>=k && deque.getFirst()<=i-k){
                deque.removeFirst();
            }
            while (deque.size()!=0 && arr[deque.peek()]<arr[i]){
                deque.poll();
            }
            deque.offer(i);
            if(i>=k-1){
                res.add(arr[deque.peekFirst()]);
            }
        }
        return res;
    }



    private static List<Integer> max(int[] arr, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(3, (o1, o2) -> o2-o1);
        List<Integer> list = new ArrayList<>();
        int len = arr.length;
        for (int i=0;i<len;i++){
            if(i<k-1){
                add(queue,arr[i]);
            }
            else {
                list.add(add(queue,arr[i]));
            }
        }


        return list;
    }

    private static Integer add(Queue<Integer> queue, int val){
        if(queue.size()<3){
            queue.offer(val);
        }
        else {
            if(queue.peek() < val){
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }
}
