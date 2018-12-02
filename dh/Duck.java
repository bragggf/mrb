import javafx.application.Application;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.input.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.animation.*;

public class Duck extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage stage) {
			Group root = new Group();
			Scene scene = new Scene(root, 800, 600);
			stage.setScene(scene);
			stage.setTitle("Teletubbie Terminator");
			stage.show();


			Rectangle sun = new Rectangle(800, 600);
			root.getChildren().add(sun);
			Image img = new Image("file:TeleSun.png");
			ImagePattern pat = new ImagePattern(img);
			sun.setFill(pat);

	Bird[] ducks = new Bird[4];

			ducks[0] = new Bird(100, 400, "tinky.png");
			ducks[1] = new Bird(100, 300,"dipsy.png");
			ducks[2] = new Bird(100, 200, "lala.png");
			ducks[3] = new Bird(100, 100, "po.png");


			for(int i = 0; i < ducks.length; i++) {
				root.getChildren().add(ducks[i]);
		}
	AnimationTimer myTimer = new AnimationTimer() {
				public void handle(long currentTime) {
					for(int i = 0; i < ducks.length; i++) {
						ducks[i].moveUp();
					}
				}
			};
		myTimer.start();
	}
}
