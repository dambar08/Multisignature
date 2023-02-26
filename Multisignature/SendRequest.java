

/****************************************************************/
/*                      SendRequest	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
/**
 * Summary description for SendRequest
 *
 */
public class SendRequest extends JFrame
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
	private JPasswordField password;
	private JComboBox grpinfo;
	private JTextArea textarea;
	private JScrollPane jScrollPane1;
	private JButton send;
	private JButton clear;
	private JButton exit;
	private JPanel contentPane;
	public String sender,sub,datas;
	public int c;
	public boolean flag=false;

	// End of variables declaration


	public SendRequest( )
	{
		super();
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
		subject.setFont(new Font("Garamond",Font.BOLD,15));
		mailid = new JTextField();
		mailid.setFont(new Font("Garamond",Font.BOLD,15));
		password = new JPasswordField();
		password.setFont(new Font("Garamond",Font.BOLD,15));
		grpinfo = new JComboBox();
		grpinfo.setFont(new Font("Garamond",Font.BOLD,15));
		grpinfo.addItem("Group 1");
		grpinfo.addItem("Group 2");
		textarea = new JTextArea();
		textarea.setFont(new Font("Garamond",Font.BOLD,15));
		jScrollPane1 = new JScrollPane();
		send = new JButton();
		clear = new JButton();
		exit = new JButton();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setIcon(new ImageIcon("images\\EULA.JPG"));
		//
		// jLabel5
		//
		jLabel5.setText("Send To");
		jLabel5.setFont(new Font("Garamond",Font.BOLD,15));
		//
		// jLabel6
		//
		jLabel6.setText("Subject");
		jLabel6.setFont(new Font("Garamond",Font.BOLD,15));

		jLabel3.setText("Give Your Id");
		jLabel3.setFont(new Font("Garamond",Font.BOLD,15));

		jLabel4.setText("Give Your Password");
		jLabel4.setFont(new Font("Garamond",Font.BOLD,15));
		//
		// subject
		//
		jLabel2.setText("Your Requisition...");
		jLabel2.setFont(new Font("Garamond",Font.BOLD,15));
		subject.setText("join");
		subject.setFont(new Font("Garamond",Font.BOLD,15));
		subject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				subject_actionPerformed(e);
			}

		});
		//
		// grpinfo
		//
		grpinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				grpinfo_actionPerformed(e);
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
		// send
		//
		send.setBackground(new Color(51, 51, 51));
		send.setForeground(new Color(255, 255, 255));
		send.setText("Send Request");
		send.setIcon(new ImageIcon("images\\submit.JPG"));
		send.setFont(new Font("Garamond",Font.BOLD,15));
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

					send_actionPerformed(e);

			}

		});
		//
		// clear
		//
		clear.setBackground(new Color(51, 51, 51));
		clear.setForeground(new Color(255, 255, 255));
		clear.setText("Clear Text");
		clear.setIcon(new ImageIcon("images\\clear.JPG"));
		clear.setFont(new Font("Garamond",Font.BOLD,15));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				clear_actionPerformed(e);
			}

		});
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
		contentPane.setBackground(new Color(12, 145, 244));
		addComponent(contentPane, jLabel1, 61,70,182,433);
		addComponent(contentPane, jLabel5, 277,80,60,24);
		addComponent(contentPane, jLabel6, 277,120,60,24);
		addComponent(contentPane, jLabel2, 277,240,200,24);
		addComponent(contentPane, jLabel3, 277,160,350,24);
		addComponent(contentPane, jLabel4, 277,200,350,24);
		addComponent(contentPane, subject, 360,120,172,22);
		addComponent(contentPane, mailid, 460,160,200,22);
		addComponent(contentPane, password, 460,200,200,22);
		addComponent(contentPane, grpinfo, 360,80,172,22);
		addComponent(contentPane, jScrollPane1, 277,280,571,167);
		addComponent(contentPane, send, 350,480,115,28);
		addComponent(contentPane, clear, 500,480,115,28);
		addComponent(contentPane, exit, 650,480,115,28);
		//
		// SendRequest
		//
		this.setTitle("Send Request Window");
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

	private void grpinfo_actionPerformed(ActionEvent e)
	{
		System.out.println("\ngrpinfo_actionPerformed(ActionEvent e) called.");

		Object o = grpinfo.getSelectedItem();
		System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected.");
		// TODO: Add any handling code here for the particular object being selected

	}

	private void send_actionPerformed(ActionEvent e)
	{
		System.out.println("\nsend_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		try
		{
				String gid;
				String grp = grpinfo.getSelectedItem().toString();
				sub=subject.getText().trim();
				String mail = mailid.getText().trim();
				String pass = password.getText().trim();
				if(grp.equalsIgnoreCase("Group 1"))
					gid="Group 1";
				else
					gid="Group 2";
				if(pass.length()>10)
					JOptionPane.showMessageDialog(this,"Give Your Password Within 10 Characters");
				else
				{
					DBClass db=new DBClass();
					int result = db.checkMailId(mail,gid);
					System.out.println("The Result "+result);
					if(result==1)
						JOptionPane.showMessageDialog(this,"Your Information is Already Avaliable...");
					else
					{
						datas=textarea.getText();	
						sendTo(mail,pass,gid,sub,datas);
					}
				}

		}
		catch(Exception ex)
		{
					JOptionPane.showMessageDialog(this,"Your Request is not send to the Group Controller");
					ex.printStackTrace();
		}
	}

	private void clear_actionPerformed(ActionEvent e)
	{
		System.out.println("\nclear_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		textarea.setText("");
		mailid.setText("");
		password.setText("");
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

	public void sendTo(String mailid,String pass,String gid,String subject,String msg)
	{
		try
		{
			DBClass db = new DBClass();
			String grpid="";
			if(gid.equalsIgnoreCase("Group 1"))
				grpid="G1Admin";
			else
				grpid="G2Admin";
			String ipadrs = db.getHostAdrs(grpid);
			System.out.println("The Admin IpAdrs = "+ipadrs);
			String usradrs = InetAddress.getLocalHost().toString();
			usradrs = usradrs.substring(0,usradrs.indexOf("/"));
			System.out.println("The User Ip Adrs = "+usradrs);
			Socket skt=new Socket(ipadrs,1000);
			DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
			String packet = mailid+"#"+pass+"#"+gid+"#"+subject+"#"+msg+"#"+usradrs;
			System.out.println(packet);
			dos.writeUTF(packet);
			DataInputStream dis = new DataInputStream(skt.getInputStream());
			String feedback = dis.readUTF();
			/*if(feedback.equalsIgnoreCase("Accepted"))
			{
				JOptionPane.showMessageDialog(this,"Your Requisition is Accepted. Login into the System");
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Your Requisition is Rejected");
			}*/
			dos.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Your Request is not send to the Group Controller");
		}
	}

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
		new SendRequest();
	}
//= End of Testing =


}

