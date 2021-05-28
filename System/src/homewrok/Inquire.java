package homewrok;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Inquire extends JFrame implements ActionListener{
	private JLabel idLabel,nameLabel,passwordLabel,ageLabel,sexLabel,phoneLabel,addressLabel;
	private JTextField idField,nameField,passwordField,ageField,sexField,phoneField,addressField;	
	private JButton indexButton,delButton;
  
    public Inquire(){
	    super();
	    this.setSize(280,560);
	    this.setTitle("��ѯ�û�");
		this.setVisible(true);
		this.setResizable(true);
		/*this.setDefaultCloseOperation(EXIT_ON_CLOSE);//�رս���ʱ�˳�JVM�����
		addWindowListener(new WindowAdapter(){       //����رս���Ĳ��ʱ����ѯ�ʴ���
			  public void windowClosing(WindowEvent e){
				int n=JOptionPane.showConfirmDialog(null, "Are you sure closing this software?","warning",JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION)
					System.exit(0);
			  }
		 });*/
		  init();
	   }
	
	  private void init(){
		idLabel=new JLabel("�û�id:");
		nameLabel=new JLabel("�û���:");
		passwordLabel=new JLabel("��  ��:");
		ageLabel=new JLabel("��  ��:");
		sexLabel=new JLabel("��  ��:");
		phoneLabel=new JLabel("��  ��:");
		addressLabel=new JLabel("��  ַ:");
		
		idField=new JTextField(24);
		nameField=new JTextField(24);
		passwordField=new JTextField(24);
		ageField=new JTextField(24);
		sexField=new JTextField(24);
		phoneField=new JTextField(24);
		addressField=new JTextField(24);
		
		indexButton=new JButton("��ѯ");				

		//���ݴ���Ĭ�ϲ��ֹ�������FlowLayout
		this.setLayout(null);
		this.add(idLabel).setBounds(40, 40, 80, 30);
		this.add(idField).setBounds(100, 40, 80, 30);
		this.add(nameLabel).setBounds(40, 100, 80, 30);
		this.add(nameField).setBounds(100, 100, 80, 30);
		this.add(passwordLabel).setBounds(40, 160, 80, 30);
		this.add(passwordField).setBounds(100, 160, 80, 30);
		this.add(ageLabel).setBounds(40, 220, 80, 30);
		this.add(ageField).setBounds(100, 220, 80, 30);
		this.add(sexLabel).setBounds(40, 280, 80, 30);
		this.add(sexField).setBounds(100, 280, 80, 30);
		this.add(phoneLabel).setBounds(40, 340, 80, 30);
		this.add(phoneField).setBounds(100, 340, 80, 30);
		this.add(addressLabel).setBounds(40, 400, 80, 30);
		this.add(addressField).setBounds(100, 400, 80, 30);
		
		this.add(indexButton).setBounds(100, 460, 60, 25);		
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setVisible(true);
		
		indexButton.addActionListener(this);
		delButton.addActionListener(this);		
	  }
	
	 public void indexButton_actionPerformed(){
		String userId=idField.getText().trim();

		String url = "jdbc:mysql://localhost:3306/usr_01";		
		Connection con=null;		
		ResultSet rs = null;
		Statement smt = null;
			 try{
				  Class.forName("com.mysql.jdbc.Driver");
				  con = DriverManager.getConnection(url, "root", "123456");
				  //System.out.println(rs.getString("name"));
			      if(con == null){
				      JOptionPane.showMessageDialog(this, "�������ӳ������Ժ�����", "warning", JOptionPane.WARNING_MESSAGE);
				      con.close();
			      }else{
			      //System.out.println(rs.getString("phone"));
					String sql="select * from usr where id='"+userId+"' ";
					smt=con.createStatement();
					rs=smt.executeQuery(sql);	
					while(rs.next()){
						nameField.setText(rs.getString("name"));
						passwordField.setText(rs.getString("password"));
						ageField.setText(String.valueOf(rs.getInt("age")));
						sexField.setText(rs.getString("sex"));
						phoneField.setText(rs.getString("phone"));
						addressField.setText(rs.getString("address"));
					}
					//System.out.println(rs.getString("name"));
					//System.out.println(rs.getString("age"));
					//System.out.println(rs.getString("phone"));
			      }
			      con.close();
			      smt.close();
			      rs.close();
			 }catch(Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(this, "�������ӳ������Ժ�����", "warning", JOptionPane.WARNING_MESSAGE);
				}
	 }
	
	public void delButton_actionPerformed() {
		
		String userId=idField.getText().trim();
		String url = "jdbc:mysql://localhost:3306/usr_01";		
		Connection con=null;		
		ResultSet rs = null;
		Statement smt = null;
		 try{
			  Class.forName("com.mysql.jdbc.Driver");
			  con = DriverManager.getConnection(url, "root", "123456");
		      if(con == null){
			      JOptionPane.showMessageDialog(this, "�������ӳ������Ժ�����", "warning", JOptionPane.WARNING_MESSAGE);
			      con.close();
		      }else{
		  		String sssql="delete  from usr where id='"+userId+"' ";
				smt=con.createStatement();
				int k=smt.executeUpdate(sssql);	
		      }
		 }catch(Exception e){}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == indexButton){
			indexButton_actionPerformed();
		}else if(e.getSource() == delButton){
			delButton_actionPerformed();
		}
	}
}
