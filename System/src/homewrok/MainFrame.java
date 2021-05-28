package homewrok;

//ģ�鹦�ܣ���¼�ɹ��Ժ���ʾ����ϵͳ�������棨��Ϊ����Ҫ���棩

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame implements ActionListener 
{
	MenuBar menubarxxx=new MenuBar();
	
	Menu menux1=new Menu("�û�����");
	Menu menux2=new Menu("������");
	Menu menux3=new Menu("��������");
	Menu menux4=new Menu("���۹���");
	Menu menux5=new Menu("ϵͳ�˳�");
	
	//�û�����
	MenuItem menuitemx101=new MenuItem("ɾ���û�");
	MenuItem menuitemx102=new MenuItem("�޸��û�");
	MenuItem menuitemx103=new MenuItem("��ѯ�û�");
	MenuItem menuitemx104=new MenuItem("����û�");
	
	//������
	MenuItem menuitemx201=new MenuItem("��ѯ���");
	MenuItem menuitemx202=new MenuItem("�޸Ŀ��");
	
	//��������
	MenuItem menuitemx301=new MenuItem("�»����");
	MenuItem menuitemx302=new MenuItem("����");
	
	//���۹���
	MenuItem menuitemx401=new MenuItem("���۹���");
	
	
	
	Menu menux6=new Menu("�˳�ϵͳ");
	MenuItem menuitem501=new MenuItem("����preview");
	MenuItem menuitem502=new MenuItem("����printOUT");

	public MainFrame()
	{
		super();
		menubarxxx.add(menux1);
		menubarxxx.add(menux2);
		menubarxxx.add(menux3);
		menubarxxx.add(menux4);
		menubarxxx.add(menux5);
		
		//�û�����
		menux1.add(menuitemx101);
		menux1.add(menuitemx102);
		menux1.add(menuitemx103);
		menux1.add(menuitemx104);
		
		menux1.add(menux6);
		
		menux6.add(menuitem501);
		menux6.add(menuitem502);
		
		//������
		menux2.add(menuitemx201);
		menux2.add(menuitemx202);
		
		//��������
		menux3.add(menuitemx301);
		menux3.add(menuitemx302);
		
		//���۹���
		menux4.add(menuitemx401);
		
		
		this.setMenuBar(menubarxxx);
		menuitem502.addActionListener(this); 
      //����ťע�����ť�¼��ļ�����
		menuitemx101.addActionListener(this); 
		menuitemx102.addActionListener(this); 
		menuitemx103.addActionListener(this); 
		menuitemx104.addActionListener(this);
		
		menuitemx201.addActionListener(this);
		menuitemx202.addActionListener(this);
		
		menuitemx301.addActionListener(this);
		menuitemx302.addActionListener(this);
		
		menuitemx401.addActionListener(this);
		
		menux3.addActionListener(this);
		menux4.addActionListener(this);

	 }
 public void actionPerformed(ActionEvent e) 
                            //����ť���º��ִ�з���
	  {
		if(e.getSource()==menuitem502){		
			System.out.println("�ɹ��ˣ�");
			System.exit(0);       //�˳���ǰ��������Ϣϵͳ
		}else if(e.getSource()==menuitemx101){				//ɾ���û�
			DeleteUserItemPanel deleteUserItemPanel=new DeleteUserItemPanel();
			
		}else if(e.getSource()==menuitemx102){				//�޸��û�
			UpdateUserItemPanel updateUserItemPanel=new UpdateUserItemPanel();
			
		}else if(e.getSource()==menuitemx103){				//��ѯ�û�
			Inquire inquire=new Inquire();
		}else if(e.getSource()==menuitemx104){				//����û�
			Regist regist = new Regist();
		}else if(e.getSource()==menuitemx201){				//��ѯ���
			InquireLibrary inquirelibrary = new InquireLibrary();
		}else if(e.getSource()==menuitemx202){				//�޸Ŀ��
			UpdateLibrary updatelibrary = new UpdateLibrary();
		}else if(e.getSource()==menuitemx301){				//�������
			Purchase purchase = new Purchase();
		}else if(e.getSource()==menuitemx302){				//����
			Replenishment replenishment = new Replenishment();
		}else if(e.getSource()==menuitemx401){				//����
			Sale sale = new Sale();
		}
		
	 }
}