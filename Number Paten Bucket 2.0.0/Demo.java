import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Even extends JFrame{
	private JTextArea evenNumArea;
	
	Even(){
		setSize(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Even");
		setLayout(new FlowLayout());
		setVisible(true);
		
		evenNumArea = new JTextArea();
		
		add(evenNumArea, BorderLayout.PAGE_START);
		
	}
	public void setEvn(int num){
		evenNumArea.append(num+"\n");
	}
	
}

class Odd extends JFrame{
	private JTextArea oddNumArea;
	
	Odd(){
		setSize(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Odd");
		setLayout(new FlowLayout());
		setVisible(true);
		
		oddNumArea = new JTextArea();
		
		add(oddNumArea, BorderLayout.PAGE_START);
	}
	public void setOdd(int num){
		oddNumArea.append(num+"\n");
	}	
	
}

class Palidrome extends JFrame{
	private JTextArea pldrmNumArea;
	
	Palidrome(){
		setSize(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Palidrome");
		setVisible(true);
		
		pldrmNumArea = new JTextArea();
		
		add(pldrmNumArea, BorderLayout.PAGE_START);
	}	
	public void setPali(int num){
		pldrmNumArea.append(num+"\n");
	}	
	
}

class Amstrone extends JFrame{
	private JTextArea amsNumArea;
	
	Amstrone(){
		setSize(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Amstrone");
		setLayout(new FlowLayout());
		setVisible(true);
		
		amsNumArea = new JTextArea();
		
		add(amsNumArea, BorderLayout.PAGE_START);
	}	
	public void setAmstron(int num){
		amsNumArea.append(num+"\n");
	}
	
}

class DisplayWindow extends JFrame{
	private JButton b1;
	private JButton b2;
	private JTextField txt1;
	private JPanel pnl1;
	private Amstrone amsNum;
	private Palidrome pliNum;
	private Odd oddNum;
	private Even evnNum;
	//String stp;
	
	{
		amsNum= new Amstrone();
		pliNum= new Palidrome();
		oddNum = new Odd();
		evnNum = new Even();
	}
	
	DisplayWindow(){
		
		setSize(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Display Window");
		
		txt1 = new JTextField();
		pnl1= new JPanel();
		
		b1= new JButton("Start");
		b2 = new JButton("Stop");
		
				
		/*b2.addActionListener((event) -> {
			stp.setText("Stop");
			
			txt1.setText("");
		});*/
		
		b1.addActionListener((event) -> {
			Random ran= new Random();
			
			new Thread() {
				public void run() {
					while(true) {
						try {
							Thread.sleep(1000);	
						}catch(Exception e){}
					
						//Code here
						int rndm = ran.nextInt(100001);
						System.out.println(rndm);
				
						if(rndm % 2 ==0){
							evnNum.setEvn(rndm);
						}else{
							oddNum.setOdd(rndm);
						}
		
						int temp = rndm;

						int newValue = 0;
		
						while(rndm != 0) {
							int remain = rndm % 10;
							newValue = (newValue*10) + remain;
							rndm /= 10;
						}
		
						if(temp == newValue) {
							pliNum.setPali(rndm);
						}
						
						
					}		
				}
			}.start();
			
			//txt1.setText("");
		});
		
		pnl1.add(b1);
		pnl1.add(b2);
		
		add(pnl1, BorderLayout.PAGE_END);
		add(txt1, BorderLayout.PAGE_START);
		
	}
	
}

class Demo{
	public static void main(String args[]){
		DisplayWindow displayWindow = new DisplayWindow();
		
		
		displayWindow.setVisible(true);
	}
}

