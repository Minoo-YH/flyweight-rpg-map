
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import java.util.HashMap;

public class TileGraphicFactory {

    // Save one image for each tile type.
    private static final HashMap<String, Image> images = new HashMap<>();

    // Return a shared image for a tile.
    public static Image getTileGraphic(String type) {

        // Use the old image if it already exists.
        if (images.containsKey(type)) {
            return images.get(type);
        }

        // Create a canvas for the new tile image.
        Canvas canvas = new Canvas(50, 50);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Choose a color for each tile type.
        switch (type.toLowerCase()) {
            case "forest":
                gc.setFill(Color.FORESTGREEN);
                break;
            case "water":
                gc.setFill(Color.DODGERBLUE);
                break;
            case "swamp":
                gc.setFill(Color.DARKOLIVEGREEN);
                break;
            case "road":
                gc.setFill(Color.GRAY);
                break;
            case "building":
                gc.setFill(Color.SANDYBROWN);
                break;
            default:
                gc.setFill(Color.LIGHTGRAY);
        }

        // Draw the tile color.
        gc.fillRect(0, 0, 50, 50);

        // Save the canvas as an image.
        WritableImage image = new WritableImage(50, 50);
        canvas.snapshot(null, image);

        // Store the image for future use.
        images.put(type, image);

        return image;
    }

    // Return the number of shared images.
    public static int getImageCount() {
        return images.size();
    }
}

