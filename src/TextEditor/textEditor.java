package TextEditor;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class textEditor extends JTextField implements ActionListener{
	
	JFrame f;
	JTextArea textArea;

	

	textEditor() {
		
		f = new JFrame();
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			
			MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
	
		} catch (Exception e){}
		
		
	     textArea = new JTextArea();
	
		JMenuBar m = new JMenuBar();
		
		JMenu file = new JMenu("File");
		
		  JMenuItem n = new JMenuItem("New"); 
	      JMenuItem open = new JMenuItem("Open"); 
	      JMenuItem save = new JMenuItem("Save"); 
	      JMenuItem print = new JMenuItem("Print"); 
	      
	      n.addActionListener(this);
	      open.addActionListener(this);
	      save.addActionListener(this);
	      print.addActionListener(this);
	      
	      file.add(n);
	      file.add(open);
	      file.add(save);
	      file.add(print);
		
		
		JMenu edit = new JMenu("Edit");
		
		  JMenuItem cut = new JMenuItem("Cut");
		  JMenuItem copy = new JMenuItem("Copy");
		  JMenuItem paste = new JMenuItem("Paste");
		
		  cut.addActionListener(this);
	      copy.addActionListener(this);
	      paste.addActionListener(this);
	      
	      edit.add(cut);
	      edit.add(copy);
	      edit.add(paste);
		
	      
		
		JMenu font = new JMenu("font");
		
		JMenu undoRedo = new JMenu("Undo/Redo");
		
		  m.add(file);
	      m.add(edit);
	      m.add(font);
	      m.add(undoRedo);
	      
	      f.setJMenuBar(m);
	      
	      f.add(textArea); 
	        f.setSize(500, 500); 
	        f.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		   if (command.equals("Cut")) { 
	            textArea.cut(); 
	        } 
	        else if (command.equals("Copy")) { 
	            textArea.copy(); 
	        } 
	        else if (command.equals("Paste")) { 
	            textArea.paste(); 
	
	        } 
		   
	        else if (command.equals("Save")){
	        	JFileChooser j = new JFileChooser("f:");
	        	
	        	int r = j.showSaveDialog(null);
	        	
	        	if(r == JFileChooser.APPROVE_OPTION) {
	        		File fi = new File(j.getSelectedFile().getAbsolutePath());
	        		

	                try { 
	                    // Create a file writer 
	                    FileWriter wr = new FileWriter(fi, false); 
	  
	                    // Create buffered writer to write 
	                    BufferedWriter w = new BufferedWriter(wr); 
	  
	                    // Write 
	                    w.write(textArea.getText()); 
	  
	                    w.flush(); 
	                    w.close(); 
	                } 
	                catch (Exception evt) { 
	                    JOptionPane.showMessageDialog(f, evt.getMessage()); 
	                } 
	                
	                
	        		
	        	} else {
	               JOptionPane.showMessageDialog(f, "the user cancelled the operation"); 
	        } 
	        }
		   
	        else if (command.equals("Print")) { 
	            try { 
	                // print the file 
	                textArea.print(); 
	            } 
	            catch (Exception evt) { 
	                JOptionPane.showMessageDialog(f, evt.getMessage()); 
	            } 
	        }
		   
	        else if (command.equals("Open")) {
	        	
	        	
	        	JFileChooser frame = new JFileChooser("f:");
	        	
	        	int r = frame.showOpenDialog(null);
	        	
	        	 // If the user selects a file 
	            if (r == JFileChooser.APPROVE_OPTION) { 
	                // Set the label to the path of the selected directory 
	                File fi = new File(frame.getSelectedFile().getAbsolutePath()); 
	  
	                try { 
	                    // String 
	                    String s1 = "", sl = ""; 
	  
	                    // File reader 
	                    FileReader fr = new FileReader(fi); 
	  
	                    // Buffered reader 
	                    BufferedReader br = new BufferedReader(fr); 
	  
	                 
	                    sl = br.readLine(); 
	  
	                    // Take the input from the file 
	                    while ((s1 = br.readLine()) != null) { 
	                        sl = sl + "\n" + s1; 
	                    } 
	  
	                    // Set the text 
	                    textArea.setText(sl); 
	                    
	                    br.close();
	                } 
	                catch (Exception evt) { 
	                    JOptionPane.showMessageDialog(f, evt.getMessage()); 
	                }
	                
	        
	            } else
                    JOptionPane.showMessageDialog(f, "the user cancelled the operation");
	        }
		   
	        else if (command.equals("New")) { 
	            textArea.setText(""); 
	        } 
//	        else if (command.equals("close")) { 
//	            f.setVisible(false); 
//	        } 
		   
		   	
	}
	
	  // Main class 
    public static void main(String args[]) 
    { 
        textEditor e = new textEditor(); 
    } 

}
