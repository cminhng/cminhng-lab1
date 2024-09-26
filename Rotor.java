public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        while(!this.rotate());            
    }
    
    public boolean rotate(){
        //TODO
        String last = rotorValues.substring(rotorValues.length()-1);
        rotorValues = last.concat(rotorValues.substring(0, rotorValues.length()-1));
        //System.out.println("TESTING " + rotorValues);

        if(last.charAt(0) == startChar){
            return true;
        }
        
        return false; 
        
    }
    
    public int indexOf(char c){
        //TODO
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
            return '\0'; //????????????i wanted to handle some edge cases but i cant return null
        }
        return rotorValues.charAt(idx);
    }
}
    
