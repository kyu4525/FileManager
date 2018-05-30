import java.awt.BorderLayout;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TestFileManager extends JFrame {
	JTree tree;
	
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("디스크 드라이브(C:)");
	
	DefaultTreeModel treeModel;
	
	String[] Language = {"한국어","English"};
	
	
	public TestFileManager() {
		super("FileManager");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		String header[] = {"Name","Size","Modified"};
		String contents[][] = {};
		
		JLabel l1 = new JLabel("File Explorer");
		JLabel l2 = new JLabel("/home/");
		
		
		JTable t1 = new JTable(contents,header);
		JScrollPane scrollpane = new JScrollPane(t1);
		
		
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
		add(p4,BorderLayout.NORTH);
		
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		
		
		p1.add(l1);
		p1.add(cb1);
		p2.add(tree);
		p3.add(scrollpane);
		p4.add(l2);
		setSize(800,550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new TestFileManager();
		
		
}
}
