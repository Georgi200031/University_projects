import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of threads to run in parallel:");
        int tn=in.nextInt();
        TSP[] t_arr=new TSP[tn];
        for(int i=0;i<tn;i++){
            t_arr[i] = new TSP(i);
        }
        TSP.tn=tn;
        TSP.init(tn);
        for(int i=0;i<tn;i++){
            TSP.min[i]=Integer.MAX_VALUE;
        }
        int n = 0;
        int line = 0;
        try {
            File myObj = new File("input/inputfifteenCities.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                if(line == 0) {
                    n = Integer.parseInt(myReader.nextLine());
                    System.out.println("number of cities/points: " + n);
                    TSP.n=n;
                }
                else if (line >= 1) {
                    points temp=new points(tn);
                    temp.name=myReader.nextLine();
                    System.out.println(temp.name);
                    temp.x_c=Integer.parseInt(myReader.nextLine());
                    System.out.println(temp.x_c);
                    temp.y_c=Integer.parseInt(myReader.nextLine());
                    System.out.println(temp.y_c);
                    for(int j=0;j<tn;j++)
                        temp.thread_flag[j]=true;
                    TSP.point.add(temp);
                }
                line++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        TSP.n=n;
        System.out.println("enter starting point:");
        String cpn=in.next();
        long startTime = System.nanoTime();
        for(int i=0;i<n;i++) {
            if(cpn.compareTo(TSP.point.get(i).name)==0) {
                TSP.startPoint=TSP.point.get(i);
                TSP.indexSp=i;
                for(int j=0;j<tn;j++)
                    TSP.point.get(i).thread_flag[j]=false;
                break;
            }
        }

        for(int i=0;i<tn;i++) {
            t_arr[i].start();
        }
        try {
            for(int i=0;i<tn;i++) {
                t_arr[i].join();
            }
        }catch (Exception e) {
            System.out.println(e);
        }

        double min_f=Integer.MAX_VALUE;
        int ans_index=0;
        for(int i=0;i<tn;i++){
            if(TSP.min[i]<min_f){
                min_f=TSP.min[i];
                ans_index=i;
            }
        }
        long endTime = System.nanoTime();
        System.out.print("the optimal path is: "+TSP.point.get(TSP.indexSp).name+"-->");
        for(int i=1;i<=n-1;i++){
            System.out.print(TSP.point.get(TSP.answer[ans_index].get(i).intValue()).name+"-->");
        }
        System.out.print(TSP.point.get(TSP.indexSp).name+"\n");
        System.out.println("The total distance covered in the trip is: "+(min_f));
        System.out.println("Time to run: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " milliseconds");
    }
}
