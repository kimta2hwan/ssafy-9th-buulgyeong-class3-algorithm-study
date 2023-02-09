import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int num;
    Node left;
    Node right;

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}

public class P9934_완전이진트리 {
    static int[] building;
    static int buildIdx = 0;
    static ArrayList[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());

        answer = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            answer[i] = new ArrayList<>();
        }

        int nodeSize = (int) Math.pow(2, k) - 1;
        building = new int[nodeSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodeSize; i++) building[i] = Integer.parseInt(st.nextToken());

        Node head = new Node(null, null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        for (int i = 0; i < k - 1; i++) {
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                Node parent = queue.poll();

                Node left = new Node(null, null);
                Node right = new Node(null, null);

                parent.left = left;
                parent.right = right;

                queue.offer(left);
                queue.offer(right);
            }
        }

        inOrder(head, 0);

        for (ArrayList<Integer> levelArray : answer) {
            for (Integer nodeNum : levelArray) {
                sb.append(nodeNum).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void inOrder(Node node, int level) {
        if (node.left != null) {
            inOrder(node.left, level + 1);
        }
        node.num = building[buildIdx++];
        answer[level].add(node.num);

        if (node.right != null) {
            inOrder(node.right, level + 1);
        }
    }
}




