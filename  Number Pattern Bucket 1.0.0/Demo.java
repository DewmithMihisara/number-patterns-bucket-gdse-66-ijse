import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class NumObserver extends JFrame {
	public void update(int num) {}
}
class Even extends NumObserver{
	private JTextArea evenNumArea;
	
	Even(){
		setSize(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Even");
		setLayout(new FlowLayout());
		setVisible(true);
		
		evenNumArea = new JTextArea();
		
		add(evenNumArea, BorderLayout.CENTER);
		
	}
	@Override
	public void update(int num){
		evenNumArea.append(num+"\n");
	}
	
}

class Odd extends NumObserver{
	private JTextArea oddNumArea;
	
	Odd(){
		setSize(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Odd");
		setLayout(new FlowLayout());
		setVisible(true);
		
		oddNumArea = new JTextArea();
		
		add(oddNumArea, BorderLayout.CENTER);
	}
	@Override
	public void update(int num){
		oddNumArea.append(num+"\n");
	}
}

class DisplayWindow extends JFrame{
	private JButton b1;
	private JButton b2;
	private JTextField txt1;
	private JPanel pnl1;
	
	private NumberBucketControler numControler;
	
	DisplayWindow(NumberBucketControler numControler){
		this.numControler = numControler;
		
		setSize(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Display Window");
		
		txt1 = new JTextField();
		pnl1= new JPanel();
		
		b1= new JButton("Start");
		b2 = new JButton("Stop");
		
		b1.addActionListener((event) -> {
			Random ran= new Random();
			
			new Thread() {
				public void run() {
					while(true) {
						try {
							Thread.sleep(1000);	
						}catch(Exception e){}

						int rndm = ran.nextInt(100001);
						numControler.setNumber(rndm);
					}		
				}
			}.start();

		});
		
		pnl1.add(b1);
		pnl1.add(b2);
		
		add(pnl1, BorderLayout.PAGE_END);
		add(txt1, BorderLayout.PAGE_START);
	}
}
class NumberBucketControler {
	private Even evenWindow;
	private Odd oddWindow;
	
	private int number;

	public void setNumber(int number) {
		this.number = number;
		
		if(number%2==0){
			evenWindow.update(this.number);
		}else{
			oddWindow.update(this.number);
		}
		
	}

	public void setEven(Even evenWindow) {
		this.evenWindow = evenWindow;
	}
	public void setOdd(Odd oddWindow) {
		this.oddWindow = oddWindow;
	}
}

class Demo{
	public static void main(String[]args){
		NumberBucketControler numControler = new NumberBucketControler();
		
		numControler.setEven(new Even());
		numControler.setOdd(new Odd());
		
		new DisplayWindow(numControler).setVisible(true);
	}
}
