import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;

public class Bird extends Group {
	private Rectangle duck;
	int x;
	int y;

	public Bird(double anX, double aY, String filename) {
		x = (int)anX;
		y = (int)aY;
		setTranslateX(x);
		//setTranslateY(y);

		//EventHandler<MouseEvent> myHandler = new EventHandler<MouseEvent>() {
		//			public void handle(MouseEvent e) {
		//				dead();
		//			}
		//};

		//public void dead() {


		duck = new Rectangle(46, 75);

		Image img = new Image("file:"+filename);
		ImagePattern pat = new ImagePattern(img);
		duck.setFill(pat);

		this.getChildren().add(duck);
	}

	public void moveUp() {
		//duck.setTranslateX(-duck.getWidth() + 10 );
		//duck.setTranslateY(-duck.getHeight() + 10);
		y -= 7;
		duck.setTranslateY(y);
		System.out.println(duck.getHeight());

		if (y < -800){
			y = (int)(Math.random() * 800);
		}
	}


}