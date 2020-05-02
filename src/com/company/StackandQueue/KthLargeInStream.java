package com.company.StackandQueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class KthLargeInStream {
    public static void main(String[] args) {
        KthNumber kthNumber = new KthNumber(3, new int[]{0,1,2,3,7,4,5});
        System.out.println(kthNumber.getKth());
    }

    private static class KthNumber{
        private Queue<Integer> queue;
        private int k;

        KthNumber(int k,int[] arr){
            this.k = k;
            queue = new PriorityQueue<>(k);
            for(int a : arr){
                add(a);
            }
        }

        void add(int val){
            if(queue.size()<k){
                queue.offer(val);
            }else if(queue.peek()<val){
                queue.poll();
                queue.offer(val);
            }
        }
        Integer getKth(){
            return queue.peek();
        }
    }
}
