class P2504 {
    public static void main(String[] args) throws Exception {
        int[] stack = new int[30];
        int cur, prior = 0, top = -1, count = 1, answer = 0;

        while ((cur = System.in.read()) > 32) {
            switch (cur) {
                case 40:
                case 91:
                    count = cur == 40 ? count * 2 : count * 3;
                    stack[++top] = cur;
                    
                    break;

                case 41:
                    if (top == -1 || stack[top] != 40) {
                        System.out.println(0);

                        return;
                    }

                    if (prior != 0 && prior == 40) {
                        answer += count;
                    } 

                    count /= 2;
                    top--;

                    break;

                case 93:
                    if (top == -1 || stack[top] != 91) {
                        System.out.println(0);

                        return;
                    }

                    if (prior != 0 && prior == 91) {
                        answer += count;
                    } 

                    count /= 3;
                    top--;

                    break;
            }

            prior = cur;
        }

        if (top != -1) {
            System.out.println(0);

        } else {
            System.out.println(answer);
        }
    }
}
