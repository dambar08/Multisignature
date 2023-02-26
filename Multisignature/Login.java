

/****************************************************************/
/*                      GrpLogin	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * Summary description for GrpLogin
 *
 */
public class Login extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel login;
	private JComboBox grpinfo;
	private JTextField userid;
	private JPasswordField sctkey;

	private JSeparator jSeparator1;
	private JLabel signup;
	private JPanel contentPane;
	DBClass db=new DBClass();
	// End of variables declaration


	public Login()
	{
		super();
		initializeComponent();
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
		jLabel7 = new JLabel();
		jLabel8 = new JLabel();
		grpinfo = new JComboBox();
		grpinfo.setFont(new Font("Garamond",Font.BOLD,15));
		grpinfo.addItem("Group 1");
		grpinfo.addItem("Group 2");
		login = new JLabel();
		userid = new JTextField();
		userid.setFont(new Font("Garamond",Font.BOLD,15));
		sctkey = new JPasswordField();
		sctkey.setFont(new Font("Garamond",Font.BOLD,15));
		jSeparator1 = new JSeparator();
		signup = new JLabel();
	
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel1.setText("Login Information");
		jLabel1.setForeground(new Color(0, 0, 0));
		jLabel1.setFont(new Font("Garamond",Font.BOLD,30));
		jLabel2.setText("Existing Users");
		jLabel2.setFont(new Font("Garamond",Font.BOLD,20));
		jLabel2.setForeground(new Color(0, 0, 0));
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
		// jLabel3
		//
		jLabel3.setText("User ID ");
		jLabel3.setForeground(new Color(0, 0, 0));
		jLabel3.setFont(new Font("Garamond",Font.BOLD,15));
		//
		// jLabel4
		//
		jLabel4.setText("Password ");
		jLabel4.setForeground(new Color(0, 0, 0));
		jLabel4.setFont(new Font("Garamond",Font.BOLD,15));
		
		jLabel7.setText("Group ");
		jLabel7.setForeground(new Color(0, 0, 0));
		jLabel7.setFont(new Font("Garamond",Font.BOLD,15));
		
		//
		// jLabel5
		//
		jLabel5.setIcon(new ImageIcon("images\\signature.jpg"));
		jLabel8.setIcon(new ImageIcon("images\\handsign.jpg"));
		jLabel6.setText("New Users");
		jLabel6.setForeground(new Color(0, 0, 0));
		jLabel6.setFont(new Font("Garamond",Font.BOLD,20));
		
		//
		// login
		//
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setIcon(new ImageIcon("images\\signin.JPG"));
		login.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				login_mouseClicked(e);
			}

		});
		
		//
		// userid
		//
		userid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				userid_actionPerformed(e);
			}

		});
		//
		// sctkey
		//
		sctkey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sctkey_actionPerformed(e);
			}

		});
		//
		// jSeparator1
		//
		//
		// jButton1
		//
		signup.setIcon(new ImageIcon("images\\signup.JPG"));
		signup.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				signup_mouseClicked(e);
			}

		});
		
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEtchedBorder());
		contentPane.setBackground(new Color(245, 245, 245));
		addComponent(contentPane, jLabel1, 50,0,453,40);
		addComponent(contentPane, jLabel2, 50,50,350,40);
		addComponent(contentPane, jLabel3, 50,100,310,18);
		addComponent(contentPane, jLabel4, 50,145,300,18);
		addComponent(contentPane, jLabel7, 50,195,300,18);
		addComponent(contentPane, jLabel5, 350,50,200,200);
		addComponent(contentPane, jLabel8, 0,320,600,100);
		addComponent(contentPane, jLabel6, 50,275,350,40);
		addComponent(contentPane, login, 155,235,140,27);
		addComponent(contentPane, grpinfo, 125,190,160,22);
		addComponent(contentPane, userid, 125,100,158,22);
		addComponent(contentPane, sctkey, 125,145,158,22);
		addComponent(contentPane, jSeparator1,0,270,626,23);
		addComponent(contentPane, signup, 160,280,140,28);
		
		
		// GrpLogin
		//
		this.setTitle("Login Window Page");
		this.setLocation(new Point(75, 100));
		this.setSize(new Dimension(635, 480));
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
	private void grpinfo_actionPerformed(ActionEvent e)
	{
		System.out.println("\ngrpinfo_actionPerformed(ActionEvent e) called.");

		Object o = grpinfo.getSelectedItem();
		System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected.");
		// TODO: Add any handling code here for the particular object being selected

	}
	
	private void login_mouseClicked(MouseEvent e)
	{
		System.out.println("\nlogin_mouseClicked(MouseEvent e) called.");
		// TODO: Add any handling code here
		try
				{
				String id=userid.getText();
				char k[]=sctkey.getPassword();
				String key=new String(k);
				String gid = grpinfo.getSelectedItem().toString();
				System.out.println("The User Id = "+id+" and Password = "+key+" and Grp Id = "+gid);
				int result=db.getResult(id, key,gid);
				System.out.println("The Result = "+result);
				if(result==1)
				{
					new ComposeMsg(id,gid);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please Enter Your ID or Password Correctly");
				}
				}
				catch(Exception ex)
				{
					System.out.println("Error in Logging..."+ex);
				}
	}
	private void userid_actionPerformed(ActionEvent e)
	{
		System.out.println("\nuserid_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void sctkey_actionPerformed(ActionEvent e)
	{
		System.out.println("\nsctkey_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}
	private void signup_mouseClicked(MouseEvent e)
	{
		System.out.println("\nlogin_mouseClicked(MouseEvent e) called.");
		// TODO: Add any handling code here
		new SendRequest();
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
			//System.out.println(ex);
			ex.printStackTrace();
		}
		new Login();
	}
//= End of Testing =


}
