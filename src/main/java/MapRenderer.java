
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MapRenderer {

    // Each tile will be 50 pixels wide and high.
    private static final int TILE_SIZE = 50;

    // This method draws the map on a JavaFX Canvas.
    public static void drawMap(Map map, Canvas canvas) {

        // Get the drawing tool from the canvas.
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Go through every row and column of the map.
        for (int row = 0; row < map.height; row++) {
            for (int col = 0; col < map.width; col++) {

                // Get the tile at this position.
                Tile tile = map.tiles[row][col];

                // Get a shared image from the Flyweight factory.
                Image image = TileGraphicFactory.getTileGraphic(
                        tile.getType().toLowerCase()
                );

                // Calculate where to draw the tile.
                int x = col * TILE_SIZE;
                int y = row * TILE_SIZE;

                // Draw the image on the canvas.
                gc.drawImage(image, x, y, TILE_SIZE, TILE_SIZE);

                // Draw a simple border around each tile.
                gc.strokeRect(x, y, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}
