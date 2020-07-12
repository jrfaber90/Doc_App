package sprint1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class writeObject implements Serializable {

	private static final long serialVersionUID = -7496552990177895574L;

	@SuppressWarnings("static-access")
	public static void main(String args[]) {

		writeObject obj = new writeObject();

//		Patient p = new Patient("Ryan Pearson");
//		Physician phy = new Physician("Dr.Ryan Pearson");
//		AppointmentManager office = new AppointmentManager();
//		office.addPatient(p);
//		office.addPhysician(phy);
		

//		obj.serializePatient(p);
//		obj.serializePhysician(phy);
		obj.serializeAppointmentManager(gui.am);

	}

	public static void serializePatient(Patient p) {

		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			String filename = "Patient.ser";
			String workingDirectory = System.getProperty("user.dir");

			String absoluteFilePath = "";

			absoluteFilePath = workingDirectory + File.separator + filename;

			System.out.println("Final filepath : " + absoluteFilePath);

			fout = new FileOutputStream(absoluteFilePath);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(p);

			System.out.println("Done");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	public static void serializePhysician(Physician p) {

		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			String filename = "Physician.ser";
			String workingDirectory = System.getProperty("user.dir");

			String absoluteFilePath = "";

			absoluteFilePath = workingDirectory + File.separator + filename;

			System.out.println("Final filepath : " + absoluteFilePath);

			fout = new FileOutputStream(absoluteFilePath);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(p);

			System.out.println("Done");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	public static AppointmentManager serializeAppointmentManager(AppointmentManager ap) {

		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			String filename = "ap.ser";
			String workingDirectory = System.getProperty("user.dir");

			String absoluteFilePath = "";

			absoluteFilePath = workingDirectory + File.separator + filename;

			System.out.println("Final filepath : " + absoluteFilePath);

			fout = new FileOutputStream(absoluteFilePath);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(ap);

			System.out.println("Done");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return ap;
	}
}
