import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.*;
import java.awt.event.KeyListener;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
import java.applet.*;


/**
 * Most awesome game ever.
 * Known Flaws: Game speed is dependent on cpu speed.
 *
 * @author Ynori7
 * @version June 2007
 */
public class DuckHunt extends JPanel implements Runnable, ImageObserver, MouseMotionListener, MouseListener
{
    JFrame frame;
    Thread thread;
    Image[] picture = new Image[2];
    Image bg = Toolkit.getDefaultToolkit().getImage( "BG.png" );
    Image crosshair = Toolkit.getDefaultToolkit().getImage( "crosshair.png" );
    Image shotImg = Toolkit.getDefaultToolkit().getImage( "shot.png" );
    Image bullet = Toolkit.getDefaultToolkit().getImage( "bullet.png" );
    Image duck1 = Toolkit.getDefaultToolkit().getImage( "duck1.png" );
    Image duck2 = Toolkit.getDefaultToolkit().getImage( "duck2.png" );
    Image duck3 = Toolkit.getDefaultToolkit().getImage( "duck3.png" );
    Image splat = Toolkit.getDefaultToolkit().getImage( "splat.png" );
    Image[] ducks = new Image[3];
    AudioClip sound, sounda, soundb, soundc;
    Rectangle duckLoc;
    int duckx=10, ducky=10, xvel=2, yvel=2, dImg=0;
    int x, y, score = 0, esc=0, hits=0, shots=0;
    double acc=0;
    int xpos, ypos, z, p=0;
    int time, ammo=3, counter=0;
    int direction = 0;
    int dsizex=76, dsizey=37;
    boolean shot = false, hit = false;
    Random rand = new Random();
    DecimalFormat df = new DecimalFormat("0.00");

    public DuckHunt(final AudioClip sound1, final AudioClip sound2, final AudioClip sound3, final AudioClip sound4)
    {
        frame = new JFrame();
        setBackground( Color.black );
        // Set up the frame's graphics.
        sound = sound1;
        sounda = sound2;
        soundb = sound3;
        soundc = sound4;
        frame.add( this );
        // Set up listeners.
        addMouseMotionListener( this );
        addMouseListener( this );
        frame.setResizable( false );
        setPreferredSize( new Dimension( 850, 520 ) );
        frame.pack();
        frame.setVisible( true );
        ducks[0]=duck1;
        ducks[1]=duck2;
        ducks[2]=duck3;
        thread = new Thread( this );
        thread.start();
    }

    public void run()
    {
        while( true )
        {
            // Code in here...

            // Give some time to other stuff, if it needs it.
            try {
                Thread.sleep(0);
            } catch( InterruptedException e ) {  }

            // Force repaint.
            repaint();
        }
    }

    public void paintComponent( Graphics gc )
    {
        // Clear the window.
        super.paintComponent( gc );
        gc.drawImage(bg, 0, 0, 850, 520, null);
        for(int q=0; q<ammo; q++)
        {
            gc.drawImage(bullet, 500+(q*20), 460, 37, 81, null);
        }
        gc.setColor(new Color(0x000000));
        gc.drawString("DUCK HUNT by The Great Ynori7", 10, 500);
        gc.drawString("Kills: "+score+"", 700, 475);
        gc.drawString("Enemies Escaped: "+esc+"", 700, 495);
        if(shots>0)
        {
            acc= ((double)hits/(double)shots)*100;
            gc.drawString("Accuracy: "+df.format(acc)+"%", 700, 515);
        }
        gc.drawImage(crosshair, x-27, y-27, 54, 54, null);
        if(shot == true)
        {
            gc.drawImage(shotImg, xpos, ypos, 54, 54, null);
            if(z>15){ shot = false; }
            z++;
        }

        //draw duck
        if(hit == true)
        {
            gc.drawImage(splat, xpos, ypos, 54, 54, null);
            if(z>25)
            {
                hit = false;
                xvel=1+rand.nextInt(2);
                yvel=1+rand.nextInt(2);
                if(xvel==1)
                { xvel=-2; dImg=1; }
                else{ xvel=2; dImg=0; }
                if(yvel==1)
                { yvel=-2; }
                else{ yvel=2; }
            }
            z++;
        }
        else
        {
            if(counter<6)
            {
                if(duckx>=750){xvel=-xvel; dImg=1; counter++;}
                if(ducky>=480){yvel=-yvel; counter++;}
                if(duckx<=0){xvel=-xvel; dImg=0; counter++;}
                if(ducky<=0){yvel=-yvel; counter++;}
                dsizex=76;
                dsizey=37;
            }
            else
            {
                xvel=0;
                yvel=-2;
                dImg=2;
                dsizex=75;
                dsizey=68;
                if(ducky<=0)
                {
                    gc.drawString("Crap! It flew away.", 400, 250);
                    if(p>150)
                    {
                        duckx=10+rand.nextInt(705);
                        ducky=10+rand.nextInt(460);
                        xvel=1+rand.nextInt(2);
                        yvel=1+rand.nextInt(2);
                        if(xvel==2)
                        { xvel=-2; dImg=1; }
                        else{ xvel=2; dImg=0; }
                        if(yvel==2)
                        { yvel=-2; }
                        else{ yvel=2; }
                        counter=0;
                        p=0;
                        esc++;
                    }
                    p++;
                }
            }
            duckx += xvel;
            ducky += yvel;
            gc.drawImage(ducks[dImg], duckx, ducky, dsizex, dsizey, null);
            duckLoc = new Rectangle( duckx, ducky, dsizex, dsizey);
        }

    }

        // Mouse functions:
    public void mouseMoved( MouseEvent e )
    {
        x = e.getX();
        y = e.getY();
    }

    public void mouseReleased( MouseEvent e )
    {
        if( ( e.getButton() == e.BUTTON2 ) || ( e.getButton() == e.BUTTON3 ) )
        {
            ammo = 3;
            sounda.play();
        }
        else if( ammo>0 )
        {
            shot=true;
            sound.play();
            shots++;
            xpos=x-27;
            ypos=y-27;
            z=0;
            ammo--;
            if(duckLoc.contains( e.getX(), e.getY() ) )
            {
                hit=true;
                soundb.play();
                hits++;
                shot=false;
                counter=0;
                score++;
                duckx=10+rand.nextInt(790);
                ducky=10+rand.nextInt(460);
            }
        }
        else{ soundc.play(); }
    }//left click
    public void mouseDragged( MouseEvent e ) {  }
    public void mouseEntered( MouseEvent e ) {  }
    public void mouseExited( MouseEvent e ) {  }
    public void mousePressed( MouseEvent e ) {  }
    public void mouseClicked( MouseEvent e ) {  }


    public static void main(String[] args) throws Exception
    {
        java.io.File file = new java.io.File("shotgun.wav");
        AudioClip sound = Applet.newAudioClip(file.toURL() );

        java.io.File file1 = new java.io.File("cockgun.wav");
        AudioClip sounda = Applet.newAudioClip(file1.toURL() );

        java.io.File file2 = new java.io.File("duck_1.wav");
        AudioClip soundb = Applet.newAudioClip(file2.toURL() );

        java.io.File file3 = new java.io.File("emptychamber.wav");
        AudioClip soundc = Applet.newAudioClip(file3.toURL() );

        DuckHunt egg = new DuckHunt(sound, sounda, soundb, soundc);
    }
}
