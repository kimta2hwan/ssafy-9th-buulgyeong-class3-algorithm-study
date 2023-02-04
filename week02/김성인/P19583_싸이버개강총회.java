import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P19583_싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();
        HashMap<String, String> inHashMap = new HashMap<>();
        HashMap<String, String> outHashMap = new HashMap<>();

        int count = 0;
        String chat;
        while ((chat = br.readLine()) != null) {
//        while (!((chat = br.readLine()).equals(""))) {
            st = new StringTokenizer(chat);
            String time = st.nextToken();
            String member = st.nextToken();
            if (time.compareTo(s) <= 0) {
                inHashMap.put(member, time);
            } else if (time.compareTo(e) >= 0 && time.compareTo(q) <= 0) {
                outHashMap.put(member, time);
            }
        }
        for (String key : outHashMap.keySet()) {
            if (inHashMap.containsKey(key)) {
                count++;
            }
        }
        System.out.println(count);
    }

}
