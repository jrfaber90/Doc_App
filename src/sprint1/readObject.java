package sprint1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class readObject implements Serializable {

	private static final long serialVersionUID = -5613516002390131043L;

	@SuppressWarnings("static-access")
	public static void main(String args[]) {

		String appManFilename = "ap.ser";

		String workingDirectory = System.getProperty("user.dir");

		String appManAbsoluteFilePath = "";
		
		appManAbsoluteFilePath = workingDirectory + File.separator + appManFilename;

		System.out.print("Final App Man filepath : " + appManAbsoluteFilePath);

		System.out.println(gui.am);

	}

	public static Patient deserialzePatient(String filename) {

		Patient p = null;

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			p = (Patient) ois.readObject();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return p;
	}

	public static Physician deserialzePhysician(String filename) {

		Physician p = null;

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			p = (Physician) ois.readObject();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return p;
	}

	public static AppointmentManager deserialzeAppointmentManager(String filename) {

		AppointmentManager ap = new AppointmentManager();

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			ap = (AppointmentManager) ois.readObject();
			System.out.print("Success!");
			System.out.println(gui.am);
			return ap;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		System.out.println(gui.am);
		return ap;
	}
}
