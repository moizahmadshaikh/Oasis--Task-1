package oasis;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Task1 extends JFrame
{
	
    JTextField textfield1, textfield2,textfield3;
    JLabel jLabel; 
    ButtonListener buttonListener1;
    ButtonListener2 buttonListener2;    

    int random=(int) (Math.random()*100); 
    int count=0;

    
    public Task1()
    {
        
        Container c = getContentPane();
        c.setLayout(null);   
        c.setBackground(Color.GREEN); 
        JLabel labelpic = new JLabel("");
        JLabel j=new JLabel("GUESSING NUMBER");
        j.setForeground(Color.BLACK);
        j.setFont(new Font("tunga",Font.BOLD,24));
        j.setSize(270,20);
        j.setLocation(300,35); 
        JLabel j1=new JLabel("Guess between 1-100");
        j1.setFont(new Font("tunga",Font.PLAIN,17));
        j1.setSize(270,20);
        j1.setLocation(300,60);
        textfield1=new JTextField(10);
        textfield1.setSize(50,30);
        textfield1.setLocation(350,80);       
        jLabel=new JLabel("Status");
        jLabel.setFont(new Font("tunga",Font.PLAIN,17));
        jLabel.setSize(270,20);
        jLabel.setLocation(290,130);
        textfield2=new JTextField(10);
        textfield2.setSize(40,20);
        textfield2.setLocation(160,80);
        JLabel j2=new JLabel("Guesses");
        j2.setFont(new Font("tunga",Font.PLAIN,17));
        j2.setSize(270,20);
        j2.setLocation(210,80);
        JButton b1=new JButton("Predict");
        b1.setSize(150,40);
        b1.setLocation(260,250);
        buttonListener1=new ButtonListener();        
        b1.addActionListener(buttonListener1);     
        JButton b2=new JButton("Try Again");    
        b2.setSize(120,30);
        b2.setLocation(275,200);    
        buttonListener2=new ButtonListener2();        
        b2.addActionListener(buttonListener2);    
        c.add(jLabel);    
        c.add(labelpic);
        c.add(j);    
        c.add(j1);
        c.add(textfield1);
        c.add(textfield2);
        c.add(b1);    
        c.add(b2);        
        c.add(j2);     
        textfield2.setEditable(false);    
        setTitle("GUESS MY NUMBER");        
        setSize(550,350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int a = Integer.parseInt(textfield1.getText());
            count=count+1;
            if(a<random)
            {
                jLabel.setText(a+" is low, try again");
            }    
            else if(a>random)
            {
                jLabel.setText(a+" is high, try again");
            }
            else
            {
                jLabel.setText("WOW !!! IT'S CORRECT, YOU WIN!!!!");    
            }
            textfield1.requestFocus();
            textfield1.selectAll();

            textfield2.setText(count+"");
        }
    }

    private class ButtonListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            random=(int) (Math.random()*100);
            textfield1.setText("");
            textfield2.setText("");
            jLabel.setText("Try and guess the number");
            textfield2.setText("");
            count=0;
            textfield1.setEditable(true);    
            textfield1.requestFocus();
        }
    }

    public static void main(String[] args)
    {
        new Task1();
    }
}