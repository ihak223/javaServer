import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MSGServer {
    public ServerSocket serverSocket;
    public MSGServer(int port) {
        this.serverSocket = new ServerSocket(port);
    }
    public void listenForConn() {
        Socket socket = this.serverSocket.accept();

    }
    public void connection() {
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
    }
}


public class Project implements ActionListener{
    public Project() {

        JFrame window = new JFrame();

        JButton click = new JButton("Click Me");

        click.setSize(100, 100);
        click.setActionCommand("duck");
        click.addActionListener(this);

        window.setVisible(true);
        window.setSize(500, 500);
        window.setTitle("Test");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());

        window.add(click);

    }

    public int actions;

    public void actionPerformed(ActionEvent ae) {
        System.out.println("Action Performed "+this.actions+": "+ae.getActionCommand());
        this.actions ++;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            new Runnable(){
                public void run() {
                    new Project();
                }
            }
        );
    }
}
