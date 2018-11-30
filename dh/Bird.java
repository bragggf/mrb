import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;

public class Bird extends Group {
	private Rectangle duck;

	public Bird(double x, double y, String filename) {
		setTranslateX(x);
		setTranslateY(y);

		duck = new Rectangle(4.6, 7.5);

		Image img = new Image("file:"+filename);
		ImagePattern pat = new ImagePattern(img);
		duck.setFill(pat);

		this.getChildren().add(duck);
	}

	public void moveUp() {
		duck.setTranslateX(-duck.getWidth() / 2);
		duck.setTranslateY(-duck.getHeight() / 2);
		System.out.println(duck.getHeight());
	}



}