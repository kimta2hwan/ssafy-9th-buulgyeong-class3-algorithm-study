import java.util.Arrays;

class P1343 {
	public static void main(String[] args) throws Exception {
		char[] buffer = new char[52];
		int c, len = 0;
		
		while ((c = System.in.read()) > 32) {
			buffer[len++] = (char)c;
		}
		
		String input = String.copyValueOf(Arrays.copyOf(buffer, len));
		
		input = input.replaceAll("XXXX", "AAAA");
		input = input.replaceAll("XX", "BB");
		
		System.out.println(input.contains("X") ? -1 : input);
	}
}
