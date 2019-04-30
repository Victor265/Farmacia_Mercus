package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JanelaLogin extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton btOk;

	JLabel jlUser, jlPass, jlLogo, jlHora, jlJava, jlNos;

	JTextField tfUser;

	JPasswordField pfPass;

	ImageIcon logo = new ImageIcon("logo.png");
	
	ImageIcon java = new ImageIcon("java.png");
	
	ImageIcon ok = new ImageIcon("Ok.png");

	private static final DateFormat FORMATO = new SimpleDateFormat("HH:mm:ss");

	public JanelaLogin(String titulo) {
		super("Farmácia Mercus - Seja Bem-Vindo");
		this.setResizable(false);
		this.setSize(800, 600);
		this.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		Font fontemaior = new Font("TimesRoman", Font.BOLD, 20);

		this.jlLogo = new JLabel(logo);
		this.jlJava = new JLabel(java);
		this.jlNos=new JLabel("Victor Lopes da Motta da Silva");
		this.btOk = new JButton(ok);
		this.jlUser = new JLabel("Nome de usuário");
		this.jlPass = new JLabel("Senha");
		this.tfUser = new JTextField();
		this.pfPass = new JPasswordField();

		this.getContentPane().add(btOk);
		this.getContentPane().add(jlLogo);
		this.getContentPane().add(jlUser);
		this.getContentPane().add(jlPass);
		this.getContentPane().add(tfUser);
		this.getContentPane().add(pfPass);
		this.getContentPane().add(jlJava);
		this.getContentPane().add(jlNos);
		getContentPane().add(getLblHora());

		this.jlLogo.setBounds(250, 50, 250, 250);
		this.jlUser.setBounds(220, 300, 150, 30);
		this.jlPass.setBounds(240, 370, 150, 30);
		this.tfUser.setBounds(380, 300, 150, 30);
		this.pfPass.setBounds(380, 370, 150, 30);
		this.btOk.setBounds(360, 450, 64, 64);
		this.jlJava.setBounds(10,500,32,32);
		this.jlNos.setBounds(50,500,250,50);
		this.jlHora.setBounds(700, 500, 100, 100);
		this.jlHora.setFont(fontemaior);

		Timer t = new Timer("ClockTimer", true);
		t.schedule(new ClockTask(), 0, 1000);

		this.btOk.addActionListener(this);
		this.btOk.setToolTipText("Ok");

		this.setVisible(true);

	}

	private JLabel getLblHora() {
		if (jlHora == null) {
			jlHora = new JLabel();
		}
		return jlHora;
	}

	public void setHora(Date date) {
		getLblHora().setText(FORMATO.format(date));
	}

	private class ClockTask extends TimerTask {
		public void run() {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					setHora(new Date());
				}
			});
		}
	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == this.btOk) {
			JanelaMenu jm = new JanelaMenu(
					"Farmácia Mercus - Menu Principal");
			dispose();
		}
	}
}
