import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

public class TicTacToe {
	static int a;
	boolean ture=true;
	boolean win = false;
	int count = 9;
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton[] b = new JButton[9];
	//---------------------------
    Box box=Box.createHorizontalBox();    
    JButton btnA=new JButton("Play game");    
    JButton btnB=new JButton("NO"); 
    JButton btnC=new JButton(); 
    //------------------------
	ImageIcon img1,img2;
	
	public static void main(String[] args) {

		new TicTacToe().init();
	}
	public void init(){	
		img1 = new ImageIcon("1.jpg");
		img2 = new ImageIcon("2.jpg");
		p.setLayout(new GridLayout (3,3));
		for(int i =0; i<b.length;i++){
			b[i] = new JButton();
			addListener(b[i],btnA,btnB,i);
			p.add(b[i]);
		f.add(p);
		f.setSize(300,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	}
	
	public void addListener(JButton b,JButton btnA,JButton btnB,int i){
	//我做的------------------------------------------------
			btnA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(b.getIcon()==img1||b.getIcon()==img2){											
						b.setIcon(ture?null:null);
						ture=!ture;		
						count = 9;
					}
				
			}
			
			});
		btnB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
			});
		//----------------------------
		
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
		
				if(b.getIcon()==null){
				
				b.setIcon(ture?img1:img2);
				ture=!ture;
				
				}
				win = checWin(i);
				count--;
				//----------------------------------
				if(count==0){    
			        JFrame f=new JFrame("BoxLayout");    
			        //创建水平Box组件     
			        Box box=Box.createHorizontalBox();   
			        box.add(btnA);
			        box.add(btnB); 
			        f.add(box);
			        f.pack();    
			        f.setVisible(true);    
			        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else{
					if(win == true){
						if(ture!=true){
					        JFrame f=new JFrame("BoxLayout");    
					        //创建水平Box组件     
					        Box box=Box.createHorizontalBox();     
					        btnC=new JButton("O win");    
					        box.add(btnA);
					        box.add(btnB); 
					        box.add(btnC); 
					        f.add(box);
					        f.pack();    
					        f.setVisible(true);    
					        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}
						else{
					        JFrame f=new JFrame("BoxLayout");    
					        //创建水平Box组件     
					        Box box=Box.createHorizontalBox();   
					        btnC=new JButton("X win");   
					        box.add(btnA);
					        box.add(btnB); 
					        box.add(btnC); 
					        f.add(box);
					        f.pack();    
					        f.setVisible(true);    
					        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}
					}
					//-------------------------------------------------
					

				}

			
			}
			
			});		
		}


		public boolean checWin(int i){
			boolean w = false;
			int r = i/3;
			int c = i%3;
			if(b[r*3].getIcon()==b[r*3+1].getIcon()&&b[r*3+1].getIcon()==b[r*3+2].getIcon()){
					w=true;
			}
			else if(b[0*3+c].getIcon()==b[1*3+c].getIcon()&&b[1*3+c].getIcon()==b[2*3+c].getIcon()){
					w = true;
			}
			else if(i%2==0){
				if(b[0].getIcon()==b[4].getIcon()&&b[4].getIcon()==b[8].getIcon()&&b[0].getIcon()!=null){
					w = true;				
				}
				else{
					if(b[2].getIcon()==b[4].getIcon()&&b[4].getIcon()==b[6].getIcon()&&b[2].getIcon()!=null)
					w = true;	
				}
			}
			return w;	
		}
		
}