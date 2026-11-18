
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {

    // Create a city map or a wilderness map.
    public static Map createMap(String mapType, int width, int height) {

        if (mapType.equalsIgnoreCase("city")) {
            return new CityMap(width, height);
        } else {
            return new WildernessMap(width, height);
        }
    }

    // This method starts the JavaFX window.
    @Override
    public void start(Stage stage) {

        // Create a random RPG map using Factory Method.
        Map map = createMap("wilderness", 10, 5);

        // Each tile is 50 x 50 pixels.
        Canvas canvas = new Canvas(500, 250);

        // Draw the map using shared Flyweight images.
        MapRenderer.drawMap(map, canvas);

        // Put the canvas inside the window.
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 500, 250);

        // Set the window title.
        stage.setTitle("RPG Map - Flyweight Pattern");

        // Show the window.
        stage.setScene(scene);
        stage.show();

        // Print how many shared images were created.
        System.out.println("Shared images: "
                + TileGraphicFactory.getImageCount());
      // Get the same forest image two times.
javafx.scene.image.Image image1 =
        TileGraphicFactory.getTileGraphic("forest");

javafx.scene.image.Image image2 =
        TileGraphicFactory.getTileGraphic("forest");

// Check if both variables use the same image.
System.out.println("Same image: " + (image1 == image2));
    }

    // Start the JavaFX application.
    public static void main(String[] args) {
        launch(args);
    }
}
