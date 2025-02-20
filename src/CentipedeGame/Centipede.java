/*
Name: Steven Marco Navarrette
Date: 2/19/2025
Assignment: Centipede game
 */

package CentipedeGame;

public class Centipede {
    Segment head;

    //Direction vectors
    int dx, dy;

    int horizontalDir;              //This indicates if we are moving L or R
    int verticalMoveCount = 0;      //Tracks how far we've moved down during a turn
    int verticalLim = 20;           //How many px to move down each time we switch rows
    boolean bossFight = false;
    Centipede brother;
    int segSize = 15;

    public Centipede(int startX, int startY, int length) {
        this.dx = 7;                //centipede's xspeed
        this.dy = 0;                //centipede's yspeed
        this.horizontalDir = 1;     //+1 for right, -1 for left

        //Building the linked segments
        head = new Segment(startX, startY);
        Segment current = head;

        for (int i = 1; i < length; i++) {
            current.next = new Segment(startX - (i * 15), startY);
            current = current.next;
        }

        if (length >=50) {                            //activates the boss mode after the centipede reaches length of 20
            BossMode();
        }
    }

    // method that contains logic for the boss fight
    public void BossMode() {
        bossFight = true;
        segSize = 25;

        brother = new Centipede(head.x, head.y + 30, 20);
        brother.bossFight = true;
    }

    public void move(){
        if (head == null) return;

        //Save old head position
        int prevX = head.x;
        int prevY = head.y;

        //Move head
        head.x += dx;
        head.y += dy;

        //Move body
        Segment current = head.next;
        while (current != null){
            int tempX = current.x;
            int tempY = current.y;
            current.x = prevX;
            current.y = prevY;
            prevX = tempX;
            prevY = tempY;
            current = current.next;
        }

        // if the boss mode is active, the second centipede moves
        if(bossFight && brother != null) {
            brother.move();
            brother.head.y += (int) (10 * Math.sin(brother.head.x / 50.0));
        }
        else {
            bossFight = false;
        }
    }

    public void checkAndTurn(int panelWidth, int panelHeight){
        if (head == null) return;

        //The centipede's approx. "width"
        int segSize = 15;
        int rBound = panelWidth - segSize;
        int lBound = 0;

        //1. If we are moving horizontally (dy == 0)
        if (dy == 0){
            if (horizontalDir == 1 && head.x >= rBound){
                //Start moving down
                dx = 0;
                dy = 7;
                verticalMoveCount = 0;
            } else if (horizontalDir == -1 && head.x <= lBound){
                dx = 0;
                dy = 7;
                verticalMoveCount = 0;
            }
        } else {
            verticalMoveCount += Math.abs(dy);

            if (verticalMoveCount >= verticalLim) {
                //Flip horizontally and switch horizonatl direction to -1
                horizontalDir = -horizontalDir;
                //If we are going right, now go left, if we are going left, now right
                dx = 7 * horizontalDir;
                dy = 0;
            }
        }

        // second centipede will follow with a mirrored movement
        if (bossFight && brother != null) {
            brother.checkAndTurn(panelWidth, panelHeight);
        }
    }

    public void split(Segment splitPoint){
        if (splitPoint == head){
            head = null;
            bossFight = false;
        } else {
            Segment current = head;
            while (current != null && current.next != splitPoint){
                current = current.next;
            }
            if (current != null) {
                current.next = null;
            }
        }
    }
}