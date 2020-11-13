package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.model.Grid;
import sample.model.Tile;

import java.util.List;

import static sample.model.Tile.TILE_SIZE;

public class Main extends Application {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    public static final int X_TILES = WIDTH / TILE_SIZE;
    public static final int Y_TILES = WIDTH / TILE_SIZE;


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Campo Minado!");
        primaryStage.setScene(new Scene(createGrid()));
        primaryStage.show();
    }


    public Parent createGrid() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        Grid gridManager = new Grid();
        List<Tile> tileList = gridManager.create();
        root.getChildren().addAll(tileList);

        return root;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
