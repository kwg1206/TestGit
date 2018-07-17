import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Project {
	JFrame frame = new JFrame();
	JPanel p_center = new JPanel();
	JCheckBoxMenuItem menu1 = new JCheckBoxMenuItem("ÏãÀ±¼¦ÍÈºº±¤",false);
	JCheckBoxMenuItem menu2 = new JCheckBoxMenuItem("°Â¶ûÁ¼¼¦ÍÈºº±¤",false);

	TextField num = new TextField(10);//ÊäÈë¿ò
	JPanel p_south = new JPanel();
	JTextArea tArea = new JTextArea(4,15);//ÏÔÊ¾¿ò
	JScrollPane scrollPane = new JScrollPane(tArea);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Project().init();

	}
	private void init() {
		JButton button = new JButton("OK");
		p_center.add(menu1);
		p_center.add(menu2);
		frame.add(p_center,BorderLayout.CENTER);
		p_south.add(num);
		p_south.add(button);
		frame.add(p_south, BorderLayout.SOUTH);
		frame.add(scrollPane, BorderLayout.NORTH);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String n = num.getText();
				String menu = menu1.isSelected()?"ÏãÀ±¼¦ÍÈ±¤":""; 
				String menuo = menu2.isSelected()?"°Â¶ûÁ¼¼¦ÍÈ±¤":""; 
				if(menu.equals("ÏãÀ±¼¦ÍÈ±¤")){
				tArea.append(n+"¸ö         "+menu+"\n");
				}else {
					menu="°Â¶ûÁ¼¼¦ÍÈ±¤";
				}
				if(menu.equals("°Â¶ûÁ¼¼¦ÍÈ±¤")){
				tArea.append(n+"¸ö       "+menuo+"\t");
				}
			}
		});

		frame.setSize(200, 400);;
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
