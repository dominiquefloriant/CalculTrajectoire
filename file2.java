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