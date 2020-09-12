package puzzle.timer;

import java.io.*;
import javax.swing.JOptionPane;

public class fnc {
    
    public String rn(){
        String[] sc={"U","R","L","B","D","F","U2","R2","L2","B2","D2","F2","U'","R'","L'","B'","D'","F'"};
        int a=(int) ((Math.random()*((sc.length)-0))+0);
        return sc[a]+" ";
    }
    
    
    public String scr(int a){
        String t1="m",s="",t="";
        int i=0;
        while(i!=a){
            t=rn();
            if(t1.charAt(0)==t.charAt(0)){
                continue;
            }
            s+=t;
            t1=t;
            i++;
        }
        
        return s;
    }
    
    
    public String best(String[] s,int l){
        double[] n=new double[l];
        for (int i = 0; i < l; i++) {
            n[i]=Double.parseDouble(s[i]);
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l-1; j++) {
                if(n[j]>n[j+1]){
                    double d=n[j];
                    n[j]=n[j+1];
                    n[j+1]=d;
                }
            }
        }        
        return n[0]+"";
    }
    
    
    public String worst(String[] s,int l){
        double[] n=new double[l];
        for (int i = 0; i < l; i++) {
            n[i]=Double.parseDouble(s[i]);
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l-1; j++) {
                if(n[j]>n[j+1]){
                    double d=n[j];
                    n[j]=n[j+1];
                    n[j+1]=d;
                }
            }
        }
        return n[l-1]+"";
    }
    
    
    public double mean(String[] s,int a){
        double m=0;
        for(int i=0;i<a;i++){
            m+=Double.parseDouble(s[i]);
        }
        m/=a;
        return m;
    }
    
    
    public double avg(double t,String[] s,int a){
        double m=0;
        for(int i=0;i<a;i++){
            m+=Double.parseDouble(s[i]);
        }
        m-=t;
        m/=(a-2);
        return m;
    }
    
    
    public String devi(String[] s, int a){
        double d=Double.parseDouble(s[a])-Double.parseDouble(s[a-1]);
        return "("+String.format("%.2f", d)+")";
    }
    
    
    public String avg5(String[] s,int a,int v){
        double m=0;
        double[] n=new double[v];
        
        for (int i = a-(v),j=0; i < a; i++,j++) {
            n[j]=Double.parseDouble(s[i]);
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v-1; j++) {
                if(n[j]>n[j+1]){
                    double d=n[j];
                    n[j]=n[j+1];
                    n[j+1]=d;
                }
            }
        }
        
        n[0]=0;
        n[v-1]=0;
        
        for (int i = 0; i < v; i++) {
            m+=n[i];
        }
        m/=(v-2);
        return String.format("%.2f", m);
    }
    
    
    public void store(String[] s,int a){
        try {
            FileOutputStream file=new FileOutputStream("data.txt");
            ObjectOutputStream f=new ObjectOutputStream(file);
            f.writeObject(a);
            for (int i = 0; i < a; i++) {
                f.writeObject(s[i]);
            }
            f.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, e,"wanning",JOptionPane.ERROR);
        }
    }
    
    
    public void clean(){
        try {
            FileOutputStream file=new FileOutputStream("data.txt");
            ObjectOutputStream f=new ObjectOutputStream(file);
            f.writeObject(0);
            for (int i = 0; i < 999; i++) {
                f.writeObject("");
            }
            f.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, e,"wanning",JOptionPane.ERROR);
        }
    }
    
}