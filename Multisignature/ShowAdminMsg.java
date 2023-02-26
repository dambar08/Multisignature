

/****************************************************************/
/*                      Admin Message                           */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.math.BigInteger;
import java.net.*;
import java.io.*;
import java.util.*;
/**
 * Summary description for SendRequest
 *
 */
public class ShowAdminMsg extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JTextField subject;
	private JTextField mailid;
	private JTextField password;
	private JTextArea textarea;
	private JScrollPane jScrollPane1;
	private JButton accept;
	//private JButton tree;
	private JButton exit;
	private JPanel contentPane;
	public String sender,sub,datas;
	public int c;
	public boolean flag=false;
	private String mail,pass,msg,gid,usradrs;
	AddImpl obj; 
	DBClass db;
	public static String tableName = "";
	// End of variables declaration


	public ShowAdminMsg(String mail,String pass,String gid,String subject,String msg,String usradrs) throws Exception
	{
		super();
		this.mail = mail;
		this.pass = pass;
		this.msg = msg;
		this.gid = gid;
		this.usradrs = usradrs;
		sub = subject;
		initializeComponent();
		flag=true;
		db = new DBClass();
		//
		// TODO: Add any constructor code after initializeComponent call
		//

		this.setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always regenerated
	 * by the Windows Form Designer. Otherwise, retrieving design might not work properly.
	 * Tip: If you must revise this method, please backup this GUI file for JFrameBuilder
	 * to retrieve your design properly in future, before revising this method.
	 */
	private void initializeComponent()throws Exception
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		subject = new JTextField();
		subject.setFont(new Font("Garamond",Font.BOLD,15));
		mailid = new JTextField();
		mailid.setFont(new Font("Garamond",Font.BOLD,15));
		mailid.setText(mail);
		password = new JTextField();
		password.setFont(new Font("Garamond",Font.BOLD,15));
		password.setText(pass);
		textarea = new JTextArea();
		textarea.setFont(new Font("Garamond",Font.BOLD,15));
		textarea.setText(msg);
		jScrollPane1 = new JScrollPane();
		accept = new JButton();
		//tree = new JButton();
		exit = new JButton();
		contentPane = (JPanel)this.getContentPane();
		//
		// jLabel1
		//
		jLabel1.setIcon(new ImageIcon("images\\EULA.JPG"));
		//
		// jLabel6
		//
		jLabel6.setText("Subject");
		jLabel6.setFont(new Font("Garamond",Font.BOLD,15));

		jLabel3.setText("Sender User Id");
		jLabel3.setFont(new Font("Garamond",Font.BOLD,15));

		jLabel4.setText("Sender Password");
		jLabel4.setFont(new Font("Garamond",Font.BOLD,15));
		//
		// subject
		//
		jLabel2.setText("Sender Requisition...");
		jLabel2.setFont(new Font("Garamond",Font.BOLD,15));
		subject.setText(sub);
		subject.setFont(new Font("Garamond",Font.BOLD,15));
		subject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				subject_actionPerformed(e);
			}

		});
		//
		// textarea
		//
		//
		// jScrollPane1
		//
		jScrollPane1.setViewportView(textarea);
		//
		// accept
		//
		accept.setBackground(new Color(51, 51, 51));
		accept.setForeground(new Color(255, 255, 255));
		accept.setText("Send Request");
		accept.setIcon(new ImageIcon("images\\ok.JPG"));
		accept.setFont(new Font("Garamond",Font.BOLD,15));
		accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

					accept_actionPerformed(e);

			}

		});
		//
		// clear
		//
//		tree.setBackground(new Color(51, 51, 51));
//		tree.setForeground(new Color(255, 255, 255));
//		tree.setText("Tree View");
//		tree.setIcon(new ImageIcon("E:\\Signature\\signature\\images\\tree.JPG"));
//		tree.setFont(new Font("Garamond",Font.BOLD,15));
//		tree.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e)
//			{
//				tree_actionPerformed(e);
//			}

		//});
		//
		// exit
		//
		exit.setBackground(new Color(51, 51, 51));
		exit.setForeground(new Color(255, 255, 255));
		exit.setText("Back");
		exit.setIcon(new ImageIcon("images\\back.JPG"));
		exit.setFont(new Font("Garamond",Font.BOLD,15));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				exit_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(245, 245, 245));
		addComponent(contentPane, jLabel1, 61,70,182,433);
		addComponent(contentPane, jLabel5, 277,80,60,24);
		addComponent(contentPane, jLabel6, 277,120,60,24);
		addComponent(contentPane, jLabel2, 277,240,200,24);
		addComponent(contentPane, jLabel3, 277,160,350,24);
		addComponent(contentPane, jLabel4, 277,200,350,24);
		addComponent(contentPane, subject, 360,120,172,22);
		addComponent(contentPane, mailid, 460,160,200,22);
		addComponent(contentPane, password, 460,200,200,22);
		addComponent(contentPane, jScrollPane1, 277,280,571,167);
		addComponent(contentPane, accept, 350,480,115,28);
		//addComponent(contentPane, tree, 500,480,115,28);
		addComponent(contentPane, exit, 500,480,115,28);
		//
		// acceptRequest
		//
		this.setTitle("Admin Message Window");
		this.setLocation(new Point(50, 100));
		this.setSize(new Dimension(912, 600));
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	//
	// TODO: Add any appropriate code in the following Event Handling Methods
	//
	private void subject_actionPerformed(ActionEvent e)
	{
		System.out.println("\nsubject_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void accept_actionPerformed(ActionEvent e)
	{
		System.out.println("\naccept_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		try
		{
			if(sub.equalsIgnoreCase("Join"))
			{
				System.out.println("Refer the Group Key Method");
				int res = db.addMember(mail,pass,gid);
				if(res==1)
					System.out.println("Values r inserted in the Database");
				else
					System.out.println("The Values r not Inserted into the Database");
				
				boolean flag = db.assignKeys(mail,pass,usradrs,gid);
				GroupKey();
				if(flag)
				{
					System.out.println("The User Requisition is Accepted");
					JOptionPane.showMessageDialog(this,"Your Information is Added into the Group");
				}
				else
				{
					System.out.println("The User Requisition is Rejected");
					JOptionPane.showMessageDialog(this,"Your Information is not Added into the Group");
				}
			}
			else
			{
				DBClass db = new DBClass();
		        if(gid.equalsIgnoreCase("Group 1")){
					tableName = "tree1";
				}
				else{
					tableName = "tree2";
				}
				System.out.println("The Selected Group Table = "+tableName);
				obj= new AddImpl();
				obj.deleteMember(mail);
				GenerateKey gkey=new GenerateKey();
				//Thread.sleep(1000);
		        boolean flag = db.removeUser(mail,gid);
				if(flag)
				{
					System.out.println("The User Requisition is Accepted");
					JOptionPane.showMessageDialog(this,"Your Information is Removed from the Group");
				}
				else
				{
					System.out.println("The User Requisition is Rejected");
					JOptionPane.showMessageDialog(this,"Your Information is Not Removed from the Group");
				}
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception : "+ex);
		}
		
		
	}

//	private void tree_actionPerformed(ActionEvent e)
//	{
//		System.out.println("\ntree_actionPerformed(ActionEvent e) called.");
//		// TODO: Add any handling code here
//		/*textarea.setText("");
//		mailid.setText("");
//		password.setText("");*/
//		//new UsersTreeView();
//
//	}

	private void exit_actionPerformed(ActionEvent e)
	{
		System.out.println("\nexit_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		setVisible(false);
		 	}



	public void GroupKey()throws Exception
	{
	
		String user=mailid.getText().trim();
		String pass1=password.getText().trim();
		if(gid.equalsIgnoreCase("Group 1")){
			tableName = "tree1";
		}
		else{
			tableName = "tree2";
		}
		System.out.println("The Selected Group Table = "+tableName);
		obj= new AddImpl();
		//System.out.println("The Mail Id = "+user+" and Password = "+pass1);
		int treecount=obj.getMembers("select members from "+tableName+" where s1 is null and s2 is null");
		System.out.println("The Tree Count = "+treecount);
		String query1="update "+tableName+" set memname ='"+user+"', pass ='"+pass1+"' where members="+treecount;
		System.out.println(query1);

		String grkey="";
		try
		{
			//long start = System.currentTimeMillis();
			obj.dataUpdate(query1);	
			//Thread.sleep(1000);

			GenerateKey gk=new GenerateKey();
			//long end = System.currentTimeMillis();
			//Thread.sleep(1000);
			
			String getgroupkey="select grpkey from "+tableName;
			Iterator it=obj.getGroupKey(getgroupkey).iterator();
			if(it.hasNext())
			{
				grkey=(String)it.next();
				System.out.println("The Group Key = "+grkey);
			}
		}
		catch (Exception e1)
		{
			System.out.println("Exception :"+e1);
		}
	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//

	//============================= Testing ================================//
	//=                                                                    =//
	//= The following main method is just for testing this class you built.=//
	//= After testing,you may simply delete it.                            =//
	//======================================================================//
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		//new ShowAdminMsg();
	}
//= End of Testing =


}

