import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * CodingGame.com "Skynet revolution episode 1" solution
 */
class Solution {

    public static void main(String args[]) {
        List<Integer> gateWayList = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        int EI = 0;
        Integer[][] intArray = new Integer[N+1][N+1];
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            intArray[N1][N2] = 1;
            intArray[N2][N1] = 1;
        }
        for (int i = 0; i < E; i++) {
            EI = in.nextInt(); // the index of a gateway node
            gateWayList.add(EI);
        }
        
        // game loop
        while (true) {
            boolean next = false;
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            for(int EII:gateWayList){
                if(intArray[EII][SI] != null) { 
                    System.out.println(EII + " " + SI);
                    next = true;
                    break;
                }
            }
            if(!next){
                for(int i=0; i<N-1; i++){
                    if(intArray[EI][i] != null) { 
                        System.out.println(EI + " " + i);
                        break;
                    }
                }
            }
        }
    }
}