package sample.list;

import javafx.scene.paint.Color;

public enum TileColor {
    ROXO(1, Color.PURPLE),
    AZUL(2,Color.BLUE),
    VERDE(3,Color.GREEN),
    AMARELO(4,Color.YELLOW),
    LARANJA(5,Color.ORANGE),
    VERMELHO(6,Color.RED),
    BORDO(7,Color.rgb(128,0,0)),
    ROSA(8,Color.DEEPPINK);

    private long numBombs;
    public Color selectedColor;

    TileColor(long num,Color color)
    {
        numBombs = num;
        selectedColor = color;
    }

    public static TileColor getByBombNum(long numBombs)
    {
        for (TileColor tileColor: TileColor.values()) {
            if (tileColor.numBombs == numBombs)
                return tileColor;
        }
        return null;
    }
}
