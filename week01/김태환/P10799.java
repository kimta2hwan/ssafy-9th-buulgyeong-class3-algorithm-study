class P10799 {
    public static void main(String[] args) throws Exception {
        int count = 0, size = 1;
        int current, prior = System.in.read();

        while ((current = System.in.read()) > 32) {
            if (current == 40) {
                size++;

            } else {
                if (prior == 40) {
                    count += --size;

                } else {
                    count++;
                    size--;
                }
            }

            prior = current;
        }

        System.out.println(count);
    }
}
