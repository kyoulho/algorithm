import java.util.*;

class Solution {
    private int[][] DIRECTS = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        ArrayList<ArrayList<Node>> puzzles = new ArrayList<>();
        ArrayList<ArrayList<Node>> emptyCells = new ArrayList<>();

        // 퍼즐, 빈칸 누끼 따기
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == 1) {
                    ArrayList<Node> puzzle = getPuzzle(new Node(i, j), table);
                    puzzles.add(puzzle);
                }
                if (game_board[i][j] == 0) {
                    ArrayList<Node> emptyCell = getEmptyCell(new Node(i, j), game_board);
                    emptyCells.add(emptyCell);
                }
            }
        }
        // 퍼즐들 0,0으로 옮기기
        for (ArrayList<Node> puzzle : puzzles) {
            moveToZero(puzzle);
        }
        // 빈칸들 0,0으로 옮기기
        for (ArrayList<Node> emptyCell : emptyCells) {
            moveToZero(emptyCell);
        }

        // 퍼즐 사용 여부
        boolean[] usedPuzzles = new boolean[puzzles.size()];
        // 빈칸 사용 여부
        boolean[] usedEmptyCells = new boolean[emptyCells.size()];

        for (int i = 0; i < emptyCells.size(); i++) {
            if (!usedEmptyCells[i]) {
                ArrayList<Node> emptyCell = emptyCells.get(i);

                for (int j = 0; j < puzzles.size(); j++) {
                    if (!usedPuzzles[j]) {
                        ArrayList<Node> puzzle = puzzles.get(j);

                        if (emptyCell.size() == puzzle.size() && isEmptyCellMatching(emptyCell, puzzle)) {
                            answer += emptyCell.size();
                            usedEmptyCells[i] = true;
                            usedPuzzles[j] = true;
                            break;
                        }
                    }
                }
            }
        }


        return answer;
    }

    // 퍼즐과 빈칸의 매칭 여부
    private boolean isEmptyCellMatching(ArrayList<Node> emptyCell, ArrayList<Node> puzzle) {
        ArrayList<Node> rotatePuzzle = new ArrayList<>(puzzle);
        for (int i = 0; i < 4; i++) {
            if (emptyCell.containsAll(rotatePuzzle)) {
                return true;
            }
            rotatePuzzle = rotatePuzzle(rotatePuzzle);
        }
        return false;
    }

    // 퍼즐이나 빈칸을 0,0 가까이로 옮기는 함수
    private static void moveToZero(ArrayList<Node> puzzle) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (Node node : puzzle) {
            minX = Math.min(minX, node.x);
            minY = Math.min(minY, node.y);
        }
        for (Node node : puzzle) {
            node.x = node.x - minX;
            node.y = node.y - minY;
        }
    }

    // 빈칸을 찾아내는 BFS
    private ArrayList<Node> getEmptyCell(Node firstNode, int[][] gameBoard) {
        ArrayList<Node> puzzle = new ArrayList<>();

        LinkedList<Node> q = new LinkedList<>();
        q.add(firstNode);
        gameBoard[firstNode.x][firstNode.y] = 1;

        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            puzzle.add(currentNode);
            int x = currentNode.x;
            int y = currentNode.y;

            for (int[] direct : DIRECTS) {
                int nx = x + direct[0];
                int ny = y + direct[1];

                if (nx >= 0 && nx < gameBoard.length && ny >= 0 && ny < gameBoard.length && gameBoard[nx][ny] == 0) {
                    q.add(new Node(nx, ny));
                    gameBoard[nx][ny] = 1;
                }
            }
        }
        return puzzle;
    }

    // 퍼즐을 찾아내는 BFS
    private ArrayList<Node> getPuzzle(Node firstNode, int[][] table) {
        ArrayList<Node> puzzle = new ArrayList<>();

        LinkedList<Node> q = new LinkedList<>();
        q.add(firstNode);
        table[firstNode.x][firstNode.y] = 0;

        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            puzzle.add(currentNode);
            int x = currentNode.x;
            int y = currentNode.y;

            for (int[] direct : DIRECTS) {
                int nx = x + direct[0];
                int ny = y + direct[1];

                if (nx >= 0 && nx < table.length && ny >= 0 && ny < table.length && table[nx][ny] == 1) {
                    q.add(new Node(nx, ny));
                    table[nx][ny] = 0;
                }
            }
        }
        return puzzle;
    }

    // 퍼즐을 시계 방향으로 회전
    private ArrayList<Node> rotatePuzzle(ArrayList<Node> puzzle) {
        ArrayList<Node> rotatedPuzzle = new ArrayList<>();
        for (Node node : puzzle) {
            rotatedPuzzle.add(new Node(node.y, -node.x));
        }
        moveToZero(rotatedPuzzle);
        return rotatedPuzzle;
    }

    // 좌표 클래스
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}