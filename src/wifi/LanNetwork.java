package wifi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LanNetwork extends JDialog implements ClosableWindow {

	private static final long serialVersionUID = 8237689034968088432L;
	private final JPanel contentPanel = new JPanel();
	private Server server;
	private JButton cancelButton;

	public LanNetwork()
	{
		MainMenu.instance.setVisible(false);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		
		server = new Server(this);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 325, 147);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblYourIpIs = new JLabel("Your IP is: " + Utils.getLocalIP());
			contentPanel.add(lblYourIpIs, BorderLayout.NORTH);
			lblYourIpIs.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JSeparator separator = new JSeparator();
				panel.add(separator, BorderLayout.NORTH);
			}
			{
				JLabel lblNewLabel = new JLabel("Waiting for establishing a connection...");
				panel.add(lblNewLabel, BorderLayout.CENTER);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						System.out.println("LanNetwork: \"Cancel\" clicked");
						if(server != null)
						{
							System.out.println("Destroying server");
							destroy();
							server.destroy();
						}
						else{
							destroy();
							MainMenu.instance.setVisible(true);
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);

			}
		}
		
		setLocationRelativeTo(SendBoxGUI.instance);
		getRootPane().setBorder( BorderFactory.createLineBorder(Color.LIGHT_GRAY) );
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void destroy() {
		dispose();
	}

	@Override
	public void setVisibility(boolean visible) {
		setVisible(visible);
	}

}
