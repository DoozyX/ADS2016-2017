package exams.first.exercise.p9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class card_trick {
    public static int count(int N){
        // Vasiot kod tuka

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int shuffleCount = 0;

        for(int i = 0; i < 51; i ++){
            queue.add(i);
        }
        while(queue.element() != N-1){


            for(int i = 0; i < 7; i++){
                stack.push(queue.remove());
            }
            while(!stack.isEmpty()){
                queue.add(stack.pop());
                queue.add(queue.remove());
            }
            shuffleCount ++;
        }
        return shuffleCount;
    }







    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }

}