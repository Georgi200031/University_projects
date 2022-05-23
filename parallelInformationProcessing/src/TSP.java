import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
class TSP extends Thread{
    TSP(int x){
        this.pass_flag=x;
    }
    static void init(int x){
        min=new double[x];
        answer=new ArrayList[x];
    }
    static int tn;  //тази променлива показва колко на брой са използваните нишки
    int pass_flag; //тази променлива показва точките които нишката ще обхожда
    static ArrayList<points> point=new ArrayList<>();  //този масив съдържа всички точки
    static points startPoint;         //този клас от точки показва коя е началната тояка
    static int indexSp,n;         //indexSP е индекса на стартовата точка n е общите точки
    static double[] min;//минимална стойност на всяко обхождане
    static ArrayList<Double>[] answer;   //тук запазвам всеки град при обхождането
    static ConcurrentHashMap<String,ArrayList<Double>> map= new ConcurrentHashMap<>();
    //това е единственият обект, който се споделя от всички нишки.

    public void run(){
        for (int g = (n / tn)*pass_flag; g < (n*(pass_flag+1)) / tn; g++) {
            if (g != indexSp) {
                ArrayList<Double> temp = cost(n, g, startPoint, n, pass_flag);
                double var = temp.get(0) + dist(point.get(g), startPoint);
                if (var < min[pass_flag]) {
                    min[pass_flag] = var;
                    answer[pass_flag]= temp;
                }
            }
        }
    }


    double dist(points x,points y)
    {
        double sumsq = Math.pow(x.x_c-y.x_c,2)+Math.pow(x.y_c-y.y_c,2);
        return Math.sqrt(sumsq);
    }

    ArrayList<Double> cost(int S, int ini, points sp, int n,int t_flag)
    {
        String dp=String.valueOf(S)+"#"+String.valueOf(ini);
        for(int i=0;i<n;i++){
            dp=dp+"#"+point.get(i).thread_flag[t_flag];
        }
        if(map.containsKey(dp)) {
            return new ArrayList<>(map.get(dp));
        }
        ArrayList<Double> ret=new ArrayList<>();
        ArrayList<Double> tlist=new ArrayList<>();
        double min=Double.MAX_VALUE;
        if(S==2) {
            ret.add(dist(sp,point.get(ini)));
            ret.add((double)ini);
            return ret;
        }
        point.get(ini).thread_flag[t_flag]=false;//от всички точки избираме този който е g и го правом false
        for(int ik=0;ik<n;ik++) {
            if(point.get(ik).thread_flag[t_flag]) {
                ret=cost(S-1,ik,sp,n, t_flag);
                double var=ret.get(0)+dist(point.get(ik),point.get(ini));
                if(var<min) {
                    tlist=ret;
                    min=var;
                }
            }
        }
        point.get(ini).thread_flag[t_flag]=true;
        tlist.set(0,min);
        tlist.add((double)ini);
        map.put(dp,new ArrayList<>(tlist));
        return tlist;
    }
}
