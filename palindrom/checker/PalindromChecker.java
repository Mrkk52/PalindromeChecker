package palindrom.checker;

/**
 *
 * @author Kinkar
 */
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;



public class PalindromChecker extends JFrame{
    JTextField stringInput,box;
    JLabel title,select,number,resultLabel;
    JButton button,cancle,clear;
    Border border;
    String input;
    
    public void checkPalindromNumber(){
        getContentPane().setBackground(new Color(255, 255, 240));
        setTitle("Palindrom Checker");
        setLayout(null);
        setSize(600,550);
        setLocation(150,200);
        setVisible(true);
        
        //===== Tittle =========================================================
        
        title = new JLabel("Palindrom Checker");
        title.setBounds(150,20,300,40);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        add(title);
        
        //========= Select any one==============================================
        
        number = new JLabel("Enter a Word or Phases : ");
        number.setBounds(65,100,200,30);
        number.setFont(new Font("Arial", Font.BOLD, 15));
        number.setForeground(Color.blue);
        number.setBackground(Color.white);
        add(number);
        
        
        stringInput = new JTextField();
        stringInput.setBounds(250, 100, 220,30);
        stringInput.setBorder(border);
        stringInput.setBorder(BorderFactory.createLineBorder(Color.gray,2));
        stringInput.setOpaque(false);
        stringInput.setFont(new Font("Arial", Font.BOLD, 18));        
        add(stringInput);
        
        //====================Button============================================
        
        button = new JButton("Check");
        button.setBounds(70,300,100,30);
        button.setBackground(Color.black);
        button.setBorder(border);
        button.setFont(new Font("Sans-sarif", Font.BOLD, 17));                
        button.setForeground(Color.white);
        add(button);
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                palindromChecker();
            }
        });
        
        //====================Cancel============================================
        
        cancle = new JButton("Cancel");
        cancle.setBounds(370,300,100,30);
        cancle.setBackground(Color.black);
        cancle.setFont(new Font("Sans-sarif", Font.BOLD, 17));        
        cancle.setBorder(border);
        cancle.setForeground(Color.white);
        add(cancle);
        
        cancle.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
            }
        });
        
        //====================Clear============================================
        
        clear = new JButton("Clear");
        clear.setBounds(220,300,100,30);
        clear.setBackground(Color.black);
        clear.setBorder(border);
        clear.setFont(new Font("Sans-sarif", Font.BOLD, 17));        
        clear.setForeground(Color.white);
        add(clear);
        
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                stringInput.setText("");
                resultLabel.setText("");
            }
        });
        
        
        //===================Result=============================================
        
        resultLabel = new JLabel();
        resultLabel.setBounds(100,170,400,30);
        resultLabel.setBackground(Color.cyan);
        resultLabel.setForeground(Color.magenta);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 25));        
        add(resultLabel);
        
    }
    private void palindromChecker(){
        try{
            String checkEmpty = stringInput.getText();
            if(checkEmpty != null && !checkEmpty.isEmpty()){
                if(isPalindrom()){
                    resultLabel.setText("'"+input+"' Word is Palindrom");
                }
                else{
                    resultLabel.setText("'"+input+"' Word is Not Palindrom");
                }
            }else{
                resultLabel.setText("Enter a valid Input");
            }
        }catch(NumberFormatException e){
            resultLabel.setText("Invalid Input.");
        }
    }
    private boolean isPalindrom(){
        String originalInput = (stringInput.getText());
        input = originalInput.replaceAll("[^a-zA-Z0-9]", "");
        
        int len = input.length();
        for(int i=0, j = len-1; i<len; i++,j--){
            if(input.charAt(i) == input.charAt(j)){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] mrkk) {
        PalindromChecker obj = new PalindromChecker();
        obj.checkPalindromNumber();
    }
    
}
