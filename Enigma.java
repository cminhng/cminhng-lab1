public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }

    public String decrypt(String message){        
        //TODO
        String decrypt = "";
        /* pseudo
        - okay for each char in String message
            - 1. find index of char in rotors[3]
            - 2. get char at same index in rotors[2]
            - 3. get index of same char in rotors[3]
            - 4. get char at index in rotors[0]
            - 5. concat to decrypt str
            - 6. call rotate. 
        */
        char[] toDecrypt = message.toCharArray();
        for(int i = 0; i < toDecrypt.length; i++){
            int idx = rotors[3].indexOf(toDecrypt[i]);
            char correspond = rotors[2].charAt(idx);
            idx = rotors[3].indexOf(correspond);
            correspond = rotors[0].charAt(idx);
            decrypt = decrypt.concat(Character.toString(correspond));
            this.rotate();
        }
        return decrypt;
    }
    
    public String encrypt(String message){
        //TODO
        String encrypt = ""; 
        /* pseudo
        - okay for each char in String message
            - 1. find index of char in rotors[0]
            - 2. get char at same index in rotors[3]
            - 3. get index of same char in rotors[2]
            - 4. get char at index in rotors[3]
            - 5. concat to encrypt str
            - 6. call rotate. 
        */
        char[] toEncrypt = message.toCharArray();
        for(int i = 0; i < toEncrypt.length; i++){
            int idx = rotors[0].indexOf(toEncrypt[i]);
            char correspond = rotors[3].charAt(idx);
            idx = rotors[2].indexOf(correspond);
            correspond = rotors[3].charAt(idx);
            encrypt = encrypt.concat(Character.toString(correspond));
            this.rotate();
        }
        return encrypt;
    }

    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
