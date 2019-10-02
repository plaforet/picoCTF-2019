import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

public class VaultDoor {
	// Solutions to Vault Door 1 & 3

	public static void vaultDoor1() {
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
		for (char x : password) {
			System.out.print(x);
		}
	}

	public static String vaultDoor3() {
		String password = "jU5t_a_sna_3lpm13g34c_u_4_m3rf48";
		char[] buffer = new char[32];
		int i;
		for (i = 0; i < 8; i++) {
			buffer[i] = password.charAt(i);
		}
		for (; i < 16; i++) {
			buffer[i] = password.charAt(23 - i);
		}
		for (; i < 32; i += 2) {
			buffer[i] = password.charAt(46 - i);
		}
		for (i = 31; i >= 17; i -= 2) {
			buffer[i] = password.charAt(i);
		}
		String s = new String(buffer);

		return s;
	}

	public static String vaultDoor4() {

		byte[] myBytes = { 106, 85, 53, 116, 95, 52, 95, 98, 0x55, 0x6e, 0x43, 0x68, 0x5f, 0x30, 0x66, 0x5f, 0142, 0131,
				0164, 063, 0163, 0137, 067, 0141, '1', 'c', '8', 'c', '6', '6', '8', 'b', };
		String password;
		try {
			password = new String(myBytes, "UTF-8");
			return password;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;

	}

	// Vault Door 5
	// (A better GUI tool can be found at https://encoding.tools)
	public static String base64Encode(byte[] input) {
		return Base64.getEncoder().encodeToString(input);
	}

	public static String base64Decode(String base) {
		byte[] decodedURLBytes = Base64.getUrlDecoder().decode(base);
		return new String(decodedURLBytes);
	}

	// URL encoding is meant for web pages, so any double agent spies who steal
	// our source code will think this is a web site or something, defintely not
	// vault door! Oh wait, should I have not said that in a source code
	// comment?
	//
	// -Minion #2415
	public static String urlEncode(byte[] input) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < input.length; i++) {
			buf.append(String.format("%%%2x", input[i]));
		}
		return buf.toString();
	}

	public static String urlDecode(String encodedURLString) {
		try {
			return URLDecoder.decode(encodedURLString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported Encoding.");
			return null;
		}
		
	}

	

	public static boolean checkPassword(String password) {
		String urlEncoded = urlEncode(password.getBytes());
		String base64Encoded = base64Encode(urlEncoded.getBytes());
		String expected = "JTYzJTMwJTZlJTc2JTMzJTcyJTc0JTMxJTZlJTY3JTVm"
				+ "JTY2JTcyJTMwJTZkJTVmJTYyJTYxJTM1JTY1JTVmJTM2" + 
				"JTM0JTVmJTY0JTYyJTM2JTM5JTM0JTM2JTYyJTYx";
		return base64Encoded.equals(expected);
	}

	public static void main(String[] args) {
		String expected = "JTYzJTMwJTZlJTc2JTMzJTcyJTc0JTMxJTZlJTY3JTVm"
				+ "JTY2JTcyJTMwJTZkJTVmJTYyJTYxJTM1JTY1JTVmJTM2" + 
				"JTM0JTVmJTY0JTYyJTM2JTM5JTM0JTM2JTYyJTYx";
		System.out.println(urlDecode(base64Decode(expected)));
	}

}
