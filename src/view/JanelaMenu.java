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
import javax.swing.JOptionPane;

public class JanelaMenu extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton btCadCliente, btCadVeiculo, btConCliente, btConVeiculo,
			btAltCliente, btAltVeiculo, btExcCli, btExcVei, btLogoff, btDesligar;

	JLabel jlLogo, jlHora, jlCadcli, jlCadvei, jlConcli, jlConvei, jlAltcli,
			jlAltvei, jlExccli, jlExcvei;

	private static final DateFormat FORMATO = new SimpleDateFormat("HH:mm:ss");

	public JanelaMenu(String titulo) {
		super("Farmácia Mercus - Menu Principal");
		this.setResizable(false);
		this.setSize(800, 600);
		this.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		Font fontemaior = new Font("TimesRoman", Font.BOLD, 20);

		ImageIcon logopeq = new ImageIcon("logo.png");
		ImageIcon cadcliente = new ImageIcon("cadcliente.png");
		ImageIcon altcliente = new ImageIcon("altcliente.png");
		ImageIcon concliente = new ImageIcon("concliente.png");
		ImageIcon exccliente = new ImageIcon("exccliente.png");
		ImageIcon cadveiculo = new ImageIcon("remedios.png");
		ImageIcon altveiculo = new ImageIcon("remedios.png");
		ImageIcon conveiculo = new ImageIcon("estoque.png");
		ImageIcon excveiculo = new ImageIcon("remedios.png");
		
		ImageIcon logoff = new ImageIcon("logoff.png");
		ImageIcon desligar = new ImageIcon("desligar.png");

		this.jlLogo = new JLabel(logopeq);
		this.btCadCliente = new JButton(cadcliente);
		this.btCadVeiculo = new JButton(cadveiculo);
		this.btConCliente = new JButton(concliente);
		this.btConVeiculo = new JButton(conveiculo);
		this.btAltCliente = new JButton(altcliente);
		this.btAltVeiculo = new JButton(altveiculo);
		this.btExcCli = new JButton(exccliente);
		this.btExcVei = new JButton(excveiculo);
		
		this.btLogoff = new JButton(logoff);
		this.btDesligar = new JButton(desligar);

		JLabel jlCadcli = new JLabel("Cadastrar Clientes");
		JLabel jlConcli = new JLabel("Consultar Clientes");
		JLabel jlAltcli = new JLabel("Alterar Clientes");
		JLabel jlExccli = new JLabel("Excluir Clientes");
		JLabel jlCadvei = new JLabel("Cadastrar Medicamentos");
		JLabel jlConvei = new JLabel("Consultar o Estoque");
		JLabel jlAltvei = new JLabel("Alterar Medicamentos");
		JLabel jlExcvei = new JLabel("Excluir Medicamentos");

		this.getContentPane().add(jlLogo);
		this.getContentPane().add(btCadCliente);
		this.getContentPane().add(btCadVeiculo);
		this.getContentPane().add(btConCliente);
		this.getContentPane().add(btConVeiculo);
		this.getContentPane().add(btAltCliente);
		this.getContentPane().add(btAltVeiculo);
		this.getContentPane().add(btExcCli);
		this.getContentPane().add(btExcVei);
		this.getContentPane().add(btLogoff);
		this.getContentPane().add(btDesligar);
		this.getContentPane().add(jlCadcli);
		this.getContentPane().add(jlCadvei);
		this.getContentPane().add(jlConcli);
		this.getContentPane().add(jlConvei);
		this.getContentPane().add(jlAltcli);
		this.getContentPane().add(jlAltvei);
		this.getContentPane().add(jlExccli);
		this.getContentPane().add(jlExcvei);

		getContentPane().add(getLblHora());

		this.jlLogo.setBounds(300, 20, 250, 250);
		this.btCadCliente.setBounds(150, 250, 64, 64);
		this.btConCliente.setBounds(150, 320, 64, 64);
		this.btAltCliente.setBounds(150, 390, 64, 64);
		this.btExcCli.setBounds(150, 460, 64, 64);
		this.btCadVeiculo.setBounds(500, 250, 64, 64);
		this.btConVeiculo.setBounds(500, 320, 64, 64);
		this.btAltVeiculo.setBounds(500, 390, 64, 64);
		this.btExcVei.setBounds(500, 460, 64, 64);
		this.btLogoff.setBounds(100,50,64,64);
		this.btDesligar.setBounds(636,50,64,64);

		jlCadcli.setBounds(220, 250, 150, 64);
		jlConcli.setBounds(220, 320, 150, 64);
		jlAltcli.setBounds(220, 390, 150, 64);
		jlExccli.setBounds(220, 460, 150, 64);
		jlCadvei.setBounds(570, 250, 150, 64);
		jlConvei.setBounds(570, 320, 150, 64);
		jlAltvei.setBounds(570, 390, 150, 64);
		jlExcvei.setBounds(570, 460, 150, 64);

		this.jlHora.setBounds(700, 500, 100, 100);
		
		this.jlHora.setFont(fontemaior);

		Timer t = new Timer("ClockTimer", true);
		t.schedule(new ClockTask(), 0, 1000);

		this.btCadCliente.addActionListener(this);
		this.btCadVeiculo.addActionListener(this);
		this.btConCliente.addActionListener(this);
		this.btConVeiculo.addActionListener(this);
		this.btAltCliente.addActionListener(this);
		this.btAltVeiculo.addActionListener(this);
		this.btExcCli.addActionListener(this);
		this.btExcVei.addActionListener(this);
		this.btLogoff.addActionListener(this);
		this.btDesligar.addActionListener(this);
		
		this.btLogoff.setToolTipText("Fazer Logoff");
		this.btDesligar.setToolTipText("Sair do Programa");

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
		if (evento.getSource() == this.btCadCliente) {
			JanelaCadastrarClientes jcc = new JanelaCadastrarClientes(
					"Farmácia Mercus - Cadastrar Clientes");
		}
		if (evento.getSource() == this.btCadVeiculo) {
			JanelaCadastrarMedicamentos jcv = new JanelaCadastrarMedicamentos(
					"Farmácia Mercus - Cadastrar Medicamentos");
		}
		 if (evento.getSource() == this.btConCliente) {
			JanelaConsultaCliente jcv = new JanelaConsultaCliente(
					"Farmácia Mercus - Consultar Clientes");
		}
		if (evento.getSource() == this.btConVeiculo) {
			JanelaConsultarEstoque jcv = new JanelaConsultarEstoque(
					"Farmácia Mercus - Consultar o Estoque");
		}
		if (evento.getSource() == this.btAltCliente) {
			JanelaAlteraCliente jac = new JanelaAlteraCliente(
					"Farmácia Mercus - Alterar Clientes");
		}
		if (evento.getSource() == this.btExcCli) {
			JanelaExcluirCliente jac = new JanelaExcluirCliente(
					"Farmácia Mercus - Excluir Clientes");
		}
		if (evento.getSource() == this.btAltVeiculo) {
			JanelaAlterarMedicamentos jav = new JanelaAlterarMedicamentos(
					"Farmácia Mercus - Alterar Medicamentos");
		}
		if (evento.getSource() == this.btExcVei) {
			JanelaExcluirMedicamento jev = new JanelaExcluirMedicamento(
					"Farmácia Mercus - Excluir Medicamentos");
		}
		if (evento.getSource() == btLogoff) {
			if (JOptionPane.showConfirmDialog(null, "Deseja fazer logoff?", "Fazer Logoff", 
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
				dispose();
				JanelaLogin jl = new JanelaLogin("Farmácia Mercus - Seja Bem-Vindo");
			}
		}
		if (evento.getSource() == btDesligar) {
			if (JOptionPane.showConfirmDialog(null, "Deseja fechar o programa?", "Sair", 
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
				System.exit(0);
			}
		}
	}
}
