public int[] solution(int[] arr) {
    LinkedList<Integer> q = new LinkedList<>();
    for (int i : arr) {
        if (q.isEmpty() || q.peekLast() != i) {
            q.offer(i);
        }
    }

    int[] result = new int[q.size()];
    int index = 0;
    for (int num : q) {
        result[index++] = num;
    }

    return result;
}