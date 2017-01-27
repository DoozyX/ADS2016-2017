package labs.lab6.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 Stating routing Problem 2 (0 / 0)
 You should simulate routing by using a hash table. Every router is one bucket in the hash table and it receives the input packets only through one interface.
 Since the router performs the routing of the packet by using the static routes it knows, when it receives a packet it should tell if it is possible to route the packet in the network (postoi or nepostoi).
 It is important that all addresses have network mask /24 which means that the last 8 bits are allocated for addressing.
 We assume that all addresses are busy and the packet can be transferred to any device in a network if the network exists in the routing table.
 For example, if the address 10.10.10.0 can be found in the routing table, it means that the router can transfer the packet to all devices in that network (10.10.10.1- 10.10.10.254).

 The number of the routers is given in the first input line. In the next lines for each router the IP address of the interface and IP addresses of the networks to which it has static routes are given.
 Then the number of routing attempts are entered. In the next lines for each attempt an input interface and device IP address are given. The router should answer if it knows the address or not.

 Sample input
 2
 23.3.3.3
 10.10.10.0
 192.168.1.1
 20.2.2.0
 2
 192.168.1.1
 20.2.2.1
 13.13.3.3
 192.2.2.2

 Sample output
 postoi
 ne postoi
 */

public class RoutingHashJava {
    public static void main (String[] args) throws IOException {

        CBHT<String,String[]> tabela;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        tabela=new CBHT<>(2*N);

        for(int i = 1; i<=N; i++) {
            String interfejs=br.readLine();
            String routing_table=br.readLine();
            String[] ruti = routing_table.split(",");
            tabela.insert(interfejs, ruti);
        }


        int M = Integer.parseInt(br.readLine());
        for (int i=1;i<=M;i++) {
            String ip_adresa_interfejs=br.readLine();
            String mreza=br.readLine();
            int count = 0;
            StringBuilder sb= new StringBuilder();
            for (char c : mreza.toCharArray()) {
                if (count == 3) {
                    sb.append('0');
                    break;
                }
                if (c == '.') {
                    ++count;
                }
                sb.append(c);
            }
            String network = sb.toString();
            StringBuilder sb1= new StringBuilder();
            count = 0;
            for (char c : mreza.toCharArray()) {
                if (count == 3) {
                    sb1.append('1');
                    break;
                }
                if (c == '.') {
                    ++count;
                }
                sb1.append(c);
            }
            String network1 = sb1.toString();
            //vasiot kod tuka
            SLLNode<MapEntry<String,String[]>> temp = tabela.search(ip_adresa_interfejs);
            if (temp != null && (Arrays.asList(temp.element.value).contains(network) || Arrays.asList(temp.element.value).contains(network1))){
                System.out.println("postoi");
            }else {
                System.out.println("ne postoi");
            }
        }
    }
}
