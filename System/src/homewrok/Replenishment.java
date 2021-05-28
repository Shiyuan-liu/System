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


public class Replenishment extends JFrame implements ActionListener{
	private JLabel idLabel,nameLabel,libraryLabel;
	private JTextField idField,nameField,libraryField;
	private JButton indexButton,submitButton;
  
    public Replenishment(){
    	super();
		this.setSize(700, 700);
		this.setTitle("����");
		this.setLocation(700,250);
		this.setVisible(true);
		this.setResizable(true);
		init();
	   }
	
	  private void init(){
			idLabel=new JLabel("���:");
			nameLabel=new JLabel("���˻�����:");
			libraryLabel=new JLabel("������:");
			
			
			idField=new JTextField(24);
			nameField=new JTextField(24);
			libraryField=new JTextField(24);
			
			
		  indexButton = new JButton("��ѯ");
		  submitButton = new JButton("����");
		

		//���ݴ���Ĭ�ϲ��ֹ�������FlowLayout
		this.setLayout(null);
		this.add(idLabel).setBounds(40, 40, 80, 30);
		this.add(idField).setBounds(100, 40, 80, 30);
		this.add(nameLabel).setBounds(40, 100, 80, 30);
		this.add(nameField).setBounds(100, 100, 80, 30);
		this.add(libraryLabel).setBounds(40, 160, 80, 30);
		this.add(libraryField).setBounds(100, 160, 80, 30);
		this.add(indexButton).setBounds(40, 460, 60, 25);	
		this.add(submitButton).setBounds(120, 460, 60, 25);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		indexButton.addActionListener(this);	
		submitButton.addActionListener(this);
	  }
	
	 public void indexButton_actionPerformed(){
		String Id=idField.getText().trim();

		String url = "jdbc:mysql://localhost:3306/book";		
		Connection con=null;		
		ResultSet rs = null;
		Statement smt = null;
			 try{
				  Class.forName("com.mysql.jdbc.Driver");
				  con = DriverManager.getConnection(url, "root", "123456");
				  //System.out.println(rs.getString("name"));
			      if(con == null){
			    	  JOptionPane.showMessageDialog(this, "���ݿ����Ӵ���", "warning", JOptionPane.WARNING_MESSAGE);
				      con.close();
			      }else{
			      //System.out.println(rs.getString("phone"));
					String sql="select * from book where id= '"+Id+"' ";
					smt=con.createStatement();
					rs=smt.executeQuery(sql);	
					while(rs.next()){
						nameField.setText(rs.getString("name"));
						libraryField.setText(rs.getString("library"));
						
					}

			      }
			      
			 }catch(Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(this, "���ݿ����Ӵ���", "warning", JOptionPane.WARNING_MESSAGE);
				}
	 }
	 
	 public void submitButton_actionPerformed() {
			String Id=idField.getText().trim();
			String name=nameField.getText().trim();
			String library=libraryField.getText().trim();
			int surplus=Integer.parseInt(library);
			String url = "jdbc:mysql://localhost:3306/book";
			
			Connection con=null;	
			PreparedStatement ps = null;		
			ResultSet rs = null;
			Statement sta = null;
			
			if(Id.equals("") ||name.equals("") ||library.equals("")){
				JOptionPane.showMessageDialog(this, "���Ӵ���", "warning", JOptionPane.WARNING_MESSAGE);
			}else{
				 try{
					  Class.forName("com.mysql.jdbc.Driver");
					  con = DriverManager.getConnection(url, "root", "123456");
				      if(con == null){
					      JOptionPane.showMessageDialog(this, "�����Ӵ���", "warning", JOptionPane.WARNING_MESSAGE);
					      con.close();
				 }else{

						//String sql1="select library from book where id='"+Id+"'";
						String sql2="update book set  library = library + ? where id=?";
						ps =  con.prepareStatement(sql2);

						//System.out.println(a);
						ps.setInt(1, surplus);
						ps.setString(2,Id);
						ps.executeUpdate();
						
				 }}catch(Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(this, "���ݿ����Ӵ���", "warning", JOptionPane.WARNING_MESSAGE);
					}
				}			
		}

	
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == indexButton){
			indexButton_actionPerformed();
		}
		if(e.getSource() ==submitButton){
			submitButton_actionPerformed();
			JOptionPane.showMessageDialog(null, "�����ɹ�");
		}
	}
}

