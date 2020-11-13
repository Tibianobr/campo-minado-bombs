package sample.model;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

import static sample.Main.X_TILES;
import static sample.Main.Y_TILES;
import static sample.model.Grid.getNeighbors;

public class Tile extends StackPane {

    public static final int TILE_SIZE = 40;

    private int x;
    private int y;
    private Boolean hasBomb = false;
    private Text value;

    private final Rectangle border = new Rectangle(TILE_SIZE - 2, TILE_SIZE - 2);

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.value = new Text();

        border.setStroke(Color.LIGHTGRAY);
        this.value.setFill(Color.WHITE);

        getChildren().addAll(border,value);

        setTranslateX(x * TILE_SIZE);
        setTranslateY(y * TILE_SIZE);

        setOnMouseClicked(e -> putBomb());
    }


    private void putBomb()
    {
        if (!hasBomb)
        {
            this.value.setText("X");
        }
        else
        {
            this.value.setText("");
            long numBombs = getNeighbors(this).stream().filter(Tile::getHasBomb).count();
            if (numBombs > 0)
                this.getValue().setText(String.valueOf(numBombs));
        }
        this.hasBomb = !hasBomb;


        for (Tile neighbor: getNeighbors(this)) {
            long numBombs = getNeighbors(neighbor).stream().filter(Tile::getHasBomb).count();
            if (numBombs > 0 && !neighbor.getHasBomb())
                neighbor.getValue().setText(String.valueOf(numBombs));
            else if (numBombs == 0 && !neighbor.getHasBomb())
                neighbor.getValue().setText("");
        }

    }




    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Boolean getHasBomb() {
        return hasBomb;
    }

    public void setHasBomb(Boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    public Text getValue() {
        return value;
    }

    public void setValue(Text value) {
        this.value = value;
    }
}
