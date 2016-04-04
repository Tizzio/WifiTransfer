import java.awt.EventQueue;

import javax.swing.UIManager;

public class Main {
	
	public static void main(String[] args) {

		//prova 
		//System.out.println(Utils.getGatewayIP());
		//System.out.println(Utils.getLocalIP());
		System.out.println("Application running..");
		
		if(WindowsNetwork.checkHostednetwork())
			System.out.println("ok");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					
					try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
					catch (Exception e) { e.printStackTrace(); }
					
					
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
					    if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(info.getClassName())) {   
					       javax.swing.UIManager.setLookAndFeel(info.getClassName());
					       break;
					     } 
					}
					
					new MainMenu();
					//new SendBoxGUI();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}	
}