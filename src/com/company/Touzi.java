package com.company;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class Touzi {
    private int front = 3;
    private int back = 4;
    private int left = 1;
    private int right = 2;
    private int top = 5;
    private int bottom = 6;

    public void turnLeft(){
//        changeLR();
//        changeTB();
        int tmp = this.top;
        this.top = this.right;
        this.right = this.bottom;
        this.bottom = this.left;
        this.left = tmp;
    }

    public void turnRight(){
//        changeLR();
//        changeTB();
        int tmp = this.top;
        this.top = this.left;
        this.left = this.bottom;
        this.bottom = this.right;
        this.right = tmp;
    }

    public void turnFront(){
        changeFB();
        changeTB();
    }

    public void turnBack(){
        changeFB();
        changeTB();
    }

    public void turnClockWise90(){
        //front -> left
        //left -> back
        //back -> right
        //right -> front
        int tmp = this.front;
        this.front = this.right;
        this.right = this.back;
        this.back = this.left;
        this.left = tmp;
    }

    public void turnAntiClockWise90(){
        int tmp = this.front;
        this.front = this.left;
        this.left = this.back;
        this.back = this.right;
        this.right = tmp;
    }

    private void changeLR(){
        int tmp = this.left;
        this.left = this.right;
        this.right = tmp;
    }
    private void changeFB(){
        int tmp = this.front;
        this.front = this.back;
        this.back = tmp;
    }
    private void changeTB(){
        int tmp = this.top;
        this.top = this.bottom;
        this.bottom = tmp;
    }

    @Override
    public String toString() {
        return "" + left + "" + right + "" + front + "" + back + "" + top + "" + bottom;
    }

    public void init(){
        this.front = 3;
        this.back = 4;
        this.left = 1;
        this.right = 2;
        this.top = 5;
        this.bottom = 6;
    }
}
