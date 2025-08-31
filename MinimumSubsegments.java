public int getminSubsegments(String frames) {
  
       int subsegments=1;

        char type='?';

        for(int i=0; i<frames.length();i+=2){
          char c1 = frames.charAt(i);
          char c2 = frames.charAt(i+1);

          if(c1==c2){
            if(type=='?'){
              type = c1;
            }
            else if(type!=c1){
              subsegments++;
              type=c1;
            }
          }
        }

        return subsegments;
        
   
}
