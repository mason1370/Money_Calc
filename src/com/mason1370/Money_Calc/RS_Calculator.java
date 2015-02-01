package com.mason1370.Money_Calc;

 import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
 
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class RS_Calculator extends JPanel implements ContainerListener, ActionListener, Global
{
    final JTable table = new JTable(Cat, Dog);
    //final JTable table_test = new JTable(Header_Tel,Data_Tel);
    static final String TELE = "tele";
    static final String REMOVE = "remove";
    static final String CLEAR = "clear";
    static final String newline = "\n";

    JPanel buttonPanel;
    JButton teleButton, removeButton, clearButton;
    JScrollPane scrollPane1 = new JScrollPane(table);
    JScrollPane holder = new JScrollPane();
    
    public RS_Calculator() {
        super(new GridBagLayout());
        GridBagLayout gridbag = (GridBagLayout)getLayout();
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints button = new GridBagConstraints();
        setPreferredSize(new Dimension(800, 400));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        //Create all the components.
        teleButton = new JButton("Teleport Tabs");
        teleButton.setActionCommand(TELE);
        teleButton.addActionListener(this);
        removeButton = new JButton("Remove a button");
        removeButton.setActionCommand(REMOVE);
        removeButton.addActionListener(this);
        clearButton = new JButton("Clear text area");
        clearButton.setActionCommand(CLEAR);
        clearButton.addActionListener(this);
        
        buttonPanel = new JPanel(new GridLayout(1,1));
        buttonPanel.setPreferredSize(new Dimension(200, 75));
        buttonPanel.addContainerListener(this);     
        
        //This starts the formating of the buttons and where they go.
        button.fill = GridBagConstraints.BOTH; //Fill entire cell. Also what keeps the buttons next to each other.
        button.weightx = 1.0;
        button.gridwidth = 1;
        gridbag.setConstraints(clearButton, button);
        add(clearButton);
        gridbag.setConstraints(teleButton, button);
        add(teleButton);
        button.gridwidth = GridBagConstraints.REMAINDER; //end of row
        gridbag.setConstraints(removeButton, button);
        add(removeButton);
        button.weighty = 1.0;  //Button area and message area have equal height.
        
        /**This is the formating for the Panels**/
        c.fill = GridBagConstraints.BOTH; //Fill entire cell.
        c.weighty = 1.0;  //Button area and message area have equal height.
        c.gridwidth = GridBagConstraints.REMAINDER; //end of row
        gridbag.setConstraints(scrollPane1, c);  
        gridbag.setConstraints(holder, c);
        add(scrollPane1);
        add(holder);
        scrollPane1.setVisible(false);
      
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (TELE.equals(command)) 
        {
        	holder.setVisible(false);
        	scrollPane1.setVisible(true);
        	//scrollPane1.add(table_test);
        	scrollPane1.getParent().revalidate(); //the getParent() Is very important
        	//scrollPane1.repaint();
        } 
        if (REMOVE.equals(command)) 
        {
        	holder.setVisible(true);
        	scrollPane1.setVisible(false);
        	scrollPane1.getParent().revalidate(); //the getParent() Is very important
        } 
        if (CLEAR.equals(command)) 
        {

        }
    }
    private static void createAndShowGUI() 
    {
        JFrame frame = new JFrame("RS_Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new RS_Calculator();
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {public void run() {createAndShowGUI();}});
        Global.Tele();
    }

	@Override
	public void componentAdded(ContainerEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentRemoved(ContainerEvent e) {
		// TODO Auto-generated method stub
		
	}
}