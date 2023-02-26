

/****************************************************************/
/*                      Compose Message                         */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.net.*;
import java.sql.*;
import java.io.*;
import java.util.StringTokenizer;
import java.awt.event.*;

import javax.swing.*;
/**
 * Summary description for ComposeMsg
 *
 */
public class ComposeMsg extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JLabel label;
	private JLabel jLabel5;
	private JComboBox grpinfo;
	private JTextField sendto;
	private JTextField subject;
	private JTextArea textarea;
	private JScrollPane jScrollPane1;
	private JButton send;
	private JButton sendtoall;
	private JButton clear;
	private JButton tree;
	private JPanel contentPane;
	private String gid,id,grpid;
	private String to,sub;
	FileInputStream fin;
	Socket skt, skt1;
	Connection con;
	Statement st;
	ResultSet rs;
	
	// End of variables declaration

	public ComposeMsg(String uid, String gid)
	{
		super();
		id = uid;
		this.gid = gid;
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:signature","","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Database Connectivity Error "+e);
		}
		
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
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		label=new JLabel();
		sendto = new JTextField();
		sendto.setFont(new Font("Garamond",Font.BOLD,15));
		subject = new JTextField();
		subject.setFont(new Font("Garamond",Font.BOLD,15));
		textarea = new JTextArea();
		textarea.setFont(new Font("Garamond",Font.BOLD,15));
		grpinfo = new JComboBox();
		grpinfo.setFont(new Font("Garamond",Font.BOLD,15));
		grpinfo.addItem("Group 1");
		grpinfo.addItem("Group 2");
		jScrollPane1 = new JScrollPane();
		send = new JButton();
		sendtoall = new JButton();
		clear = new JButton();
		tree = new JButton();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setIcon(new ImageIcon("images\\EULA.JPG"));
		//
		// jLabel4
		//
		label.setText("Subject");
		label.setFont(new Font("Garamond",Font.BOLD,15));
		jLabel5.setText("Send To");
		jLabel5.setFont(new Font("Garamond",Font.BOLD,15));
		jLabel2.setText("Select Group");
		jLabel2.setFont(new Font("Garamond",Font.BOLD,15));
		jLabel4.setText("Your Message...");
		jLabel4.setFont(new Font("Garamond",Font.BOLD,15));
		//
		// sendto
		//
		sendto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sendto_actionPerformed(e);
			}

		});
		//
		// subject
		//
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
		// jScrollPane1
		//
		jScrollPane1.setViewportView(textarea);
		jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//
		// send
		//
		send.setIcon(new ImageIcon("images\\sendto.JPG"));
		send.setBackground(new Color(0, 0, 0));
		send.setForeground(new Color(255, 255, 255));
		send.setText("Send To");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				send_actionPerformed(e);
			}

		});
		//
		// sendtoall
		//
		sendtoall.setIcon(new ImageIcon("images\\sendtoall.JPG"));
		sendtoall.setBackground(new Color(51, 51, 51));
		sendtoall.setForeground(new Color(255, 255, 255));
		sendtoall.setText("Send To All");
		sendtoall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sendtoall_actionPerformed(e);
			}

		});
		//
		// clear
		//
		clear.setIcon(new ImageIcon("images\\clear.JPG"));
		clear.setBackground(new Color(0, 0, 0));
		clear.setForeground(new Color(255, 255, 255));
		clear.setText("Clear Text");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				clear_actionPerformed(e);
			}

		});
		//
		// tree
		//
		tree.setIcon(new ImageIcon("images\\tree.JPG"));
		tree.setBackground(new Color(51, 51, 51));
		tree.setForeground(new Color(255, 255, 255));
		tree.setText("Back to Inbox");
		tree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				tree_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
	
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(245, 245, 245));
		addComponent(contentPane, jLabel1, 61,70,182,433);
		addComponent(contentPane, label, 274,130,121,29);
		addComponent(contentPane, jLabel5, 274,94,60,18);
		addComponent(contentPane, jLabel4, 274,200,121,29);
		addComponent(contentPane, jLabel2, 274,170,121,29);
		addComponent(contentPane, sendto, 365,90,264,22);
		addComponent(contentPane, subject, 365,130,268,22);
		addComponent(contentPane, grpinfo, 365,170,200,22);
		addComponent(contentPane, jScrollPane1, 274,231,571,167);
		addComponent(contentPane, send, 284,440,110,30);
		addComponent(contentPane, sendtoall, 426,440,110,30);
		addComponent(contentPane, clear, 571,440,110,30);
		addComponent(contentPane, tree, 711,440,110,30);
		//
		// ComposeMsg
		//
		this.setTitle("Compose Window");
		this.setLocation(new Point(50, 51));
		this.setSize(new Dimension(912, 554));
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
	private void sendto_actionPerformed(ActionEvent e)
	{
		System.out.println("\nsendto_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void subject_actionPerformed(ActionEvent e)
	{
		System.out.println("\nsubject_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void send_actionPerformed(ActionEvent e)
	{
		System.out.println("\nsend_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		try
		{
			to = sendto.getText();

			sub = subject.getText().trim();
			byte[] msg = textarea.getText().getBytes();
			boolean flag = false;
			byte[] signature={'0'};
			while(!flag){
				SignatureGeneration sg = new SignatureGeneration(msg);
				sg.generateKeyPair();
				signature = sg.signatureGeneration();
				flag = sg.engineVerify(signature);
			}
			sendTo(msg,id,to, sub, signature);
			
		}
		catch(Exception ex)
		{
			System.out.println("File Read Exception "+ex);
		}
	}

	private void sendtoall_actionPerformed(ActionEvent e)
	{
		System.out.println("\nsendtoall_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

		try
		{
			to=sendto.getText();
			sub = subject.getText();
			byte[] msg = textarea.getText().getBytes();
			boolean flag = false;
			byte[] signature={'0'};
			while(!flag){
				SignatureGeneration sg = new SignatureGeneration(msg);
				sg.generateKeyPair();
				signature = sg.signatureGeneration();
				flag = sg.engineVerify(signature);
			}
			sendToAll(msg,id,to, sub, signature);
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Exception arised " + ex);
		}
	}

	private void clear_actionPerformed(ActionEvent e)
	{
		System.out.println("\nclear_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		textarea.setText("");
		sendto.setText("");
		subject.setText("");
	}

	private void tree_actionPerformed(ActionEvent e)
	{
		System.out.println("\nback_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		//setVisible(false);
		try
		{
			new UsersTreeView();
		}
		catch (Exception ex)
		{
			System.out.println("Exception : "+ex);
		}
		
	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//

	public void sendTo(byte[] msg,String sender,String receiver, String subject, byte[] signature) {
		try {
			
			try
			{
				DBClass db = new DBClass();
				//new edit
                String sid=sendto.getText();
				String sgid = grpinfo.getSelectedItem().toString();
				//System.out.println("The User Id = "+id+" and Password = "+key+" and Grp Id = "+gid);
				int sflag=db.sgetResult(sid,sgid);
				if(sflag==1)
				{
					// end ..........
				int flag = db.checkMailId(id, gid);

				if(flag == 1)
				{
					
					String grpid = grpinfo.getSelectedItem().toString();
					ResultSet rs = st.executeQuery("Select UserIpAdrs from UsersInfo where UserId = '"+receiver+"' AND GrpId = '"+grpid+"'");
					String ipadrs="";
					if(rs.next())
						{
						ipadrs = rs.getString(1);
						System.out.println("The Receiver Ip Adrs = "+ipadrs);
					     }
					if(subject.equalsIgnoreCase("Leave"))
					{
						skt = new Socket(ipadrs,1000);
						String s = new String(msg);
						DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
						String packet = id+"#xyz#"+gid+"#"+subject+"#"+s+"#xyz";
						System.out.println("The Packet = "+packet);
						System.out.println(packet);
						dos.writeUTF(packet);
						DataInputStream dis = new DataInputStream(skt.getInputStream());
						String feedback = dis.readUTF();
						/*if(feedback.equalsIgnoreCase("Accepted"))
						{
							JOptionPane.showMessageDialog(this,"Your Requisition is Accepted and You may now Logout from the Group");
						}
						else
						{
							JOptionPane.showMessageDialog(this,"Your Requisition is Rejectd and Your Information is Not Removed from the Group");
						}*/
						System.out.println(feedback);
						dos.close();
					}					
					else
					{
						skt = new Socket(ipadrs, 3000);
						ObjectOutputStream dos = new ObjectOutputStream(skt.getOutputStream());
						String sig = new String(signature);
						FileOutputStream fos =  new FileOutputStream("Message.txt");
						fos.write(msg);
						System.out.println("The Message is Write");
						String key = db.getKey(sender,grpid);
						String packet = sender+"#"+gid+"#"+subject+"#"+sig+"#"+key;
						System.out.println(packet);
						byte[] b1 = packet.getBytes();
						dos.writeObject(b1);
						new Encryption(subject+".txt",key);
						FileInputStream fis = new FileInputStream(subject+".txt");
						b1 = new byte[fis.available()];						
						fis.read(b1);
						dos.writeObject(b1);
						System.out.println("Send the Message to the Receiver");
						ObjectInputStream dis = new ObjectInputStream(skt.getInputStream());
						byte[] bb = (byte[])dis.readObject();
						String s = new String(bb);
						System.out.println(s);
						if(s.equalsIgnoreCase("Success"))
							JOptionPane.showMessageDialog(this, "The Message is Successfully Received by the "+receiver);
						else
							JOptionPane.showMessageDialog(this, "The Message is not Successfully Received by the "+receiver);
					}
				}
			

				else
					JOptionPane.showMessageDialog(this,"Your Information is Removed from the Group");
			}// new edit if end-----------
			else
				{
		     	JOptionPane.showMessageDialog(this,"Your not in the group");
			     
				 }// end of new else				
			
			} 
			catch (Exception e) 
			{
				System.out.println("Message not send to the " + receiver + " " + e);
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exception "+ e);
		}
	}
		
	public void sendToAll(byte[] msg,String sender,String receiver, String subject, byte[] signature)
	{
		try
		{
			if(subject.equalsIgnoreCase("Leave"))
			{
				JOptionPane.showMessageDialog(this,"Give Your Requisition to Your Group Administrator Only");
			}
			else
			{
				DBClass db = new DBClass();
				//new edit on 15/02/08


				//String sid=sendto.getText();
				String sgid = grpinfo.getSelectedItem().toString();
			    String receivers[] = receiver.split(",");
				System.out.println("length:::"+receivers.length);
                for(int i=0;i<receivers.length;i++)
					{
				
				       int sflag=db.sgetResult(receivers[i],sgid);
					   System.out.println("j value:::"+i);
					 if(sflag==1)
				{
					// end-----------------------------------
				int flag = db.checkMailId(id, gid);
				if(flag == 1)
				{
					//String receivers[] = receiver.split(",");
					//for(int i=0;i<receivers.length;i++)
					//{
						
						System.out.println("The Receiver is "+receivers[i]);
						try
						{
							String grpid = grpinfo.getSelectedItem().toString();
							ResultSet rs = st.executeQuery("Select UserIpAdrs from UsersInfo where UserId = '"+receivers[i]+"' and GrpId = '"+grpid+"'");
							String ipadrs="";
							if(rs.next())
							{
								ipadrs = rs.getString(1);
								System.out.println("The Receiver Ip Adrs = "+ipadrs);
							}
							Socket skt = new Socket(ipadrs, 3000);
							ObjectOutputStream dos = new ObjectOutputStream(skt.getOutputStream());
							String sig = new String(signature);
							FileOutputStream fos =  new FileOutputStream("Message.txt");
							fos.write(msg);
							System.out.println("The Message is Write");
							String key = db.getKey(sender,grpid);
							String packet = sender+"#"+gid+"#"+subject+"#"+sig+"#"+key;
							System.out.println(packet);
							byte[] b1 = packet.getBytes();
							dos.writeObject(b1);
							new Encryption(subject+".txt",key);
							FileInputStream fis = new FileInputStream(subject+".txt");
							b1 = new byte[fis.available()];						
							fis.read(b1);
							dos.writeObject(b1);
							System.out.println("Send the Message to the Receiver");
							ObjectInputStream dis = new ObjectInputStream(skt.getInputStream());
							byte[] bb = (byte[])dis.readObject();
							String s = new String(bb);
							System.out.println(s);
							if(s.equalsIgnoreCase("Success"))
								JOptionPane.showMessageDialog(this, "The Message is Successfully Received by the "+receivers[i]);
							else
								JOptionPane.showMessageDialog(this, "The Message is not Successfully Received by the "+receivers[i]);
						
						} 
						catch (Exception e) 
						{
							System.out.println("Message not send to the " + receiver + " " + e);
						}
						Thread.sleep(3000);
					//}
				}
				else
					JOptionPane.showMessageDialog(this,"Your Information is Removed from the Group");
			
				}//end if
			//new else
			else
				{

				JOptionPane.showMessageDialog(this,"not in the group");
				System.out.println("else part j value ::"+i);

			   }
		}//end of for------------------

	}				
	}//try
		catch (Exception e)
		{
			System.out.println("Not able to tokenize " + e);
		}
	}//method

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
		//new ComposeMsg("","");
	}
//= End of Testing =


}

