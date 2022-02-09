import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Solution a = new Solution();
        String DEFIB = "";
        String nomMin = "";
        String valMin = "";
        String [] recup = new String [2];
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
        // System.out.println("");
            DEFIB = in.nextLine();
             recup = a.Calcul(LON, LAT, a.remplace(a.InfoDefibril(a.index(DEFIB), DEFIB)));
            //DEFIB= "73;Universite Montpellier 1 UFR Pharmacie (Galerie a cote de la pharmacie experimentale);;;3,86034021457447;43,6220496094564";
            if (i == 0){
           
            nomMin = recup[0];
            valMin = recup[1];
            }
            else{
                if(Double.parseDouble(valMin) > Double.parseDouble(recup[1])){
                    nomMin = recup[0];
                    valMin = recup[1];
                }
            }
          /*  for (Integer integer : a.index(DEFIB)) {
            System.out.print(integer+ " ");
            }*/
        
        }
       

        
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(nomMin);
    }

    public Integer[]index (String defib){
        int i = 0;
        ArrayList<Integer> valeur = new ArrayList<>();
     
             while(defib.indexOf(";", i)!=-1){
                 if(defib.indexOf(";", i+1) != defib.indexOf(";", i)){
                    valeur.add(defib.indexOf(";", i));
                 }
            i++;
        
        }
       
        Integer [] Array = new Integer[valeur.size()];
         Array = valeur.toArray(Array);
         

            return Array;
        }

        public String[] InfoDefibril( Integer [] Array,String Defib){
          ArrayList <String> maList = new ArrayList<>();
           for(int i = 0;i<Array.length;i++){
               if (i == 0){
                   maList.add(Defib.substring(Array[i]+1, Array[i+1]));
               }
               else if(i ==(Array.length-1) ){
                   maList.add(Defib.substring(Array[i-1]+1, Array[i]-1));
                   maList.add(Defib.substring(Array[i]+1));
               }
               
           } 
            String [] value = new String[maList.size()];
            value = maList.toArray(value);
            return value;
        }
        public String[] remplace( String[] value){
            for(int i = 0;i<value.length;i++){
                if(i>0){
                  value[i] = value[i].replace(',','.');
                }
            }
            return value;
        }

        public String[] Calcul(String LON,String LAT, String[] values){
            String [] value = new String[2];
            double x,y,d = 0.0;
            String nomMin,valmin = ""; 
            LAT = LAT.replace(',', '.');
            LON = LON.replace(',', '.');
            nomMin = values[0];
            x = (Double.parseDouble(LON)-Double.parseDouble(values[1])) *  Math.cos((Double.parseDouble(LAT)+Double.parseDouble(values[2]))
            /2);
            y = Double.parseDouble(LAT) - Double.parseDouble(values[2]);

            d = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2) )) * 6371;
            valmin = String.valueOf(d);
            value[0] = nomMin;
            value[1] = valmin;

            return value;
        }
    }
