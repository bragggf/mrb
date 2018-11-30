if (mouseDragged){
    g.setColor(Color.DARK_GRAY);
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(mx, my, 20, 20);

 }else{
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(Color.DARK_GRAY);
    g.fillRect(mx, my, 20, 20);

    }
    repaint();

}

public static void main(String[] args) {
    Mouse mouse = new Mouse();
}

@Override
public void mouseDragged(MouseEvent e) {
    mx = e.getX() - 10;
    my = e.getY() - 10;
    mouseDragged = true;
    e.consume();
}

@Override
public void mouseMoved(MouseEvent e) {
    mx = e.getX();
    my = e.getY();
    mouseDragged = false;
    e.consume();
}