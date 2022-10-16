package jil447_lab6;

public class MyRectangle{
    int startX;
    int startY;
    int width;
    int height;
    public MyRectangle(){
        startX = 0;
        startY = 0;
        width = 0;
        height = 0;
    }
    public MyRectangle(int x, int y, int w, int h){
        startX = x;
        startY = y;
        width = w;
        height = h;
    }
    public int area(){
        return width*height;
    }
    public String toString(){
        StringBuilder S = new StringBuilder();
        S.append("Width: " + width);
        S.append(" Height: " + height);
        S.append(" X: " + startX);
        S.append(" Y: " + startY);
        return S.toString();
    }
    public boolean isInside(int x, int y){
    int x1 = startX;
    int y1 = startY;
    int x2 = x1 + width;
    int y2 = y1 + height;
    if (x > x1 && x < x2 && y > y1 && y < y2)
        return true;
        return false;
    }
    public void setSize(int w, int h) {
        width = w;
        height = h;
    }
    public void setPosition(int x, int y){
        startX = x;
        startY = y;
        }
    }
