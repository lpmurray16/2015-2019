package gui_xml;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class simpleGUI {

	private JFrame frmMedicalRecordLog;
	private JTextField firstName;
	private JTextField lastName;
	
	private JTextField dateText;
	private JTextField patCondText;
	private JTextField short_descText;
	private JTextField addPresText;
	private JTextField perfByText;
	private JTextField middleName;
	private JTextField primCPText;
	private JTextField curPresText;
	private JTextField medHistText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					simpleGUI window = new simpleGUI();
					window.frmMedicalRecordLog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public simpleGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMedicalRecordLog = new JFrame();
		frmMedicalRecordLog.setForeground(Color.WHITE);
		frmMedicalRecordLog.setBackground(Color.WHITE);
		frmMedicalRecordLog.setBounds(100, 100, 584, 598);
		frmMedicalRecordLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMedicalRecordLog.setTitle("Medical Record Log - Add Record For New Patient");

		

/************************SUBMIT BUTTON*********************************************************/
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(326, 513, 97, 25);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String patientName = "" + firstName.getText() + " " + middleName.getText() + " " + lastName.getText();
				String date = dateText.getText();
				String primaryCP = primCPText.getText();
				String performedBy = perfByText.getText();
				String currPresc = curPresText.getText();
				String addedPresc = addPresText.getText();
				String patientConditions = patCondText.getText();
				String medicalHist = medHistText.getText();
				String eventDesc = short_descText.getText();
				clearAllText();
				
				JOptionPane.showMessageDialog(null, "Submitted");
				
			}
		});
		frmMedicalRecordLog.getContentPane().setLayout(null);
		btnSubmit.setBackground(UIManager.getColor("Button.background"));
		btnSubmit.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 14));
		frmMedicalRecordLog.getContentPane().add(btnSubmit);
		
/************************CANCEL BUTTON*********************************************************/
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(446, 513, 97, 25);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int usrSel = JOptionPane.showConfirmDialog(btnCancel, "Are you sure you want to cancel? All information will be lost.");
				if(usrSel == 0) { // yes option
					System.exit(0);
				}
				else if (usrSel == 1) { // no option
					
				}
				else if (usrSel == 2) { // cancel
					
				}
					
			}
		});
		btnCancel.setBackground(UIManager.getColor("Button.background"));
		btnCancel.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 14));
		frmMedicalRecordLog.getContentPane().add(btnCancel);
		
		firstName = new JTextField();
		firstName.setBounds(12, 47, 151, 22);
		frmMedicalRecordLog.getContentPane().add(firstName);
		firstName.setColumns(21);
		
		JLabel firstNameLabel = new JLabel("First Name*");
		firstNameLabel.setBounds(12, 24, 151, 22);
		firstNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		firstNameLabel.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 13));
		frmMedicalRecordLog.getContentPane().add(firstNameLabel);
		
		lastName = new JTextField();
		lastName.setBounds(187, 47, 151, 22);
		frmMedicalRecordLog.getContentPane().add(lastName);
		lastName.setColumns(21);
		
		JLabel lastNameLabel = new JLabel("Last Name*");
		lastNameLabel.setBounds(187, 24, 151, 22);
		lastNameLabel.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 13));
		frmMedicalRecordLog.getContentPane().add(lastNameLabel);
		
		JLabel midNameLabel = new JLabel("Middle Name");
		midNameLabel.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 13));
		midNameLabel.setBounds(362, 24, 151, 22);
		frmMedicalRecordLog.getContentPane().add(midNameLabel);
		
		
		
		dateText = new JTextField();
		dateText.setBounds(12, 109, 151, 22);
		frmMedicalRecordLog.getContentPane().add(dateText);
		dateText.setColumns(10);
		
		JLabel dateLabel = new JLabel("Date (MM/DD/YYYY)");
		dateLabel.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 13));
		dateLabel.setBounds(12, 82, 151, 22);
		frmMedicalRecordLog.getContentPane().add(dateLabel);
		
		patCondText = new JTextField();
		patCondText.setBounds(12, 343, 501, 22);
		frmMedicalRecordLog.getContentPane().add(patCondText);
		patCondText.setColumns(10);
		
		JLabel SSNlabel = new JLabel("Patient Conditions");
		SSNlabel.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 13));
		SSNlabel.setBounds(12, 325, 151, 16);
		frmMedicalRecordLog.getContentPane().add(SSNlabel);
		
		short_descText = new JTextField();
		short_descText.setBounds(12, 466, 507, 22);
		frmMedicalRecordLog.getContentPane().add(short_descText);
		short_descText.setColumns(10);
		
		JLabel lblShortDescriptionOf = new JLabel("Short Description of visit");
		lblShortDescriptionOf.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 13));
		lblShortDescriptionOf.setBounds(12, 444, 182, 16);
		frmMedicalRecordLog.getContentPane().add(lblShortDescriptionOf);
		
		addPresText = new JTextField();
		addPresText.setBounds(12, 290, 326, 22);
		frmMedicalRecordLog.getContentPane().add(addPresText);
		addPresText.setColumns(10);
		
		JLabel lblPerscriptionsAdded = new JLabel("Perscription(s) Added");
		lblPerscriptionsAdded.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 13));
		lblPerscriptionsAdded.setBounds(12, 270, 162, 16);
		frmMedicalRecordLog.getContentPane().add(lblPerscriptionsAdded);
		
		perfByText = new JTextField();
		perfByText.setBounds(12, 169, 151, 22);
		frmMedicalRecordLog.getContentPane().add(perfByText);
		perfByText.setColumns(10);
		
		JLabel lblPerformedBy = new JLabel("Performed By");
		lblPerformedBy.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 13));
		lblPerformedBy.setBounds(12, 150, 151, 16);
		frmMedicalRecordLog.getContentPane().add(lblPerformedBy);
		
		middleName = new JTextField();
		middleName.setBounds(362, 47, 151, 22);
		frmMedicalRecordLog.getContentPane().add(middleName);
		middleName.setColumns(10);
		
		primCPText = new JTextField();
		primCPText.setBounds(187, 109, 151, 22);
		frmMedicalRecordLog.getContentPane().add(primCPText);
		primCPText.setColumns(10);
		
		JLabel lblPrimaryCarePhysician = new JLabel("Primary Care Physician");
		lblPrimaryCarePhysician.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 13));
		lblPrimaryCarePhysician.setBounds(187, 85, 168, 16);
		frmMedicalRecordLog.getContentPane().add(lblPrimaryCarePhysician);
		
		curPresText = new JTextField();
		curPresText.setBounds(12, 235, 326, 22);
		frmMedicalRecordLog.getContentPane().add(curPresText);
		curPresText.setColumns(10);
		
		JLabel lblCurrentPrescriptions = new JLabel("Current Prescriptions");
		lblCurrentPrescriptions.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 13));
		lblCurrentPrescriptions.setBounds(12, 216, 151, 16);
		frmMedicalRecordLog.getContentPane().add(lblCurrentPrescriptions);
		
		medHistText = new JTextField();
		medHistText.setBounds(12, 409, 501, 22);
		frmMedicalRecordLog.getContentPane().add(medHistText);
		medHistText.setColumns(10);
		
		JLabel lblMedicalHistory = new JLabel("Medical History");
		lblMedicalHistory.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 13));
		lblMedicalHistory.setBounds(12, 388, 130, 16);
		frmMedicalRecordLog.getContentPane().add(lblMedicalHistory);
	}
	/************************FUNCTIONS****************************************************/
	public boolean containsNumberOrEmpty(JTextField text) {
		if(text.getText().matches(".*\\d.*")) {
			return false;
		} 
		else if (text.getText().isEmpty()) {
			return false;
		} 
		
		return true;
	}
	public void showSubmitConfirm() {
		JOptionPane.showMessageDialog(null, "The record has been submitted.", "RECORD SUBMITTED", 0);
	}
	
	public void clearAllText() {
		firstName.setText(null);
		lastName.setText(null);
		middleName.setText(null);
		dateText.setText(null);
		patCondText.setText(null);
		short_descText.setText(null);
		addPresText.setText(null);
		perfByText.setText(null);
		middleName.setText(null);
		primCPText.setText(null);
		curPresText.setText(null);
		medHistText.setText(null);
	}
}


/*String finalXML = String.format(
"<?xml version=\"1.0\"?>
<Transaction>
    <TransactionID>
        000001
        </TransactionID>
    <PatientName>
        %s
        </PatientName>
    <PatientPCP>
        %s
        </PatientPCP>
    <EventName>
        %s
        </EventName>
    <PerformedBy>
        %s
        </PerformedBy>
    <EventDate>
        %s    
        </EventDate>
    <PrescriptionsAdded>
        %s
    </PrescriptionsAdded>
    <CurrentPrescriptions>
        %s
    </CurrentPrescriptions>
    <PatientConditions>
        %s
    </PatientConditions>
    <PatientMedicalHistory>
            %s
    </PatientMedicalHistory>
</Transaction>", patientName, primaryCP, eventDesc, performedBy, date, addedPresc, currPresc, patientConditions, medicalHist); */      
  

