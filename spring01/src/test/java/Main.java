import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main extends Thread implements ActionListener {
    String[] s= {"你好","哈哈","你好"};
//	String[] s;
    JFrame frame=new JFrame("点名使用");
        JButton btn=new JButton("停止");
        JTextField tf=new JTextField();    
        public Main() throws Exception{
        	
        	BufferedReader br = new BufferedReader(new FileReader("c:\\oo.txt"));
        	List<String> ls  = new ArrayList<String>();
        	String line;
        	while((line =br.readLine())!=null){
        		ls.add(line);
        	}
        
        	Collections.shuffle(ls);
        	
        	s = new String[ls.size()];
        	
        	for(int i =0;i<ls.size();i++){
        	
        	s[i] =ls.get(i);
        	}
      	
        	
        	
//        	Random random = new Random();
//        	for(int i = 0; i < s.length; i++){
//        		int p = random.nextInt(s.length);
//        		String tmp = s[i];
//        		s[i] = s[p];
//        		s[p] = tmp;
//}

        	
            frame.setLayout(null);
            frame.setBounds(300, 400, 300, 350);
            tf.setBounds(100, 40, 120, 30);
            tf.setFont(new Font("Monospaced", 23, 30));
            btn.setBounds(80, 120, 150, 100);
            frame.add(btn);
            frame.add(tf);
            frame.setVisible(true);
            btn.addActionListener(this);
        }      
        public void run(){
            for(int i=1;i<=s.length;i++){
                 
                tf.setText(s[i-1]);
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i==s.length)i=1;
            }          
        }      
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btn){
                if(btn.getText().equals("开始")){
                    this.resume();
                    btn.setText("停止");
                }
                else if(btn.getText().equals("停止")){
                    //this.stop();
                    this.suspend();
                    btn.setText("开始");
                }              
                }
            }                  
        public static void main(String[] args) throws Exception {
            Main m=new Main();
            m.start();
        }
}