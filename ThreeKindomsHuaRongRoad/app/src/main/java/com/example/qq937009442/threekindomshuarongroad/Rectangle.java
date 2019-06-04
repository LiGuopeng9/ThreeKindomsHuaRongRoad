package com.example.qq937009442.threekindomshuarongroad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.qq937009442.threekindomshuarongroad.GameLoc;

public class Rectangle implements Serializable {
    private int id;
    private int recX;
    private int recY;
    private int kind;
    private LinkedList<int[]> xyList = new LinkedList<>();

    public Rectangle() {

    }

    public Rectangle(int id, int recX, int recY, int kind) {
        this.id = id;
        this.recX = recX;
        this.recY = recY;
        this.kind = kind;
        addXYLIST();
    }

    private void addXYLIST() {
        int[] recLoc;
        switch (kind) {
            case 1:
                //田字形
                recLoc = new int[2];
                recLoc[0] = recX;
                recLoc[1] = recY;
                xyList.addLast(recLoc);

                recLoc = new int[2];
                recLoc[0] = recX + 1;
                recLoc[1] = recY;
                xyList.addLast(recLoc);

                recLoc = new int[2];
                recLoc[0] = recX;
                recLoc[1] = recY - 1;
                xyList.addLast(recLoc);

                recLoc = new int[2];
                recLoc[0] = recX + 1;
                recLoc[1] = recY - 1;
                xyList.addLast(recLoc);
                break;
            case 2:
                //日字形
                recLoc = new int[2];
                recLoc[0] = recX;
                recLoc[1] = recY;
                xyList.addLast(recLoc);

                recLoc = new int[2];
                recLoc[0] = recX;
                recLoc[1] = recY - 1;
                xyList.addLast(recLoc);
                break;
            case 3:
                //倒着的日字形
                recLoc = new int[2];
                recLoc[0] = recX;
                recLoc[1] = recY;
                xyList.addLast(recLoc);

                recLoc = new int[2];
                recLoc[0] = recX + 1;
                recLoc[1] = recY;
                xyList.addLast(recLoc);
                break;
            case 4:
                //小方块
                recLoc = new int[2];
                recLoc[0] = recX;
                recLoc[1] = recY;
                xyList.addLast(recLoc);
                break;
        }
        //输出当前list
//        System.out.println("xyList------------kind=="+kind+"------");
//        for (int position = 0;;position++)
//        {
//            int x=xyList.get(position)[0];
//            int y=xyList.get(position)[1];
//            System.out.print("("+x+","+y+")");
//            if(xyList.getLast()==xyList.get(position))
//            {
//                break;
//            }
//        }
//        System.out.println("------------------");
    }

    public void recTake(GameLoc g) {
        g.locTake(xyList);
    }

    private int recCanMove(GameLoc g, String direct) {
        switch (direct) {
            case "Up":
                if (recY == 4)
                    return 0;
                switch (this.kind) {
                    case 1:
                    case 3:
                        if (g.getLoc()[recX][recY + 1] == 0 && g.getLoc()[recX + 1][recY + 1] == 0) {
                            return 1;
                        } else {
                            return 0;
                        }

                    case 2:
                    case 4:
                        if (g.getLoc()[recX][recY + 1] == 0) {
                            return 1;
                        } else {
                            return 0;
                        }
                }
                return 0;
            case "Left":
                if (recX == 0)
                    return 0;
                switch (this.kind) {
                    case 1:
                    case 2:
                        if (g.getLoc()[recX - 1][recY] == 0 && g.getLoc()[recX - 1][recY - 1] == 0) {
                            return 1;
                        } else {
                            return 0;
                        }

                    case 3:
                    case 4:
                        if (g.getLoc()[recX - 1][recY] == 0) {
                            return 1;
                        } else {
                            return 0;
                        }
                }
                return 0;
            case "Right":
                if (recX == 3)
                    return 0;
                switch (this.kind) {
                    case 1:
                        if (recX != 2 && g.getLoc()[recX + 2][recY] == 0 && g.getLoc()[recX + 2][recY - 1] == 0) {
                            return 1;
                        } else {
                            return 0;
                        }
                    case 2:
                        if (g.getLoc()[recX + 1][recY] == 0 && g.getLoc()[recX + 1][recY - 1] == 0) {
                            return 1;
                        } else {
                            return 0;
                        }


                    case 3:
                        if (recX != 2 && g.getLoc()[recX + 2][recY] == 0) {
                            return 1;
                        } else {
                            return 0;
                        }
                    case 4:
                        if (g.getLoc()[recX + 1][recY] == 0) {
                            return 1;
                        } else {
                            return 0;
                        }
                }
                return 0;
            case "Down":
                if (recY == 0)
                    return 0;
                switch (this.kind) {
                    case 1:
                        if (recY != 1 && g.getLoc()[recX][recY - 2] == 0 && g.getLoc()[recX + 1][recY - 2] == 0) {
                            return 1;
                        } else {
                            return 0;
                        }
                    case 2:
                        if (recY != 1 && g.getLoc()[recX][recY - 2] == 0) {
                            return 1;
                        } else {
                            return 0;
                        }
                    case 3:
                        if (g.getLoc()[recX][recY - 1] == 0 && g.getLoc()[recX + 1][recY - 1] == 0) {
                            return 1;
                        } else {
                            return 0;
                        }
                    case 4:
                        if (g.getLoc()[recX][recY - 1] == 0) {
                            return 1;
                        } else {
                            return 0;
                        }
                }
                return 0;
        }
        return 0;
    }

    public int recMove(GameLoc g, String direct) {
        if (this.recCanMove(g, direct) == 1) {

            //GameLoc中删除原位置
            g.locRemove(xyList);

            //更新rectangle的数据
            switch (direct) {
                case "Up":
                    recY = recY + 1;
                    break;
                case "Down":
                    recY = recY - 1;
                    break;
                case "Left":
                    recX = recX - 1;
                    break;
                case "Right":
                    recX = recX + 1;
                    break;
            }
            xyList.clear();
            addXYLIST();
            //在gameloc中占用新的位置
            g.locTake(xyList);
            return 1;
        }
        return 0;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecX() {
        return recX;
    }

    public void setRecX(int recX) {
        this.recX = recX;
    }

    public int getRecY() {
        return recY;
    }

    public void setRecY(int recY) {
        this.recY = recY;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public LinkedList<int[]> getXyList() {
        return xyList;
    }

    public void setXyList(LinkedList<int[]> xyList) {
        this.xyList = xyList;
    }
}
