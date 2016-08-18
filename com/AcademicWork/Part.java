package com.AcademicWork;

/**
 * Created by Administrator on 2016-08-18.
 */
public class Part {
    public int x;
    public int y;

    public Part(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void copyLocation(Part partToCopy){
        this.x = partToCopy.x;
        this.y = partToCopy.y;
    }

    public boolean hasSamePosition(Part part) {
        if (x == part.x && y == part.y) {
            return true;
        } else {
            return false;
        }
    }
}
