import java.util.*;
public class shortestpath {

    static class Coords {
        int x;
        int y;

        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



    public static Point getPathBFS(int x, int y, String[][]arr) {
        Queue<Point> q = new LinkedList<Point>();

        boolean[][] visited = new boolean[50][50];

        for (int i = 0; i < 50; i++){
            for (int j = 0;j < 50; j++){
                if (arr[i][j].equals("1") || arr[i][j].equals("8") || arr[i][j].equals("2")){
                    visited[i][j] = true;
                }
            }
        }

        q.add(new Point(x,y, null));

        while(!q.isEmpty()) {
            Point p = q.poll();

            if (arr[p.x][p.y].equals("A")) {
                return p;
            }

            if(isFree(p.x+1,p.y,arr,visited)) {
                Point nextP = new Point(p.x+1,p.y, p);
                visited[p.x+1][p.y] = true;
                q.add(nextP);
            }

            if(isFree(p.x-1,p.y,arr,visited)) {
                Point nextP = new Point(p.x-1,p.y, p);
                visited[p.x-1][p.y] = true;
                q.add(nextP);
            }

            if(isFree(p.x,p.y+1,arr,visited)) {
                Point nextP = new Point(p.x,p.y+1, p);
                visited[p.x][p.y+1] = true;
                q.add(nextP);
            }

            if(isFree(p.x,p.y-1,arr,visited)) {
                Point nextP = new Point(p.x,p.y-1, p);
                visited[p.x][p.y-1] = true;
                q.add(nextP);
            }

        }
        return null;
    }

    public static boolean isFree(int x, int y, String[][]arr, boolean[][]visited) {
        if((x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (visited[x][y] == false)) {
            return true;
        }
        return false;
    }
}

