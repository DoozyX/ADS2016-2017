package labs.lab8.p1;

import java.util.Scanner;

/**
 Black Friday Problem 1
 There is a Black Friday event in a local store with discounts up to 80%. The store were expecting a lot of buyers, so they decided to develop an ordering algorithm for entering and leaving the store, so that there would be no problems. The buyers enter the store according to the time of arrival. You are supposed to find the maximum number of buyers that can be present at the same time in the store. The store is open til 23:59. Use a heap structure (priority queue) to solve this problem.

 In the first line of the input you are given the number of buyers N. In each of the following lines you are given the time of arrival for the i-th buyer and the minutes that he plan to spend in the store.

 On the output print a single integer representing the maximum number of buyers present at the store, at the same time.

 Sample input
 7
 18:46 287
 22:39 48
 16:21 146
 23:43 140
 21:47 279
 23:49 25
 20:02 230

 Sample output
 4
 */

/*
public class BlackFriday {
    public static void main(String[] args) throws IOException {
        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>(N, String::compareTo);
        pq.

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = st.nextToken();
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                // this node is the root
                tree.makeRootNode(nodes[index]);
            }
        }

        br.close();
    }
}

16:21 146
18:46 287
20:02 230
21:47 279
22:39 48
23:43 140
23:49 25
*/

class Time{
    protected int timein;
    protected int timeout;

    public Time(int timein, int timeout) {
        this.timein = timein;
        this.timeout = timeout;
    }
    @Override
    public String toString(){
        return this.timeout + "";
    }
}
class HeapTree{
    private Time[] elements;

    public HeapTree(int n){
        elements = new Time[n];
    }
    public int left(int i){
        return 2*i+1;
    }
    public int right(int i){
        return 2*i+2;
    }
    public void swap(int i,int j){
        Time temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
    public void setElement(int i,Time element){
        elements[i] = element;
    }
    public void adjust(int i,int n){
        while(i < n){
            int left = this.left(i);
            int right = this.right(i);
            int largest = i;
            if(left < n&&elements[left].timeout < elements[largest].timeout)
                largest = left;
            if(right < n && elements[right].timeout < elements[largest].timeout)
                largest = right;
            if(largest == i)
                break;
            swap(i,largest);
            i = largest;
        }
    }
    public void makeHeap(){
        for(int i = elements.length/2-1; i >= 0; i--)
            adjust(i,elements.length);
    }
    public void print(){
        for(int i=0;i<elements.length;i++)
            System.out.println(elements[i]);
    }
    public int max(){
        int br = 1;
        int n = elements.length;
        int temp = elements[0].timeout;
        for(int i=1;i<n;i++)
            if(temp > elements[i].timein)
                br++;
        return br;
    }
    public void rotate(){
        int n = elements.length;
        Time[] temp = new Time[n-1];
        for(int i=1;i<n;i++)
            temp[i-1] = elements[i];
        elements = temp;
    }
    public int remove(){
        int max = 0;
        while( elements.length / 2 > 0){
            max = Math.max(max, max());
            rotate();
            this.makeHeap();
        }
        return max;
    }

}
public class BlackFriday {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String time;
        int duration,arrival,departure;
        HeapTree t = new HeapTree(n);

        for (int i=0;i<n;i++) {
            time = input.next();
            duration = input.nextInt();
            String[] parts = time.split(":");
            arrival = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            departure = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]) + duration;

            if (departure > 1439) {
                departure = 1439;
            }

            t.setElement(i, new Time(arrival,departure));
        }
        t.makeHeap();
        System.out.println(t.remove());
    }
}