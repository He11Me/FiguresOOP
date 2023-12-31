package logic;

import consts.Consts;

public class Point {

    private int x = 0;
    private int y = 0;
    private int z = 0;
    private int amount = 0;

    public Point(String[] cords) {
        this.amount = cords.length;

        x = Integer.parseInt(cords[Consts.FIRST]);
        y = Integer.parseInt(cords[Consts.SECOND]);

        if (amount == Consts.THREE) {
            z = Integer.parseInt(cords[Consts.THIRD]);
        }
    }

    public int getCordX() {
        return x;
    }

    public int getCordY() {
        return y;
    }

    public int getCordZ() {
        return z;
    }

    public int len() {
        return amount;
    }

    public boolean isEqual(Point p) {
        return getCordX() == p.getCordX() && getCordY() == p.getCordY() && getCordZ() == p.getCordZ();
    }
}
