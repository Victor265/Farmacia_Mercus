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
import javax.swing.JTextField;

import control.ConsultarCliente;
import control.Conexao;

public class JanelaConsultaCliente extends JFrame implements ActionListener {
	Conexao conexao = new Conexao();
	
	JLabel jlLogo, jlCpf, jlCabecalho, jlHora;
	JTextField jtCpf;
	
	JButton btOk, btCancelar, btVoltar;
	
	ImageIcon ok = new ImageIcon("ok.png");

	ImageIcon cancelar = new ImageIcon("cancelar.png");

	ImageIcon voltar = new ImageIcon("voltar.png");

	ImageIcon logopequeno = new ImageIcon("logopequeno.fw.png");
	
	private static final DateFormat FORMATO = new SimpleDateFormat("HH:mm:ss");

	public JanelaConsultaCliente(String titulo) {
		super("Farmácia Mercus - Consultar Clientes");
		Font fontemaior = new Font("TimesRoman", Font.BOLD, 20);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(100, 100);

		this.btOk = new JButton(ok);
		this.btCancelar = new JButton(cancelar);
		this.btVoltar = new JButton(voltar);
		
		this.jlCabecalho = new JLabel("Consultar através do CPF");
		jlCabecalho.setFont(fontemaior);
		this.jlLogo = new JLabel(logopequeno);
		
		this.jlCpf = new JLabel("CPF");
		
		this.jtCpf = new JTextField();
		
		getContentPane().add(getLblHora());
		this.getContentPane().add(jlCabecalho);
		this.getContentPane().add(jlLogo);
		this.getContentPane().add(btOk);
		this.getContentPane().add(btCancelar);
		this.getContentPane().add(btVoltar);
		this.getContentPane().add(jlCpf);
		this.getContentPane().add(jtCpf);
		
		this.jlCabecalho.setBounds(10, 50, 500, 50);
		this.jlHora.setBounds(100, 450, 100, 100);
		this.jlLogo.setBounds(700, 50, 90, 84);

		this.btOk.setBounds(570, 450, 64, 64);
		this.btCancelar.setBounds(640, 450, 64, 64);
		this.btVoltar.setBounds(710, 450, 64, 64);

		this.jlCpf.setBounds(10, 160, 50, 30);
		this.jtCpf.setBounds(100,160,100,30);
		
		this.jtCpf.setEditable(true);
		
		this.jlHora.setFont(fontemaior);
		Timer t = new Timer("ClockTimer", true);
		t.schedule(new ClockTask(), 0, 1000);

		this.btOk.addActionListener(this);
		this.btCancelar.addActionListener(this);
		this.btVoltar.addActionListener(this);
		
		this.btOk.setToolTipText("Consultar");
		this.btCancelar.setToolTipText("Cancelar");
		this.btVoltar.setToolTipText("Limpar Formulário");

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
			ConsultarCliente conCliente = new ConsultarCliente();
			conCliente.consultaCliente(jtCpf.getText(),conexao.getConexao());
			dispose();
		}
		if (evento.getSource() == this.btCancelar) {
			dispose();
		}
		if (evento.getSource() == this.btVoltar) {
			dispose();
			JanelaConsultaCliente jcc = new JanelaConsultaCliente(
					"Farmácia Mercus - Consultar Clientes");
		}
	}
}
