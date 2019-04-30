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
import javax.swing.JTextField;

public class JanelaConsultaEstoque extends JFrame implements ActionListener {
	JLabel jlLogo, jlNome, jlFormula, jlValidade, jlCodigo, jlHora,
			jlCabecalho;

	public JTextField jtNome, jtFormula, jtValidade, jtCodigo;

	public JButton btOk, btCancelar, btVoltar;

	ImageIcon ok = new ImageIcon("ok.png");

	ImageIcon cancelar = new ImageIcon("cancelar.png");

	ImageIcon voltar = new ImageIcon("voltar.png");

	ImageIcon logopequeno = new ImageIcon("logopequeno.fw.png");

	private static final DateFormat FORMATO = new SimpleDateFormat("HH:mm:ss");

	public JanelaConsultaEstoque(String titulo) {
		super("Farmácia Mercus - Consultar Estoque");
		Font fontemaior = new Font("TimesRoman", Font.BOLD, 20);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(100, 100);

		this.btOk = new JButton(ok);
		this.btCancelar = new JButton(cancelar);
		this.btVoltar = new JButton(voltar);

		this.jlCabecalho = new JLabel("Consulta");
		jlCabecalho.setFont(fontemaior);
		this.jlLogo = new JLabel(logopequeno);

		this.jlNome = new JLabel("Nome");
		this.jlFormula = new JLabel("Formula");
		this.jlValidade = new JLabel("Validade");
		this.jlCodigo = new JLabel("Código");
		

		this.jtNome = new JTextField();
		this.jtFormula = new JTextField();
		this.jtValidade = new JTextField();
		this.jtCodigo = new JTextField();
		
		
		getContentPane().add(getLblHora());
		this.getContentPane().add(jlCabecalho);
		this.getContentPane().add(jlLogo);
		this.getContentPane().add(btOk);
		this.getContentPane().add(btCancelar);
		this.getContentPane().add(btVoltar);

		
		this.getContentPane().add(jlNome);
		this.getContentPane().add(jtNome);
		this.getContentPane().add(jlFormula);
		this.getContentPane().add(jtFormula);
		this.getContentPane().add(jlValidade);
		this.getContentPane().add(jtValidade);
		this.getContentPane().add(jlCodigo);
		this.getContentPane().add(jtCodigo);
		
	

		this.jlCabecalho.setBounds(10, 20, 500, 50);
		this.jlHora.setBounds(100, 450, 100, 100);
		this.jlLogo.setBounds(700, 50, 90, 84);

		this.btOk.setBounds(570, 450, 64, 64);
		this.btCancelar.setBounds(640, 450, 64, 64);
		this.btVoltar.setBounds(710, 450, 64, 64);

		this.jlLogo.setBounds(700, 50, 90, 84);
		this.jlFormula.setBounds(10, 60, 50, 30);
		this.jtFormula.setBounds(100, 60, 100, 30);
		this.jlNome.setBounds(10, 90, 50, 30);
		this.jtNome.setBounds(100, 90, 250, 30);
		this.jlValidade.setBounds(10, 120, 100, 30);
		this.jtValidade.setBounds(100, 120, 250, 30);
		this.jlCodigo.setBounds(10, 150, 100, 30);
		this.jtCodigo.setBounds(100, 150, 250, 30);
		

		

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
			dispose();
			JanelaConsultarEstoque jcc = new JanelaConsultarEstoque(
					"Farmácia Mercus - Consultar Estoque");
		}
		if (evento.getSource() == this.btCancelar) {
			dispose();
		}
		if (evento.getSource() == this.btVoltar) {
			dispose();
			JanelaConsultarEstoque jcc = new JanelaConsultarEstoque(
					"Farmácia Mercus - Consultar Estoque");
		}
	}

	

	public JTextField getJtNome() {
		return jtNome;
	}

	public void setJtNome(JTextField jtNome) {
		this.jtNome = jtNome;
	}

	public JTextField getJtFormula() {
		return jtFormula;
	}

	public void setJtFormula(JTextField jtFormula) {
		this.jtFormula = jtFormula;
	}

	public JTextField getJtValidade() {
		return jtValidade;
	}

	public void setJtValidade(JTextField jtValidade) {
		this.jtValidade = jtValidade;
	}

	public JTextField getJtCodigo() {
		return jtCodigo;
	}

	public void setJtCodigo(JTextField jtCodigo) {
		this.jtCodigo = jtCodigo;
	}

}