package sprint1;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

class gui implements Serializable{
	
	private static final long serialVersionUID = -6353720471330955960L;
	static JFrame frame = new JFrame("Appointment Manager");
	static JTabbedPane tabPane= new JTabbedPane();
	static JPanel patPanel = new JPanel(new GridBagLayout());
	static JPanel phyPanel = new JPanel(new GridBagLayout());
	static JPanel appPanel = new JPanel(new GridBagLayout());
	public static AppointmentManager am = new AppointmentManager();
	
	public static void main(String[] args) { 
//		
//		AppointmentManager appMan = new AppointmentManager();
//		//test stuff - zm
//		Patient p = new Patient("Micky Mouse");
//		Physician doc = new Physician("Dr.Doc");
//		Bill b = new Bill(300, "12/9/19", "for stuff", p);
//		Prescription pre = new Prescription("Gummy worms", 50);
//		Appointment a = new Appointment("12:00 PM", "12/9/19", doc, p);
//		p.addAppt(a);
//		p.addPrescription(pre);
//		p.addBill(b);
//		appMan.addPatient(p);
//		
//		appMan.addPatient(new Patient("Billy Bob"));
//		appMan.addPatient(new Patient("Jim Dean"));
//		appMan.addPatient(new Patient("Greg Testes"));
//		
//
//		//fabers in-class testing
//		Physician p2 = new Physician("Jon Snow");
//		appMan.addAppointment(new Appointment("12/10/19", "12:00" , p2 ,am.getPatient("Greg Testes")));
//		appMan.addAppointment(new Appointment("12/9/19", "12:00" , p2 ,am.getPatient("Greg Testes")));
//		appMan.addAppointment(new Appointment("12/11/19", "12:00" , p2 ,am.getPatient("Greg Testes")));
//		
		setUpHomeGui(am);


	}

	public static void setUpHomeGui(AppointmentManager am){	
		patPanel();
		appPanel();
		phyPanel();
		tabPane.addTab("Patient", patPanel);
		tabPane.addTab("Physician", phyPanel);
		tabPane.addTab("Appointment", appPanel);
		frame.add(tabPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750,500);
		frame.setVisible(true);
	}
	
	public static void patPanel() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JRadioButton newPat = new JRadioButton("New Paitent");
		JRadioButton currPat = new JRadioButton("Current Paitent");
		JButton enterBtn = new JButton("Enter");
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(newPat);
		bg.add(currPat);
		gbc.gridx = 0;
		gbc.gridy = 0;
		patPanel.add(newPat , gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		patPanel.add(currPat,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		patPanel.add(enterBtn,gbc);
		
		newPat.setVisible(true);
		currPat.setVisible(true);
		enterBtn.setVisible(true);
		
		
		enterBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(newPat.isSelected()) {
					setNewPatPanel();
					newPat.setVisible(false);
					currPat.setVisible(false);
					enterBtn.setVisible(false);
				}
				else if(currPat.isSelected()) {
					setCurrPatPanel(am.getPatList());
					newPat.setVisible(false);
					currPat.setVisible(false);
					enterBtn.setVisible(false);
				}
			}
		});
		
	}
	//completed - adding grid view next
	public static void setNewPatPanel() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel nameLbl = new JLabel("Patient Name:");
		JTextField nameTf = new JTextField(20);
		JButton addPatBtn = new JButton("Add Patient");
		JButton rtnBtn = new JButton("Return");
		JTextArea patTxa = new JTextArea(15,25);
		JScrollPane sp = new JScrollPane(patTxa);
		gbc.gridx = 0;
		gbc.gridy = 0;
		patPanel.add(nameLbl,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		patPanel.add(nameTf);
		gbc.gridx = 2;
		gbc.gridy = 0;
		patPanel.add(addPatBtn,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		patPanel.add(rtnBtn,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		patPanel.add(patTxa,gbc);
		patPanel.add(sp,gbc);
		patTxa.setEditable(false);
		
		nameLbl.setVisible(true);
		nameTf.setVisible(true);
		addPatBtn.setVisible(true);
		rtnBtn.setVisible(true);
		patTxa.setVisible(true);
		
		addPatBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				Patient p = new Patient(nameTf.getText());
				am.addPatient(p);
				patTxa.setText("New Patient Details:\n" + p.toString());
			}
		});
		
		rtnBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nameLbl.setVisible(false);
				nameTf.setVisible(false);
				addPatBtn.setVisible(false);
				patTxa.setVisible(false);
				rtnBtn.setVisible(false);
				patPanel();
			}
		});
		
	}
	
	//functions completed, needs to be put into grid thing
	public static void setCurrPatPanel(ArrayList<Patient> pats) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		Object[] patsArr = pats.toArray(); 
		JComboBox<Object> patCB = new JComboBox<Object>(patsArr);
		JButton updatePatBtn = new JButton("Update Patient");
		JTextArea patTxa = new JTextArea(15,25);
		JButton rtnBtn = new JButton("Return");
		JLabel medLbl = new JLabel("Add Prescription:");
		JTextField medsTf = new JTextField(15);
		JLabel quantLbl = new JLabel("Quantity:");
		JTextField quantTf = new JTextField(8);
		JScrollPane sp = new JScrollPane(patTxa);
		gbc.gridx = 0;
		gbc.gridy = 0;
		patPanel.add(patCB,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		patPanel.add(medLbl,gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		patPanel.add(medsTf,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		patPanel.add(quantLbl,gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		patPanel.add(quantTf,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		patPanel.add(updatePatBtn,gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		patPanel.add(rtnBtn,gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		patPanel.add(patTxa,gbc);
		patPanel.add(sp,gbc);
		patCB.setVisible(true);
		updatePatBtn.setVisible(true);
		rtnBtn.setVisible(true);
		patTxa.setVisible(true);
		sp.setVisible(true);
		patTxa.setEditable(false);
		medLbl.setVisible(true);
		medsTf.setVisible(true);
		quantLbl.setVisible(true);
		quantTf.setVisible(true);
		
		updatePatBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Patient p = (Patient) patCB.getSelectedItem(); 
				
				if(!(medsTf.getText().isEmpty()) && !(quantTf.getText().isEmpty())) {
					Prescription pre = new Prescription(medsTf.getText(), Integer.parseInt(quantTf.getText()));
					p.addPrescription(pre);
					patTxa.setText(p.viewAppts() + p.viewPrescriptions());
					medsTf.setText(null);
					quantTf.setText(null);
				}
				else {
					patTxa.setText(p.viewAppts() + p.viewPrescriptions());
					medsTf.setText(null);
					quantTf.setText(null);
				}
			}	
		});
		
		rtnBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				patCB.setVisible(false);
				updatePatBtn.setVisible(false);
				patTxa.setVisible(false);
				rtnBtn.setVisible(false);
				medsTf.setVisible(false);
				medLbl.setVisible(false);
				quantLbl.setVisible(false);
				quantTf.setVisible(false);
				patPanel();
			}
		});
	}
	
	public static void appPanel() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JRadioButton rbtnUpdateDeleteApp = new JRadioButton("Update/Cancel Appointment");
		JRadioButton rbtnNewApp = new JRadioButton("Add Appointment");
		ButtonGroup bg = new ButtonGroup();
		JButton btnEnter = new JButton("Enter");
		JButton btnSaveApps = new JButton("Save Appointments");
		JButton btnLoadApps = new JButton("Load Appointments");
		bg.add(rbtnNewApp);
		bg.add(rbtnUpdateDeleteApp);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		appPanel.add(rbtnNewApp , gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		appPanel.add(rbtnUpdateDeleteApp, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		appPanel.add(btnEnter,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		appPanel.add(btnSaveApps,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		appPanel.add(btnLoadApps,gbc);
		
		rbtnNewApp.setVisible(true);
		rbtnUpdateDeleteApp.setVisible(true);
		btnEnter.setVisible(true);
		btnSaveApps.setVisible(true);
		btnLoadApps.setVisible(true);
		
		btnEnter.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(rbtnNewApp.isSelected()) {
					setNewAppPanel();
					btnLoadApps.setVisible(false);
					btnSaveApps.setVisible(false);
					rbtnNewApp.setVisible(false);
					rbtnUpdateDeleteApp.setVisible(false);
					btnEnter.setVisible(false);
				}
				else if(rbtnUpdateDeleteApp.isSelected()) {
					rbtnNewApp.setVisible(false);
					btnLoadApps.setVisible(false);
					btnSaveApps.setVisible(false);
					rbtnUpdateDeleteApp.setVisible(false);
					btnEnter.setVisible(false);
					ArrayList<Appointment> apps = am.getAppList();
					updateOrDeleteAppPanel(apps);
				}
			}
		});
		
		btnSaveApps.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				writeObject.serializeAppointmentManager(gui.am);
				String appManFilename = "ap.ser";
				String workingDirectory = System.getProperty("user.dir");
				String appManAbsoluteFilePath = "";
				appManAbsoluteFilePath = workingDirectory + File.separator + appManFilename;
				JOptionPane.showMessageDialog(null, "Appointments saved at: " +appManAbsoluteFilePath , "InfoBox: Save Function", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});

		btnLoadApps.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				am = readObject.deserialzeAppointmentManager("ap.ser");
				String appManFilename = "ap.ser";
				String workingDirectory = System.getProperty("user.dir");
				String appManAbsoluteFilePath = "";
				appManAbsoluteFilePath = workingDirectory + File.separator + appManFilename;
				JOptionPane.showMessageDialog(null, "Appointments Loaded from: " +appManAbsoluteFilePath , "InfoBox: Load Function", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
	}
	
	public static void setNewAppPanel() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel lblTime = new JLabel("Time:");
		JTextField tfTime = new JTextField(10);
		JLabel lblDate = new JLabel("Date:");
		JTextField tfDate = new JTextField(10);
		JLabel lblPhy = new JLabel("Physician Name:");
		JTextField tfPhy = new JTextField(20);
		JLabel lblPat = new JLabel("Patient Name:");
		JTextField tfPat = new JTextField(20);
		JButton btnAddApp = new JButton("Add Appointment");
		JButton btnReturn = new JButton("Return");
		JTextArea taMessage = new JTextArea(15,25);
		taMessage.setEditable(false);
		taMessage.setLineWrap(true);
		taMessage.setWrapStyleWord(true);
		JScrollPane sp = new JScrollPane(taMessage);
		gbc.gridx = 0;
		gbc.gridy = 0;
		appPanel.add(lblTime, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		appPanel.add(tfTime , gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		appPanel.add(lblDate , gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		appPanel.add(tfDate , gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		appPanel.add(lblPhy , gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		appPanel.add(tfPhy,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		appPanel.add(lblPat,gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		appPanel.add(tfPat,gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		appPanel.add(btnAddApp,gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		appPanel.add(btnReturn,gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth=2;
		appPanel.add(sp,gbc);
		appPanel.add(taMessage,gbc);
		sp.setVisible(false);
		lblTime.setVisible(true);
		tfTime.setVisible(true);
		lblDate.setVisible(true);
		tfDate.setVisible(true);
		lblPhy.setVisible(true);
		tfPhy.setVisible(true);
		lblPat.setVisible(true);
		tfPat.setVisible(true);
		btnAddApp.setVisible(true);
		btnReturn.setVisible(true);
		taMessage.setVisible(false);

		btnAddApp.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				Physician phy = new Physician(tfPhy.getText());
				Patient pat = new Patient(tfPat.getText());
				Appointment app = new Appointment(tfTime.getText(), tfDate.getText() , phy ,  pat);
				taMessage.setText(app.toString());
				tfTime.setText(null);
				tfDate.setText(null);
				tfPhy.setText(null);
				tfPat.setText(null);
				am.addAppointment(app);
				sp.setVisible(true);
				taMessage.setVisible(true);
				
			}
		});
		
		btnReturn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblTime.setVisible(false);
				tfTime.setVisible(false);
				lblDate.setVisible(false);
				tfDate.setVisible(false);
				lblPhy.setVisible(false);
				tfPhy.setVisible(false);
				lblPat.setVisible(false);
				tfPat.setVisible(false);
				btnAddApp.setVisible(false);
				btnReturn.setVisible(false);
				sp.setVisible(false);
				taMessage.setVisible(false);
				appPanel();
				
			}
		});
		
	}
	
	public static void updateOrDeleteAppPanel(ArrayList<Appointment> apps) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		Object[] appsArray = apps.toArray();
		JComboBox<Object> cmbApps = new JComboBox<Object>(appsArray);
		JButton btnUpdateApp = new JButton("Update Appointment");
		JButton btnCancelApp = new JButton("Cancel Appointment");
		JButton btnReturn = new JButton("Return");
		JLabel lblNewTime = new JLabel("Enter updated time:");
		JTextField tfNewTime = new JTextField(10);
		JLabel lblNewDate = new JLabel("Enter updated date:");
		JTextField tfNewDate = new JTextField(10);
		JTextArea taMessage = new JTextArea(15,25);
		taMessage.setEditable(false);
		taMessage.setLineWrap(true);
		taMessage.setWrapStyleWord(true);
		JScrollPane sp = new JScrollPane(taMessage);
		gbc.gridx = 0;
		gbc.gridy = 0;
		appPanel.add(cmbApps,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		appPanel.add(lblNewDate,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		appPanel.add(tfNewDate,gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		appPanel.add(lblNewTime,gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		appPanel.add(tfNewTime,gbc);
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.gridwidth = 3;
		appPanel.add(sp,gbc);
		appPanel.add(taMessage,gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		appPanel.add(btnUpdateApp,gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		appPanel.add(btnReturn,gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;
		appPanel.add(btnCancelApp,gbc);
		lblNewTime.setVisible(true);
		tfNewTime.setVisible(true);
		lblNewDate.setVisible(true);
		tfNewDate.setVisible(true);
		btnCancelApp.setVisible(true);
		cmbApps.setVisible(true);
		btnUpdateApp.setVisible(true);
		btnReturn.setVisible(true);
		sp.setVisible(false);
		
		btnCancelApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cmbApps.getSelectedIndex();
				Appointment a = apps.get(index);
				taMessage.setText("Canceled appointment:" + "\n" + a.toString());
				taMessage.setVisible(true);
				sp.setVisible(true);
				am.deleteAppointment(a.getDate(), a.getTime(), a.getPhy().getName(), a.getPat().getName());
				cmbApps.removeItem(a);
			}
		});
		
		btnUpdateApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cmbApps.getSelectedIndex();
				Appointment a = apps.get(index);
				String message = "Updated Appointment:" + "\n";
				am.updateAppointment(a.getDate(), a.getTime(), a.getPhy().getName(), a.getPat().getName(), tfNewTime.getText(), tfNewDate.getText());
				message += a.toString();
				taMessage.setText(message);
				sp.setVisible(true);
				taMessage.setVisible(true);

			}
		});
		
		btnReturn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cmbApps.setVisible(false);
				btnUpdateApp.setVisible(false);
				btnReturn.setVisible(false);
				btnCancelApp.setVisible(false);
				lblNewTime.setVisible(false);
				tfNewTime.setVisible(false);
				lblNewDate.setVisible(false);
				tfNewDate.setVisible(false);
				sp.setVisible(false);
				taMessage.setVisible(false);
				appPanel();
			}
		});
	}
	
	public static void phyPanel() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JRadioButton newPhy = new JRadioButton("New Physician");
		JRadioButton currPhy = new JRadioButton("Current Physician");
		JButton enterBtn = new JButton("Enter");
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(newPhy);
		bg.add(currPhy);
		gbc.gridx = 0;
		gbc.gridy = 0;
		phyPanel.add(newPhy, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		phyPanel.add(currPhy, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		phyPanel.add(enterBtn, gbc);
		
		newPhy.setVisible(true);
		currPhy.setVisible(true);
		enterBtn.setVisible(true);
		
		enterBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(newPhy.isSelected()) {
					setNewPhyPanel();
					newPhy.setVisible(false);
					currPhy.setVisible(false);
					enterBtn.setVisible(false);
				}
				else if(currPhy.isSelected()) {
					setCurrPhyPanel(am.getPhyList());
					newPhy.setVisible(false);
					currPhy.setVisible(false);
					enterBtn.setVisible(false);
				}
			}
		});
		
	}
	
	public static void setNewPhyPanel() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel nameLbl = new JLabel("Physician Name:");
		JTextField nameTf = new JTextField(20);
		JButton addPhyBtn = new JButton("add Physician");
		JTextArea phyTxa = new JTextArea(15,25);
		JScrollPane sp = new JScrollPane(phyTxa);
		JButton rtnBtn = new JButton("Return");
		gbc.gridx = 0;
		gbc.gridy = 0;
		phyPanel.add(nameLbl, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		phyPanel.add(nameTf, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		phyPanel.add(addPhyBtn, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		phyPanel.add(rtnBtn, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		phyPanel.add(phyTxa, gbc);
		phyPanel.add(sp, gbc);
		
		nameLbl.setVisible(true);
		nameTf.setVisible(true);
		addPhyBtn.setVisible(true);
		phyTxa.setVisible(true);
		rtnBtn.setVisible(true);
		
		addPhyBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				Physician p = new Physician(nameTf.getText());
				am.addPhysician(p);
				phyTxa.setText("New Physician Details:\n" + p.toString());
			}
		});
		
		rtnBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nameLbl.setVisible(false);
				nameTf.setVisible(false);
				addPhyBtn.setVisible(false);
				phyTxa.setVisible(false);
				sp.setVisible(false);
				rtnBtn.setVisible(false);
				phyPanel();
			}
		});
		
	}
	
	public static void setCurrPhyPanel(ArrayList<Physician> phys) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		Object[] physArr = phys.toArray(); 
		JComboBox<Object> phyCB = new JComboBox<Object>(physArr);
		JButton updatePhyBtn = new JButton("Update Physician");
		JTextArea display = new JTextArea(15,25);
		JScrollPane sp = new JScrollPane(display);
		display.setEditable(false);
		JRadioButton viewApps = new JRadioButton("View Appointments");
		JButton rtnBtn = new JButton("Return");
		gbc.gridx = 0;
		gbc.gridy = 0;
		phyPanel.add(phyCB, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		phyPanel.add(updatePhyBtn, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		phyPanel.add(viewApps, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		phyPanel.add(rtnBtn, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		phyPanel.add(display, gbc);
		phyPanel.add(sp, gbc);
		
		sp.setVisible(true);
		phyCB.setVisible(true);
		updatePhyBtn.setVisible(true);
		display.setVisible(true);
		viewApps.setVisible(true);
		rtnBtn.setVisible(true);
		
		updatePhyBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Physician doc = (Physician) phyCB.getSelectedItem();
				if(viewApps.isSelected()) {
					String appts = am.viewPhysicianAppointments(doc.getName());
					String promt = String.format("Appoinment for %s:\n", doc.getName());
					display.setText(promt + appts);
					
				}
			}
		});
		
		rtnBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				phyCB.setVisible(false);
				updatePhyBtn.setVisible(false);
				display.setVisible(false);
				rtnBtn.setVisible(false);
				viewApps.setVisible(false);
				phyPanel();
			}
		});
	}
	
}