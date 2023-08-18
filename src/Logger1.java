import java.io.*;
    public class Logger1 {
        private static int count = 0;

        public static void log(String string) {
            if (string != null){
                BufferedWriter bw = null;
                try{
                    File file = new File("logs/" + count + ".txt");
                    if(!file.exists()){
                        file.createNewFile();
                        count++;
                    }
                    FileWriter writer = new FileWriter(file);
                    bw = new BufferedWriter(writer);
                    bw.write(string);
                    bw.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

        public static void logIntMap(String[][] board){
            String map = "";
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {

                    if (j + 1 == board[0].length) {
                        if(board[j][i] == null){
                            map += "-" + " ";
                        }
                        else{
                            map += board[j][i];
                        }
                    } else {
                        if(board[j][i] == null){
                            map += "-" + " " ;
                        }
                        else{
                            map += board[j][i] + " ";
                        }

                    }
                }
                map += "\n";
            }
            log(map);
        }
    }

