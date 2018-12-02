package Ogre;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Ogre extends Application
{
    Integer startflag = 0;
    Integer bulletson = 0;
    Integer bullets = 5;
    Integer shrekpath = 0;
    Integer chuckpath = 0;

    Label lblbullets = new Label();

    Image background = new Image(getClass().getResourceAsStream("pics/bg.png"));
    Image crosshair = new Image(getClass().getResourceAsStream("pics/crosshair.png"));
    Image banner = new Image(getClass().getResourceAsStream("pics/banner.png"));
    Image starter = new Image(getClass().getResourceAsStream("pics/shrek1.png"));
    Image starter2 = new Image(getClass().getResourceAsStream("pics/shrek1dead.png"));
    Image starterpointer = new Image(getClass().getResourceAsStream("pics/starterpointer.png"));
    Image instructions = new Image(getClass().getResourceAsStream("pics/Instructions.png"));
    Image chuck = new Image(getClass().getResourceAsStream("pics/ch.gif"));
    Image shrek = new Image(getClass().getResourceAsStream("pics/shrek2.png"));
    Image gameover = new Image(getClass().getResourceAsStream("pics/gameover.jpg"));
    Image winner = new Image(getClass().getResourceAsStream("pics/winner.jpg"));

    ImageView bgv = new ImageView();
    ImageView bannerv = new ImageView();
    ImageView starterv = new ImageView();
    ImageView starterpointerv = new ImageView();
    ImageView instructionsv = new ImageView();
    ImageView chuckv = new ImageView();
    ImageView shrekv = new ImageView();
    ImageView gameoverv = new ImageView();
    ImageView winnerv = new ImageView();

    FadeTransition ftstarter = new FadeTransition(Duration.millis(3000), starterv);
    FadeTransition ftstarterpointer = new FadeTransition(Duration.millis(1000), starterpointerv);

    Path pathstarter = new Path();
    Path pathstarterpointer = new Path();
    Path pathbanner = new Path();
    Path pathinstructions = new Path();
    Path pathinstructions2 = new Path();
    Path pathchuck1 = new Path();
    Path pathchuck2 = new Path();
    Path pathchuck3 = new Path();
    Path pathshrek1 = new Path();
    Path pathshrek2 = new Path();
    Path pathshrek3 = new Path();

    PathTransition pathTransitionstarter = new PathTransition();
    PathTransition pathTransitionstarterpointer = new PathTransition();
    PathTransition pathTransitionbanner = new PathTransition();
    PathTransition pathTransitioninstructions = new PathTransition();
    PathTransition pathTransitioninstructions2 = new PathTransition();
    PathTransition pathTransitionchuck1 = new PathTransition();
    PathTransition pathTransitionchuck2 = new PathTransition();
    PathTransition pathTransitionchuck3 = new PathTransition();
    PathTransition pathTransitionshrek1 = new PathTransition();
    PathTransition pathTransitionshrek2 = new PathTransition();
    PathTransition pathTransitionshrek3 = new PathTransition();

    @Override
    public void start(Stage primaryStage)
    {
        bgv.setImage(background);

        gameoverv.setImage(gameover);
        gameoverv.setX(1000); gameoverv.setY(1000);
        gameoverv.setFitWidth(1240); gameoverv.setFitHeight(554);

        winnerv.setImage(winner);
        winnerv.setX(1000); winnerv.setY(1000);
        winnerv.setFitWidth(1240); winnerv.setFitHeight(554);

        bannerv.setImage(banner);
        bannerv.setX(250); bannerv.setY(0);
        pathbanner.getElements().add(new MoveTo(450,200));
        pathbanner.getElements().add(new HLineTo(3000));
        pathTransitionbanner.setDuration(Duration.millis(1000));
        pathTransitionbanner.setPath(pathbanner);
        pathTransitionbanner.setNode(bannerv);
        pathTransitionbanner.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionbanner.setCycleCount(1);
        pathTransitionbanner.setAutoReverse(true);

        starterv.setImage(starter);
        starterv.setX(250);starterv.setY(300);
        starterv.setFitWidth(200); starterv.setFitHeight(200);
        ftstarter.setFromValue(1.0);
        ftstarter.setToValue(0.0);
        ftstarter.setCycleCount(1);
        ftstarter.setAutoReverse(true);
        pathstarter.getElements().add(new MoveTo(450,200));
        pathstarter.getElements().add(new HLineTo(3000));
        pathTransitionstarter.setDuration(Duration.millis(1000));
        pathTransitionstarter.setPath(pathstarter);
        pathTransitionstarter.setNode(starterv);
        pathTransitionstarter.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionstarter.setCycleCount(1);
        pathTransitionstarter.setAutoReverse(true);

        starterpointerv.setImage(starterpointer);
        starterpointerv.setX(420);starterpointerv.setY(300);
        ftstarterpointer.setFromValue(1.0);
        ftstarterpointer.setToValue(0.0);
        ftstarterpointer.setCycleCount(Timeline.INDEFINITE);
        ftstarterpointer.setAutoReverse(true);
        ftstarterpointer.play();
        pathstarterpointer.getElements().add(new MoveTo(450,200));
        pathstarterpointer.getElements().add(new HLineTo(3000));
        pathTransitionstarterpointer.setDuration(Duration.millis(1000));
        pathTransitionstarterpointer.setPath(pathstarterpointer);
        pathTransitionstarterpointer.setNode(starterpointerv);
        pathTransitionstarterpointer.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionstarterpointer.setCycleCount(1);
        pathTransitionstarterpointer.setAutoReverse(true);

        instructionsv.setImage(instructions);
        instructionsv.setX(1241); instructionsv.setY(0);
        pathinstructions.getElements().add(new MoveTo(0, 280));
        pathinstructions.getElements().add(new HLineTo(620));
        pathTransitioninstructions.setDuration(Duration.millis(1000));
        pathTransitioninstructions.setPath(pathinstructions);
        pathTransitioninstructions.setNode(instructionsv);
        pathTransitioninstructions.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitioninstructions.setCycleCount(1);
        pathTransitioninstructions.setAutoReverse(true);
        pathinstructions2.getElements().add(new MoveTo(0, 280));
        pathinstructions2.getElements().add(new HLineTo(2000));
        pathTransitioninstructions2.setDuration(Duration.millis(1000));
        pathTransitioninstructions2.setPath(pathinstructions2);
        pathTransitioninstructions2.setNode(instructionsv);
        pathTransitioninstructions2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitioninstructions2.setCycleCount(1);
        pathTransitioninstructions2.setAutoReverse(true);

        chuckv.setImage(chuck);
        chuckv.setX(999); chuckv.setY(999);
        chuckv.setFitWidth(300); chuckv.setFitHeight(300);
        pathchuck1.getElements().add(new MoveTo(400, 300));
        pathchuck1.getElements().add(new HLineTo(1100));
        pathTransitionchuck1.setDuration(Duration.millis(1000));
        pathTransitionchuck1.setPath(pathchuck1);
        pathTransitionchuck1.setNode(chuckv);
        pathTransitionchuck1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionchuck1.setCycleCount(Timeline.INDEFINITE);
        pathTransitionchuck1.setAutoReverse(true);
        pathchuck2.getElements().add(new MoveTo(0, 280));
        pathchuck2.getElements().add(new CubicCurveTo(499, 328, 710, 334, 420, 310));
        pathTransitionchuck2.setDuration(Duration.millis(1000));
        pathTransitionchuck2.setPath(pathchuck2);
        pathTransitionchuck2.setNode(chuckv);
        pathTransitionchuck2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionchuck2.setCycleCount(Timeline.INDEFINITE);
        pathTransitionchuck2.setAutoReverse(true);
        pathchuck3.getElements().add(new MoveTo(0, 280));
        pathchuck3.getElements().add(new CubicCurveTo(666, 3228, 10, 34, 480, 222));
        pathTransitionchuck3.setDuration(Duration.millis(1000));
        pathTransitionchuck3.setPath(pathchuck3);
        pathTransitionchuck3.setNode(chuckv);
        pathTransitionchuck3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionchuck3.setCycleCount(Timeline.INDEFINITE);
        pathTransitionchuck3.setAutoReverse(true);

        shrekv.setImage(shrek);
        shrekv.setX(999); shrekv.setY(999);
        shrekv.setFitWidth(300); shrekv.setFitHeight(300);
        pathshrek1.getElements().add(new MoveTo(400, 300));
        pathshrek1.getElements().add(new HLineTo(1100));
        pathTransitionshrek1.setDuration(Duration.millis(1200));
        pathTransitionshrek1.setPath(pathshrek1);
        pathTransitionshrek1.setNode(shrekv);
        pathTransitionshrek1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionshrek1.setCycleCount(Timeline.INDEFINITE);
        pathTransitionshrek1.setAutoReverse(true);
        pathshrek2.getElements().add(new MoveTo(0, 280));
        pathshrek2.getElements().add(new CubicCurveTo(499, 328, 710, 334, 420, 310));
        pathTransitionshrek2.setDuration(Duration.millis(1200));
        pathTransitionshrek2.setPath(pathshrek2);
        pathTransitionshrek2.setNode(shrekv);
        pathTransitionshrek2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionshrek2.setCycleCount(Timeline.INDEFINITE);
        pathTransitionshrek2.setAutoReverse(true);
        pathshrek3.getElements().add(new MoveTo(0, 280));
        pathshrek3.getElements().add(new CubicCurveTo(666, 3228, 10, 34, 480, 222));
        pathTransitionshrek3.setDuration(Duration.millis(1200));
        pathTransitionshrek3.setPath(pathshrek3);
        pathTransitionshrek3.setNode(shrekv);
        pathTransitionshrek3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionshrek3.setCycleCount(Timeline.INDEFINITE);
        pathTransitionshrek3.setAutoReverse(true);

        lblbullets.setFont(Font.font ("Verdana", 60));
        lblbullets.setTextFill(Color.RED);
        lblbullets.setText("Bullets: " + Integer.toString(bullets));
        lblbullets.setLayoutX(0); lblbullets.setLayoutY(999);

        starterv.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
              if(startflag == 0)
              {
                starterv.setImage(starter2);
                ftstarter.play();
                pathTransitionbanner.play();
                pathTransitionstarterpointer.play();
                pathTransitioninstructions.play();
                startflag = 1;
              }
            }

        });

        instructionsv.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                chuckv.setX(120); chuckv.setY(100);
                shrekv.setX(280); shrekv.setY(300);
                pathTransitionstarter.play();
                pathTransitioninstructions2.play();
                lblbullets.setLayoutX(0); lblbullets.setLayoutY(475);
                bulletson = 1;
                pathTransitionshrek1.play();
                pathTransitionchuck1.play();

            }
        });

        bgv.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                if (bulletson == 1)
                {
                    bullets = bullets - 1;
                    lblbullets.setText("Bullets: " + Integer.toString(bullets));
                    gameover();
                }
            }
        });

        winnerv.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                 startflag = 0;
                bulletson = 0;
                bullets = 5;
                shrekpath = 0;
                chuckpath = 0;

                gameoverv.setX(1000); gameoverv.setY(1000);
                winnerv.setX(1000); winnerv.setY(1000);

                shrekv.setX(1000); shrekv.setY(1000);
                chuckv.setX(1000); chuckv.setY(1000);
                starterv.setImage(starter2);
                ftstarter.play();
                pathTransitionbanner.play();
                pathTransitionstarterpointer.play();
                pathTransitioninstructions.play();
                startflag = 1;
                lblbullets.setText("Bullets: " + Integer.toString(bullets));
                lblbullets.setLayoutX(0); lblbullets.setLayoutY(999);
            }
        });

        gameoverv.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                startflag = 0;
                bulletson = 0;
                bullets = 5;
                shrekpath = 0;
                chuckpath = 0;

                gameoverv.setX(1000); gameoverv.setY(1000);
                winnerv.setX(1000); winnerv.setY(1000);

                shrekv.setX(1000); shrekv.setY(1000);
                chuckv.setX(1000); chuckv.setY(1000);
                starterv.setImage(starter2);
                ftstarter.play();
                pathTransitionbanner.play();
                pathTransitionstarterpointer.play();
                pathTransitioninstructions.play();
                startflag = 1;

                lblbullets.setText("Bullets: " + Integer.toString(bullets));
                lblbullets.setLayoutX(0); lblbullets.setLayoutY(999);
            }
        });

        chuckv.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                if (bulletson == 1)
                {
                    bullets = 0;
                    lblbullets.setText("Bullets: " + Integer.toString(bullets));
                    gameover();
                }
            }
        });

        shrekv.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                bullets = bullets + 5;
                lblbullets.setText("Bullets: " + Integer.toString(bullets));

                if(shrekpath == 0)
                {
                    pathTransitionshrek1.stop();
                    pathTransitionshrek2.play();
                    pathTransitionchuck1.stop();
                    pathTransitionchuck2.play();
                    shrekpath = 1;
                }
                else if (shrekpath == 1)
                {
                    pathTransitionshrek2.stop();
                    pathTransitionshrek3.play();
                    pathTransitionchuck2.stop();
                    pathTransitionchuck3.play();
                    shrekpath = 2;
                }
                else if (shrekpath == 2)
                {
                    pathTransitionshrek3.stop();
                    pathTransitionchuck3.stop();
                    bulletson = 0;
                    winnerv.setX(0); winnerv.setY(0);
                    shrekpath = 0;
                }

            }
        });


        Pane root = new Pane();
        root.getChildren().addAll(bgv,  bannerv, starterv, starterpointerv, instructionsv, shrekv, chuckv, lblbullets, gameoverv, winnerv);

        Scene scene = new Scene(root, 1240, 554);
        scene.setCursor(new ImageCursor(crosshair,crosshair.getWidth()/2,crosshair.getHeight()/2));

        primaryStage.setTitle("Kill the Ogre");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }

    public void gameover ()
    {
        if (bullets == 0)
        {
            bulletson = 0;
            pathTransitionshrek1.stop();
            pathTransitionchuck1.stop();
            pathTransitionshrek2.stop();
            pathTransitionchuck2.stop();
            pathTransitionshrek3.stop();
            pathTransitionchuck3.stop();
            gameoverv.setX(0); gameoverv.setY(0);
        }
    }

}
