public class Pointy {

        public String x;
        public String y;

        public Pointy(String coord) {
            String[]newarr = coord.split(",");
            this.x = newarr[0];
            this.y = newarr[1];
        }

}
