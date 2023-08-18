import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Random;
import za.ac.wits.snake.DevelopmentAgent;
import java.util.logging.Level;
import java.util.logging.Logger;




public class MyAgent extends DevelopmentAgent {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");


    public static void drawSnake(String[][]board, ArrayList<Pointy> y, int snek_no) {
        for (int i = 0; i < y.size() - 1; i++) {
            drawLine(board,y.get(i),y.get(i+1), snek_no);
        }
    }

    public static void drawLine(String[][] board, Pointy head, Pointy tail, int snek_no) {
        int First_coordy = Integer.parseInt(head.y);
        int First_coordx = Integer.parseInt(head.x);
        int Second_Coordx = Integer.parseInt(tail.x);
        int Second_Coordy = Integer.parseInt(tail.y);

        if (First_coordy == Second_Coordy) {
            if (First_coordx < Second_Coordx) {
                for (int j = First_coordx; j < Second_Coordx+1; j++) {
                    board[j][Integer.parseInt(head.y)] = Integer.toString(snek_no);
                }
            }
            if (First_coordx > Second_Coordx) {
                for (int j = First_coordx; j > Second_Coordx-1; j--) {
                    board[j][Integer.parseInt(head.y)] = Integer.toString(snek_no);
                }
            }
        }
        if (First_coordx == Second_Coordx) {
            if (First_coordy < Second_Coordy) {
                for (int f = First_coordy; f < Second_Coordy+1; f++) {
                    board[Integer.parseInt(head.x)][f] = Integer.toString(snek_no);
                }
            }
            if (First_coordy > Second_Coordy) {
                for (int f = First_coordy; f > Second_Coordy-1; f--) {
                    board[Integer.parseInt(head.x)][f] = Integer.toString(snek_no);
                }
            }
        }
    }

    public static int getMove(int Hy, int Hx, Point to) {
        if (Hy != to.y)
            return Hy < to.y ? 1 : 0;

        return Hx < to.x ? 3 : 2;
    }


    public static void main(String args[]) {
        MyAgent agent = new MyAgent();
        MyAgent.start(agent, args);
    }


    @Override
    public void run() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String initString = br.readLine();
            String[] temp = initString.split(" ");
            int nSnakes = Integer.parseInt(temp[0]);
            int row = Integer.parseInt(temp[1]);
            int col = Integer.parseInt(temp[2]);
            int time = 0;

            while (true) {
                time += 1;
                int snek_no;
                String line = br.readLine();
                String[][]TestMatrix = new String[row][col];
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        TestMatrix[i][j] = "0";
                    }
                }


                if (line.contains("Game Over")) {
                    break;
                }

                String apple1 = line;
                String[]applecoords = apple1.split(" ");

                int appleX = Integer.parseInt(applecoords[0]);
                int appleY = Integer.parseInt(applecoords[1]);
                TestMatrix[appleX][appleY] = "A";
                String TimeStep = "TimeStep " + String.valueOf(time)+ ":";

                for (int zombie=0; zombie<6; zombie++) {
                    String zombieLine=br.readLine();
                    snek_no = 2;
                    ArrayList<Pointy> tests = new ArrayList<>();
                    String[] arr = zombieLine.split(" ");
                    for (int j = 0; j < arr.length; j++) {
                        Pointy tempy = new Pointy(arr[j]);
                        tests.add(tempy);
                    }
                    drawSnake(TestMatrix, tests, snek_no);
                    String[]headzom = arr[0].split(",");
                    String headzomX = headzom[0];
                    String headzomY = headzom[1];
                    if (Integer.parseInt(headzomX) != 0){
                        TestMatrix[Integer.parseInt(headzomX)-1][Integer.parseInt(headzomY)] = "2";
                    }
                    if (Integer.parseInt(headzomX) != 49) {
                        TestMatrix[Integer.parseInt(headzomX) + 1][Integer.parseInt(headzomY)] = "2";
                    }
                    if (Integer.parseInt(headzomY) != 0) {
                        TestMatrix[Integer.parseInt(headzomX)][Integer.parseInt(headzomY)-1] = "2";
                    }
                    if (Integer.parseInt(headzomY) != 49) {
                        TestMatrix[Integer.parseInt(headzomX)][Integer.parseInt(headzomY) + 1] = "2";
                    }

                }


                int mySnakeNum = Integer.parseInt(br.readLine());

                int[]arrayhead = new int[2];
                for (int i = 0; i < nSnakes; i++) {
                    String snekleng = "";
                    String snakeLine = br.readLine();
                    String[]out = snakeLine.split(" ");
                    for(int j = 3; j < out.length; j++){
                        if (j == out.length-1){
                            snekleng = snekleng + out[j];
                        }
                        else{
                            snekleng = snekleng + out[j] + " ";
                        }
                    }
                    if (out[0].equals("alive")) {
                        ArrayList<Pointy> tests = new ArrayList<>();
                        String[]arr = snekleng.split(" ");
                        for (int j = 0; j < arr.length; j++) {
                            Pointy tempy = new Pointy(arr[j]);
                            tests.add(tempy);
                        }

                        if (i == mySnakeNum) {
                            snek_no = 1;
                            String[]coords = out[3].split(",");
                            arrayhead[0] = Integer.parseInt(coords[0]);
                            arrayhead[1] = Integer.parseInt(coords[1]);
                        } else {
                            snek_no = 8;
                            String[]coords = out[3].split(",");
                            String headenemX = coords[0];
                            String headenemY = coords[1];
                            if (Integer.parseInt(headenemX) != 0){
                                TestMatrix[Integer.parseInt(headenemX)-1][Integer.parseInt(headenemY)] = "8";
                            }
                            if (Integer.parseInt(headenemX) != 49) {
                                TestMatrix[Integer.parseInt(headenemX) + 1][Integer.parseInt(headenemY)] = "8";
                            }
                            if (Integer.parseInt(headenemY) != 0) {
                                TestMatrix[Integer.parseInt(headenemX)][Integer.parseInt(headenemY)-1] = "8";
                            }
                            if (Integer.parseInt(headenemY) != 49) {
                                TestMatrix[Integer.parseInt(headenemX)][Integer.parseInt(headenemY) + 1] = "8";
                            }
                        }
                        drawSnake(TestMatrix, tests, snek_no);
                    }
                    //do stuff with other snakes
                }

                //finished reading, calculate move:
                TestMatrix[arrayhead[0]][arrayhead[1]] = "S";
                Point p = shortestpath.getPathBFS(arrayhead[0],arrayhead[1],TestMatrix);
                Point nextmove = null;

                int move = 5;
                if (p != null){
                    while(p.getParent() != null) {
                        nextmove = p;
                        p = p.getParent();
                        TestMatrix[p.x][p.y] = "*";
                    }

                    move = getMove(arrayhead[1],arrayhead[0], nextmove);
                }
                Logger1.logIntMap(TestMatrix);
//                p = null;
                System.out.println(move);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}