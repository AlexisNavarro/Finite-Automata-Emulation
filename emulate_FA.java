import java.util.Scanner;

//AUTHOR: Alexis M. Navarro
//COURSE: AUTOMATA

public class emulate_FA{

    //my movement method in which allows the user the store symbols in the 2d array and then traces 
    //the path of the direction a state goes to if it find the correct symbol.
    public static int movement(int N, int M){
        Scanner input = new Scanner(System.in);

        int [][] state = new int[N][M];
        
        //asks for user input so we can have values in the 2d array
        System.out.println("Please enter the values to be added");
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M; j++) {
                state[i][j] = input.nextInt();
            }
                System.out.println();
        }

        //prints the output of the user
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(state[i][j]+" ");
            }
            System.out.println();
        }

        //emulates the tracing of a FA 
        //i = state
        //j = symbol
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.println("which state do we go to if we are in state "+i+" and see a symbol "+j);
                    if(state[0][j] == 1){
                        System.out.println("we move to state 0 when see a symbol 1");
                        return 0;
                    }else if(state[1][j] == 1){
                        System.out.println("we move to state 1 when see a symbol 1");
                        return 1;
                    }else if(state[2][j] == 2){
                        System.out.println("we move to state 2 when see a symbol 2");
                        return 2;
                    }else if(state[2][j] == 3){
                        System.out.println("we move to state 2 when see a symbol 3");
                        return 2;
                    }
                    
            }//end for j
        }//end for i
        return 0;
    }//end movement


    //checks if the current state that we're in is a final state
    public static boolean final_state(int N, int M){
            int current_state = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(current_state != 2){
                        current_state = movement(N,M);
                        System.out.println("moves state");
                        System.out.println("our current state is: " +current_state);
                        
                        if(current_state == 2){
                            return true;
                        }
                    }else{
                        return false;
                    }//end if
                }//end for j
            }//end for i
            return false;
    }//end final_state


    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        
        System.out.println("how many states do you want?");
        int N= input.nextInt();
        System.out.println("we have a total of "+N+" states\n");

        System.out.println("how many symbols do you want?");
        int M = input.nextInt();
        System.out.println("we have a total of "+M+" symbols\n");

 

        System.out.println(final_state(N,M));
        

    }//end main

}//end class