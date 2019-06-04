package com.example.qq937009442.threekindomshuarongroad;

import java.io.Serializable;
import java.util.LinkedList;

public class GameLoc implements Serializable {
    private int[][] loc=new int[4][5];
    public int[][] getLoc() {
        return loc;
    }
    public void setLoc(int[][] loc) {
        this.loc = loc;
    }
    public GameLoc() {
        for(int i=0;i<=3;i++)
        {
            for(int ii=0;ii<=4;ii++)
            {
                loc[i][ii]=0;
            }
        }
        showLoc();
    }
    public void locTake(LinkedList<int[]> list)
    {
        int x,y;
        for (int position = 0;;position++)
        {
            x=list.get(position)[0];
            y=list.get(position)[1];
            loc[x][y]=1;
            if(list.getLast()==list.get(position))
            {
                break;
            }
        }
        System.out.println("take---------------");
        showLoc();
    }
    public    void locRemove(LinkedList<int[]> list)
    {
        int x,y;
        for (int position = 0;;position++)
        {
            x=list.get(position)[0];
            y=list.get(position)[1];
            loc[x][y]=0;
            if(list.getLast()==list.get(position))
            {
                break;
            }
        }
        System.out.println("remove-------------");
        showLoc();
    }
    public void showLoc()
    {
        for(int i=4;i>=0;i--)
        {
            for(int ii=0;ii<=3;ii++)
            {
                System.out.print("("+ii+","+i+")");
                System.out.print(loc[ii][i]+"-----");
            }
            System.out.println();
        }
    }
}
