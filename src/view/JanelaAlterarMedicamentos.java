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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.AlterarMedicamento;
import control.CadastraCliente;
import control.CadastrarMedicamentos;
import control.Conexao;

public class JanelaAlterarMedicamentos extends JFrame implements
		ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Conexao conexao = new Conexao();

	JLabel jlLogo, jlNome, jlFormula, jlValidade, jlCodigo, jlHora;

	JTextField jtNome, jtFormula, jtValidade, jtCodigo;

	JButton btOk, btCancelar, btVoltar;

	ImageIcon ok = new ImageIcon("ok.png");

	ImageIcon cancelar = new ImageIcon("cancelar.png");

	ImageIcon voltar = new ImageIcon("voltar.png");

	ImageIcon logo = new ImageIcon("logopequeno.fw.png");

	private static final DateFormat FORMATO = new SimpleDateFormat("HH:mm:ss");

	public JanelaAlterarMedicamentos(String Titulo) {
		super("Farmácia Mercus - Alterar Medicamentos");
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(100, 100);

		this.jlLogo = new JLabel(logo);
		this.jlNome = new JLabel("Nome");
		this.jlFormula = new JLabel("Fórmula");
		this.jlValidade = new JLabel("Validade");
		this.jlCodigo = new JLabel("Código");

		this.jtNome = new JTextField();
		this.jtFormula = new JTextField();
		this.jtValidade = new JTextField();
		this.jtCodigo = new JTextField();

		this.btOk = new JButton(ok);
		this.btCancelar = new JButton(cancelar);
		this.btVoltar = new JButton(voltar);

		this.getContentPane().add(jlLogo);
		this.getContentPane().add(jlNome);
		this.getContentPane().add(jtNome);
		this.getContentPane().add(jlFormula);
		this.getContentPane().add(jtFormula);
		this.getContentPane().add(jlValidade);
		this.getContentPane().add(jtValidade);
		this.getContentPane().add(jlCodigo);
		this.getContentPane().add(jtCodigo);
		this.getContentPane().add(btOk);
		this.getContentPane().add(btCancelar);
		this.getContentPane().add(btVoltar);
		getContentPane().add(getLblHora());

		this.jlLogo.setBounds(700, 50, 90, 84);
		this.jlFormula.setBounds(10, 60, 50, 30);
		this.jtFormula.setBounds(100, 60, 100, 30);
		this.jlNome.setBounds(10, 90, 50, 30);
		this.jtNome.setBounds(100, 90, 250, 30);
		this.jlValidade.setBounds(10, 120, 100, 30);
		this.jtValidade.setBounds(100, 120, 250, 30);
		this.jlCodigo.setBounds(10, 150, 100, 30);
		this.jtCodigo.setBounds(100, 150, 250, 30);
		this.jlHora.setBounds(100, 450, 100, 100);

		btOk.setBounds(570, 450, 64, 64);
		btCancelar.setBounds(640, 450, 64, 64);
		btVoltar.setBounds(710, 450, 64, 64);

		Font fontemaior = new Font("TimesRoman", Font.BOLD, 20);
		this.jlHora.setFont(fontemaior);
		Timer t = new Timer("ClockTimer", true);
		t.schedule(new ClockTask(), 0, 1000);

		this.btOk.setToolTipText("Cadastrar");
		this.btCancelar.setToolTipText("Cancelar");
		this.btVoltar.setToolTipText("Limpar Formulário");

		this.btOk.addActionListener(this);
		this.btCancelar.addActionListener(this);
		this.btVoltar.addActionListener(this);

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
			AlterarMedicamento aMedicamento = new AlterarMedicamento();
			aMedicamento.alteraMedicamento(jtFormula.getText(),
					jtNome.getText(), jtValidade.getText(), jtCodigo.getText(),
					conexao.getConexao());

			JOptionPane.showMessageDialog(null,
					"Medicamento cadastrado com sucesso");
			dispose();
		}
		if (evento.getSource() == this.btCancelar) {
			dispose();
		}
		if (evento.getSource() == this.btVoltar) {
			dispose();
			JanelaAlterarMedicamentos jcc = new JanelaAlterarMedicamentos(
					"Farmácia Mercus - Cadastrar Medicamentos");
		}
	}
}
