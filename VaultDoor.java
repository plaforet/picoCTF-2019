
public class VaultDoor {
	// Solutions to Vault Door 1 & 3
	
	public static void descramble() {
		char[] password = new char[32];
		password[0] = 'd';
		password[29] = '4';
	    password[4] = 'r';
	    password[2] = '5';
	    password[23] = 'r';
	    password[3] = 'c';
	    password[17] = '4';
	    password[1] = '3';
	    password[7] = 'b';
	    password[10] = '_';
	    password[5] = '4';
	    password[9] = '3';
	    password[11] = 't';
	    password[15] = 'c';
	    password[8] = 'l';
	    password[12] = 'H';
	    password[20] = 'c';
	    password[14] = '_';
	    password[6] = 'm';
	    password[24] = '5';
	    password[18] = 'r';
	    password[13] = '3';
	    password[19] = '4';
	    password[21] = 'T';
	    password[16] = 'H';
	    password[27] = 'b';
	    password[30] = '8';
	    password[25] = '_';
	    password[22] = '3';
	    password[28] = '7';
	    password[26] = '8';
	    password[31] = 'e';
	    for(char x : password) {
	    	System.out.print(x);
	    }
	}

	public static String thisIsDumb() {
		String password = "jU5t_a_sna_3lpm13g34c_u_4_m3rf48";
		char[] buffer = new char[32];
        int i;
        for (i=0; i<8; i++) {
            buffer[i] = password.charAt(i);
        }
        for (; i<16; i++) {
            buffer[i] = password.charAt(23-i);
        }
        for (; i<32; i+=2) {
            buffer[i] = password.charAt(46-i);
        }
        for (i=31; i>=17; i-=2) {
            buffer[i] = password.charAt(i);
        }
        String s = new String(buffer);
		
		return s;
	}
	public static void main(String[] args) {
		System.out.println(thisIsDumb());
	}

}
