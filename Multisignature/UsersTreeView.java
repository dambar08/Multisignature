

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;
import java.sql.*;

 public class UsersTreeView extends JFrame {
	int n;
	String users="";
  public UsersTreeView()
  {
	  setTitle("Group View");
	  
	  try
	  {		
		  DBClass db=new DBClass();
		  DefaultMutableTreeNode r=new DefaultMutableTreeNode("Group");
		  DefaultMutableTreeNode r1=new DefaultMutableTreeNode("Group1");
		  DefaultMutableTreeNode r2=new DefaultMutableTreeNode("Group2");

		if(true)
		  {

		  n = db.getUsersCount("Group 1");
		  //System.out.println("users are "+n);
		  String[] strs = db.getUsers("Group 1",n);
          DefaultMutableTreeNode[] nodes = new DefaultMutableTreeNode[strs.length];
		  for(int i=0;i<strs.length;i++)  
		  {  
		  	//System.out.println("Else part" +strs[i]);
			nodes[i] = new DefaultMutableTreeNode(strs[i]);
			r1.add(nodes[i]);

		  }
		  }
//---------------------------------For Group 2
	
		  if(true)
		  {

		  n = db.getUsersCount("Group 2");
		  //System.out.println("users are "+n);
		  String[] strs = db.getUsers("Group 2",n);
          DefaultMutableTreeNode[] nodes = new DefaultMutableTreeNode[strs.length];
		  for(int i=0;i<strs.length;i++)  
		  {                               
		   
	       nodes[i] = new DefaultMutableTreeNode(strs[i]);
		   r2.add(nodes[i]);
			}
		  }


		  r.add(r1);
		  r.add(r2);
		  JTree tree = new JTree(r);
		  tree.setEditable(true);
		  JScrollPane sp = new JScrollPane(tree);
		  getContentPane().add(sp, BorderLayout.CENTER);
     	  this.setSize(300, 300);
          this.setLocation(350,250);
		  this.setVisible(true);
		 
	  }
	  catch(Exception e)
	  {
		  JOptionPane.showMessageDialog(this,"The Users  Cannot have Controllers");
	  }
  }

  public static void main(String args[])
  {
	  System.out.println("Group");

  }
}


