package lt.vu.mif.jate.lambda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LambdaDemo02 extends JFrame implements Runnable {
   
    private final JButton button = new JButton("Test button");
    
    public LambdaDemo02() {
        this.setTitle("Lambda demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 200));
        this.add(button);
        
        // Old version
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBackground(Color.GREEN);
            }
        });
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(button, e.getActionCommand());
            }
        });
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(this.getClass().getInterfaces()[0].getCanonicalName());
            }
        });
        
        // Lambda
        
        button.addActionListener(e -> button.setBackground(Color.RED));
        button.addActionListener(e -> JOptionPane.showMessageDialog(button, e.getActionCommand()));
        button.addActionListener(e -> System.out.println(this.getClass().getInterfaces()[0].getCanonicalName()));
        
    }
    
    @Override
    public void run() {
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new LambdaDemo02());
    }
    
}
