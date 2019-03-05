public class LawnMower {
    private int x;
    private int y;
    private int maxx;
    private int maxy;
    private String [] cardinalPoint = {"N", "E", "S", "W"};
    private int orientation;

    /**
     * Position
     * @param x
     * @param y
     * Size of the map
     * @param maxx
     * @param maxy
     * 
     * @param firstOrientation
     */
    LawnMower(int x, int y, int maxx, int maxy, String firstOrientation){
        this.x = x;
        this.y = y;
        this.maxx = maxx;
        this.maxy = maxy;

        switch (firstOrientation){
            case "N":
                this.orientation = 0;
                break;
            case "E":
                this.orientation = 1;
                break;
            case "S":
                this.orientation = 2;
                break;
            case "W":
                this.orientation = 3;
                break;
        }
    }

    private void turnLeft(){
        this.orientation = (((this.orientation - 1) % 4) + 4) % 4;
    }

    private void turnRight(){
        this.orientation = (this.orientation + 1) % 4;
    }

    private void movingForward(){
        switch (this.orientation){
            // N
            case 0 :
                if(this.y <= this.maxy){
                    this.y = this.y + 1;
                }
                break;
            case 1 :
                if(this.x <= this.maxx){
                    this.x = this.x + 1;
                }
                break;
            case 2 :
                if(this.y >= 0){
                    this.y = this.y - 1;
                }
                break;
            case 3 :
                if(this.x >= 0){
                    this.x = this.x - 1;
                }
                break;

        }
    }

    public String action(String actionLine){
        char[] actionList = actionLine.toCharArray();
        for (char action : actionList){
            switch (action){
                case 'G':
                    this.turnLeft();
                    break;
                case 'D':
                    this.turnRight();
                    break;
                case 'A':
                    this.movingForward();
                    break;
            }
        }
        return this.x + " " + this.y + " " + this.cardinalPoint[this.orientation];
    }
}
