package SimpleCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class simpleCalculator extends JFrame implements ActionListener {
    JPanel p1;
    JTextField tf;
    JButton [] digits= new JButton[10];
    JButton []operator= new JButton[10];
    JButton add,sub,mul,div,equal,dec,clr,back,sqr;
    JPanel p;
    double num1,num2,res;
    char op;
    simpleCalculator(){

        tf= new JTextField();
        tf.setBounds(50, 25, 300, 50);
        tf.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        tf.setEditable(false);
        tf.setFocusable(false);
        tf.setFont(new Font("MV Boli",Font.BOLD,25));
        Container contentpane= getContentPane();
        contentpane.setLayout(null);
        p= new JPanel();
        p.setBounds(50, 100, 300, 300);

        add= new JButton("+");
        sub= new JButton("-");
        mul= new JButton("*");
        div= new JButton("/");
        equal= new JButton("=");
        dec= new JButton(".");
        clr= new JButton("clr");
        back= new JButton("<--");
        sqr= new JButton("²");

        operator[0]=add;
        operator[1]=sub;
        operator[2]=mul;
        operator[3]=div;
        operator[4]=equal;
        operator[5]=dec;
        operator[6]=clr;
        operator[7]=back;
        operator[8]=sqr;

        for(int n=0;n<9;n++){
            operator[n].addActionListener(this);
            operator[n].setFocusable(false);
            operator[n].setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        }
        for(int i=0;i<10;i++){
            digits[i]= new JButton(String.valueOf(i));
            digits[i].setFocusable(false);
            digits[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            digits[i].addActionListener(this);
        }


        p.setLayout(new GridLayout(4,4,10,10));
        p.add(digits[1]);
        p.add(digits[2]);
        p.add(digits[3]);
        p.add(add);
        p.add(digits[4]);
        p.add(digits[5]);
        p.add(digits[6]);
        p.add(sub);
        p.add(digits[7]);
        p.add(digits[8]);
        p.add(digits[9]);
        p.add(mul);
        p.add(dec);
        p.add(digits[0]);
        p.add(div);
        p.add(equal);
        p.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        p.setBackground(Color.CYAN);

        clr.setBounds(50,410,92,70);
        sqr.setBounds(152,410,92,70);
        sqr.setFont(new Font("MV Boli",Font.BOLD,25));
        back.setBounds(252,410,94,70);


        this.add(clr);
        this.add(sqr);
        this.add(back);
        this.setResizable(false);
        contentpane.add(tf);


        this.add(p);
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(420,600);
        this.setTitle("Simple Calculator");
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,3));
        this.getContentPane().setBackground(Color.GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i=0;i<10;i++){
           if(e.getSource()==digits[i]) {
               tf.setText(tf.getText().concat(String.valueOf(i)));
           }
       }
       if(e.getSource()==dec){
           tf.setText(tf.getText().concat(String.valueOf(".")));
       }
       if(e.getSource()==add){
           num1= Double.parseDouble(tf.getText());
           op='+';
           tf.setText("");
       }
       if(e.getSource()==sub){
           num1= Double.parseDouble(tf.getText());
           op='-';
           tf.setText("");
       }
       if(e.getSource()==div){
           num1= Double.parseDouble(tf.getText());
           op='/';
           tf.setText("");
       }
       if(e.getSource()==mul){
           num1= Double.parseDouble(tf.getText());
           op='*';
           tf.setText("");
       }
        if(e.getSource()==sqr){
            num1= Double.parseDouble(tf.getText());
            op='²';
            res=num1*num1;
            tf.setText(String.valueOf(res));
        }
        if(e.getSource()==clr){
            tf.setText(" ");
        }
        if(e.getSource()==back)
        {
            String s= tf.getText();
            tf.setText("");
            for(int i=0;i<s.length()-1;i++){
               tf.setText(tf.getText().concat(String.valueOf(s.charAt(i))));
            }
        }

        if(e.getSource() == equal) {
            num2 = Double.parseDouble(tf.getText());
            switch (op) {
                case '+':
                    res = num1 + num2;
                    tf.setText(String.valueOf(res));
                    break;
                case '-':
                    res = num1 - num2;
                    tf.setText(String.valueOf(res));
                    break;
                case '/':
                    res = num1 / num2;
                    tf.setText(String.valueOf(res));
                    break;
                case '*':
                    res = num1 * num2;
                    tf.setText(String.valueOf(res));
                    break;

                default:
                    break;
            }
        }



    }

}
