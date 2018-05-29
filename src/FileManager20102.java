import java.awt.BorderLayout;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class FileManager20102 extends JFrame {
	JTree tree;
	
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("디스크 드라이브(C:)");
	
	DefaultTreeModel treeModel;
	
	String[] Language = {"한국어","English"};
	
	
	public FileManager20102() {
		super("/home/");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		
		JLabel l1 = new JLabel("File Explorer");
		
		JTextArea ta1 = new JTextArea(25,50	);
		
		JComboBox cb1 = new JComboBox(Language);
		
		File dir = new File("\\");
		
		File[] files = dir.listFiles();
		FileFilter fileFilter = new FileFilter() 
		{
			
			public boolean accept(File file) 
			{
				return file.isDirectory();
			}
		};
		files = dir.listFiles(fileFilter);
		if(files.length > 0) 
		{
				for(int i= 0; i<files.length;i++)
				{
					File filename = files[i];
					if(filename.toString().contains("$") || filename.toString().contains("Recovery")
							|| filename.toString().contains("System")||filename.toString().contains("PerfLogs"))
							continue;
							else
								{
								Object q = filename;
								String w = q.toString();
								String e[] = w.split("\\\\");
								DefaultMutableTreeNode a = new DefaultMutableTreeNode(e[1]);
								root.add(a);}
				}
		}
		
		add(p1,BorderLayout.SOUTH);
		add(p2,BorderLayout.WEST);
		add(p3,BorderLayout.EAST);
		
		
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		
		p2.add(tree);
		p1.add(l1);
		p1.add(cb1);
		p3.add(ta1);
		setSize(500,550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new FileManager20102();
		
		
}
}
