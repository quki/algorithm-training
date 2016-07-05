package quki.algorithm.math;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * 소수점 2자리 표현 X
 * @author quki
 *
 */
public class BOJ2765 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        StringBuffer sb;
        while(true){
            count++;
            double d = sc.nextDouble();
            int rot = sc.nextInt();
            double t = sc.nextDouble();
            if(rot == 0) break;
            
            sb = new StringBuffer();
            sb.append("Trip #"+count+": " );
            double distance = Math.PI * d * rot * 0.000016;
            String pattern = "####.##";
            DecimalFormat dformat = new DecimalFormat(pattern);
            /*double vel = distance / 3600.0 / t;
            distance = Math.round(distance *100)/100.0;
            vel = Math.round(vel *100)/100.0;*/
            System.out.println(dformat.format(distance));
            sb.append(" ");
           // sb.append(vel);
        }
    }

}
