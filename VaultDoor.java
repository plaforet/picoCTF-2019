import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

public class VaultDoor {

	// Vault Door 1
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

	// Vault Door 3
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

	// Vault Door 4
	public static String vaultDoor4() {

		byte[] myBytes = { 106, 85, 53, 116, 95, 52, 95, 98,
				0x55, 0x6e, 0x43, 0x68, 0x5f, 0x30, 0x66,
				0x5f, 0142, 0131, 0164, 063, 0163, 0137,
				067, 0141, '1', 'c', '8', 'c', '6', '6',
				'8', 'b', };
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
	public static String vaultDoor5() {
		String expected = "JTYzJTMwJTZlJTc2JTMzJTcyJTc0JTMxJTZlJTY3JTVm"
				+ "JTY2JTcyJTMwJTZkJTVmJTYyJTYxJTM1JTY1JTVmJTM2"
				+ "JTM0JTVmJTY0JTYyJTM2JTM5JTM0JTM2JTYyJTYx";
		return urlDecode(base64Decode(expected));
	}

	// Vault Door 6
	public static String vaultDoor6() {
		byte[] myBytes = { 0x3b, 0x65, 0x21, 0xa, 0x38, 0x0,
				0x36, 0x1d, 0xa, 0x3d, 0x61, 0x27, 0x11,
				0x66, 0x27, 0xa, 0x21, 0x1d, 0x61, 0x3b,
				0xa, 0x2d, 0x65, 0x27, 0xa, 0x34, 0x30,
				0x31, 0x30, 0x36, 0x30, 0x31, };
		byte[] passBytes = new byte[32];

		for (int i = 0; i < passBytes.length; i++) {
			passBytes[i] = (byte) (myBytes[i] ^ 0x55);
		}

		try {
			return new String(passBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported Encoding");
			return null;
		}

	}

	// Encode String to Base64
	public static String base64Encode(byte[] input) {
		return Base64.getEncoder().encodeToString(input);
	}

	// Decode Base64 to String
	public static String base64Decode(String base) {
		byte[] decodedURLBytes = Base64.getUrlDecoder()
				.decode(base);
		return new String(decodedURLBytes);
	}

	// Convert an array of bytes into URL encoding
	public static String urlEncode(byte[] input) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < input.length; i++) {
			buf.append(String.format("%%%2x", input[i]));
		}
		return buf.toString();
	}

	// Decode URL encoded text into UTF formatted String
	public static String urlDecode(String encodedURLString) {
		try {
			return URLDecoder.decode(encodedURLString,
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported Encoding.");
			return null;
		}

	}

	/*
	 * Each character can be represented as a byte value using its ASCII encoding.
	 * Each byte contains 8 bits, and an int contains 32 bits, so we can "pack" 4
	 * bytes into a single int. Here's an example: if the hex string is "01ab", then
	 * those can be represented as the bytes {0x30, 0x31, 0x61, 0x62}. When those
	 * bytes are represented as binary, they are:
	 * 
	 * 0x30: 00110000 0x31: 00110001 0x61: 01100001 0x62: 01100010
	 * 
	 * If we put those 4 binary numbers end to end, we end up with 32 bits that can
	 * be interpreted as an int.
	 * 
	 * 00110000001100010110000101100010 -> 808542562
	 * 
	 * Since 4 chars can be represented as 1 int, the 32 character password can be
	 * represented as an array of 8 ints.
	 * 
	 * - Minion #7816
	 */
	public int[] passwordToIntArray(String hex) {
		int[] x = new int[8];
		byte[] hexBytes = hex.getBytes();
		for (int i = 0; i < 8; i++) {
			x[i] = hexBytes[i * 4] << 24
					| hexBytes[i * 4 + 1] << 16
					| hexBytes[i * 4 + 2] << 8
					| hexBytes[i * 4 + 3];
		}
		return x;
	}

	public static String[] stringBinary() {
		int[] intArray = new int[8];
		intArray[0] = 1096770097;
		intArray[1] = 1952395366;
		intArray[2] = 1600270708;
		intArray[3] = 1601398833;
		intArray[4] = 1716808014;
		intArray[5] = 1734293602;
		intArray[6] = 1701067056;
		intArray[7] = 892756537;

		String[] stringBinary = new String[8];
		for (int i = 0; i < intArray.length; i++) {
			stringBinary[i] = Integer
					.toBinaryString(intArray[i]);
		}
		return stringBinary;

	}

	public static String[][] parsedArray(String[] stringBinary) {
		String[][] parsedArray = new String[8][4];
		for (int i = 0; i < 8; i++) {
			String binary = stringBinary[i];
			int len = binary.length();
			for (int j = 3; j > 0; j--) {
				parsedArray[i][j] = binary
						.substring(len - 8);
				binary = binary.substring(0, len - 8);
				len -= 8;
			}
			parsedArray[i][0] = binary;
		}
		return parsedArray;
	}

	// Convert binary 2D Array to Decimal 2D array
	public static byte[][] binaryToByte(String[][] binaryArray) {
		byte[][] byteArray = new byte[8][4];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				byteArray[i][j] = Byte
						.parseByte(binaryArray[i][j], 2);
				System.out.print(byteArray[i][j] + ", ");
			}
			System.out.println();
		}
		return byteArray;
	}

	public static String byteToString(byte[][] byteArray) {
		String password = "";
		for (int i = 0; i < 8; i++) {
			try {
				String pwRow = null;
				for (int j = 0; j < 4; j++) {

					pwRow = new String(byteArray[i],
							"UTF-8");
				}
				password += pwRow;
			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
			}

		}

		return password;

	}

	// Latest VaultDoor checkPassword
	public boolean checkPassword(String password) {
		if (password.length() != 32) {
			return false;
		}
		int[] x = passwordToIntArray(password);
		return x[0] == 1096770097 && x[1] == 1952395366
				&& x[2] == 1600270708 && x[3] == 1601398833
				&& x[4] == 1716808014 && x[5] == 1734293602
				&& x[6] == 1701067056 && x[7] == 892756537;
	}

	public static void main(String[] args) {

		// Parse the long Binary Strings into a multidimensional array
		String[][] binary2DArray = parsedArray(
				stringBinary());
		byte[][] byteArray = binaryToByte(binary2DArray);
		System.out.println(byteToString(byteArray));

	}

}
