import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    public static final int WIDTH = 700;
    public static final int BTN_LABEL_HEIGHT = 30;
    public static final int GAME_HEIGHT = 500;
    public static final int PANEL_HEIGHT = GAME_HEIGHT + 2*BTN_LABEL_HEIGHT;

    private Game game = new Game( GameFrame.WIDTH, GameFrame.GAME_HEIGHT, false );
    private GamePanel gp = new GamePanel(game);

    private JButton btn = new JButton( "Start" );
    private JLabel lbl = new JLabel("Score: 0");
    private javax.swing.Timer timer;

    public GameFrame(){
        
        game.addGP( gp );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle( "Java Jump" );
        setResizable( false );
        JPanel jp = new JPanel();
        jp.setBackground( Color.WHITE );
        jp.setPreferredSize( new Dimension( WIDTH, PANEL_HEIGHT ) );
        jp.setLayout( null );

        // create timer object
        timer = new javax.swing.Timer( 30, new Clock() );
        // set up the and add the button and label
        btn.setBounds(350, 10, 100, 20);
        btn.addActionListener( new ButtonListener());
        lbl.setBounds(0, 0, 300, 30);
        gp.setBounds( 0, BTN_LABEL_HEIGHT, WIDTH, GAME_HEIGHT );
        jp.add( gp );
        jp.add( lbl );
        jp.add( btn );
        getContentPane().add( jp );
        pack(); 

    }

    public void display() {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    setVisible(true);
                }
            });
    }

    private class Clock implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Ball b = gp.getBall();
            b.move();
            game.update();
            gp.repaint();   // redraw the panel
            // get the score from the game
            int sc = game.getScore();
            // if the game is over, stop the time and display a message
            if(game.keepPlaying()==false){
                timer.stop();
                lbl.setText("GAME OVER. FINAL SCORE: " + sc);
            }else{
                lbl.setText("Score: " + sc);
            }

            // if the game is not over, just display the score.
        
    }
}

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            // if the button says Start, start the timer and change the text to Reset
            if((btn.getText()).equals("Start")){
                timer.start();
                btn.setText("Reset");
            } else{
                timer.stop();
                btn.setText("Start");
                Ball bee = gp.getBall();
                bee.setX(40);
                bee.setY(500);
                game.init();
                repaint();
                // if the button says Reset
                //      stop the time
                //      change the text to Start
                //      call the game's init method 
                //      change what is displayed in the label
                //      cause the game panel's paintComponent method to be called

            }

            gp.requestFocusInWindow();
        }
    }
}

