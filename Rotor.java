public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        /*
         * theres no todo thingy here but since we have startChar
         * i assume i should change the string here to start with startChar
         * 
         * pseudo:
         * - find idx of startChar in rotorValues
         * - remove everything in front of that idx
         * - concat it to the end
         */
        if(startChar != '#'){
            int idx = this.indexOf(startChar);
            String end = rotorValues.substring(0, idx);
            String front = rotorValues.substring(idx);
            rotorValues = front.concat(end);
        }
        while(!this.rotate());
        //what does this do ??
            
    }
    
    public boolean rotate(){
        //TODO

        String last = rotorValues.substring(rotorValues.length()-1);
        rotorValues = last.concat(rotorValues.substring(0, rotorValues.length()-1));
        System.out.println("TESTING " + rotorValues);

        if(last.charAt(0) == '#'){
            return true;
        }
        //im checking here because i let the last rotation in rotor happen and IF 
        //that rotation returns rotor to its original state with # in front
        //then enigma will call A SECOND rotation on the NEXT rotor
        //i think ??? 
        //unless it should be that i check if hash is in front (but then how do i
        //get past the first rotation if startChar happens to be #?????)
        return false; 
        //return false bc engima rotates the next rotor if i return true
        //so only return true if you go back to the beginning? 
    }
    
    public int indexOf(char c){
        //TODO
        //check param
        //what is the condition for checking c.... like 
        /*if(c == null){
            return -1;
        }*/

        int index = -1;

        for(int i = 0; i < rotorValues.length(); i++){
            if(rotorValues.charAt(i) == c){
                index = i;
                break;
            }
        }

        return index;
    }

    public char charAt(int idx){
        //TODO
        //param check
        if(idx < 0 || idx >= rotorValues.length()){
            return '\0'; //????????????
        }
        return rotorValues.charAt(idx);
    }
}
    
