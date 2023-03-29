class P1212 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        StringBuilder str = read();
        String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};
        String[] start = {"0", "1", "10", "11", "100", "101", "110", "111"};

        sb.append(start[str.charAt(0) - '0']);

        for (int i = 1; i < str.length(); i++) {
            sb.append(arr[str.charAt(i) - '0']);
        }

        System.out.println(sb);
    }

    private static StringBuilder read() throws Exception {
        StringBuilder sb = new StringBuilder();
        int c;

        sb.append((char)System.in.read());

        while ((c = System.in.read()) > 32) {
            sb.append((char)c);
        }

        if (c == 13) {
            System.in.read();
        }

        return sb;
    }
}
