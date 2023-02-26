

/****************************************************************/
/*                      SendRequest	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.math.BigInteger;
import java.net.*;
import java.io.*;
/**
 * Summary description for SendRequest
 *
 */
public class ShowMessage extends JFrame
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
	//private JButton clear;
	private JButton exit;
	private JPanel contentPane;
	public String sender,sub,datas;
	public int c;
	public boolean flag=false;
	private String mail,pass,gid,message,usradrs;
	// End of variables declaration


	public ShowMessage(String sender,String gid,String subject,String msg,String key)
	{
		super();
		this.sender = sender;
		this.gid = gid;
		sub = subject;
		message = msg;
		initializeComponent();
		flag=true;
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
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		subject = new JTextField();
		mailid = new JTextField();
		mailid.setFont(new Font("Garamond",Font.BOLD,15));
		mailid.setText(sender);
		password = new JTextField();
		password.setFont(new Font("Garamond",Font.BOLD,15));
		password.setText(gid);
		textarea = new JTextArea();
		textarea.setFont(new Font("Garamond",Font.BOLD,15));
		textarea.setText(message);
		jScrollPane1 = new JScrollPane();
		accept = new JButton();
		//clear = new JButton();
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

		jLabel3.setText("Sender Information");
		jLabel3.setFont(new Font("Garamond",Font.BOLD,15));

		jLabel4.setText("Sender Group Name");
		jLabel4.setFont(new Font("Garamond",Font.BOLD,15));
		//
		// subject
		//
		jLabel2.setText("Sender Information...");
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
		/*clear.setBackground(new Color(51, 51, 51));
		clear.setForeground(new Color(255, 255, 255));
		clear.setText("Clear Text");
		clear.setIcon(new ImageIcon("E:\\Haja\\Signature\\bin\\signature\\images\\clear.JPG"));
		clear.setFont(new Font("Garamond",Font.BOLD,15));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				clear_actionPerformed(e);
			}

		});*/
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
		//addComponent(contentPane, clear, 500,480,115,28);
		addComponent(contentPane, exit, 500,480,115,28);
		//
		// acceptRequest
		//
		this.setTitle("Message Window");
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
		setVisible(false);
		
	}

	private void exit_actionPerformed(ActionEvent e)
	{
		System.out.println("\nexit_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		setVisible(false);
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
	}
//= End of Testing =


}

