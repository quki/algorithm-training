package quki.algorithm.boj;

import java.util.Scanner;

public class P2490 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int count=0;
        for(int i = 0; i<3;i++){
            for(int j = 0; j<4; j++){
                int x = sc.nextInt();
                if(x == 0){
                    count++;
                }
            }
            
            String ans ="";
            if(count == 0 ){ // ¸ð
                ans = "E";
            }else if(count ==1){ // µµ
                ans ="A";
            }else if(count ==2){ // °³
                ans = "B";
            }else if(count == 3){ // °É
                ans = "C";
            }else if(count == 4){ // À·
                ans = "D";
            }
            
            count = 0;
            System.out.println(ans);
        }
    }

}
