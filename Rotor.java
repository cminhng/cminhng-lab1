public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
        //what does this do
            
    }
    
    public boolean rotate(){
        //TODO
        //char last = rotorValues.charAt(rotorValues.length()-1);
        String last = rotorValues.substring(rotorValues.length()-1);
        rotorValues = last.concat(rotorValues.substring(0, rotorValues.length()-1));
        return true;
    }
    
    public int indexOf(char c){
        //TODO
    }

    public char charAt(int idx){
        //TODO
    }
}
    
