package homewrok;
	import java.awt.Frame;
	import java.awt.Menu;
	import java.awt.MenuBar;
	import java.awt.MenuItem;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.Icon;
	import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	public class Test extends JFrame implements ActionListener 
	{
		MenuBar menubarxxx=new MenuBar();
		
		Menu menux1=new Menu("File");
		Menu menux2=new Menu("Edit");
		Menu menux3=new Menu("save");
		Menu menux4=new Menu("exit");
		
		MenuItem menuitemx101=new MenuItem("open");
		MenuItem menuitemx102=new MenuItem("close");
		MenuItem menuitemx103=new MenuItem("find");
		
		Menu menux5=new Menu("print");
		MenuItem menuitem501=new MenuItem("preview");
		MenuItem menuitem502=new MenuItem("printOUT");

		public Test()
		{
			super();
			menubarxxx.add(menux1);
			menubarxxx.add(menux2);
			menubarxxx.add(menux3);
			menubarxxx.add(menux4);
			
			menux1.add(menuitemx101);
			menux1.add(menuitemx102);
			menux1.add(menuitemx103);
			
			menux1.add(menux5);
			
			menux5.add(menuitem501);
			menux5.add(menuitem502);
			
			this.setMenuBar(menubarxxx);
			menuitem502.addActionListener(this); 
	        //����ťע�����ť�¼��ļ�����
		 }
	   public void actionPerformed(ActionEvent e) 
	                              //����ť���º��ִ�з���
		  {
			System.out.println("�ɹ��ˣ�");
			System.exit(0);       //�˳���ǰ��������Ϣϵͳ
		  }
	   public static void main(String args[])
		 {
		    Icon picture1=new ImageIcon("b1.JPG");	   
		    JLabel logo=new JLabel();		
		    logo.setIcon(picture1);
		    JFrame f=new Test();
			f.setSize(700, 300);
			f.add(logo);
		    f.show();
	 }	
}
