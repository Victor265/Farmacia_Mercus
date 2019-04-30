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

public class JanelaConsultarClientes extends JFrame implements ActionListener {
	JLabel jlLogo, jlCpf, jlNome, jlLogradouro, jlComplemento, jlBairro,
			jlCidade, jlRg, jlTelefone1, jlTelefone2, 
			jlSexo,jlNumero, jlCep, jlHora,
			jlCabecalho;

	public JTextField jtCpf;

	public JTextField jtNome, jtLogradouro, jtComplemento, jtBairro, jtCidade;

	public JTextField jtRg;

	public JTextField jtTelefone1, jtTelefone2, jtNumero, jtCep;

	public JButton btOk, btCancelar, btVoltar;

	ImageIcon ok = new ImageIcon("ok.png");

	ImageIcon cancelar = new ImageIcon("cancelar.png");

	ImageIcon voltar = new ImageIcon("voltar.png");

	ImageIcon logopequeno = new ImageIcon("logopequeno.fw.png");

	private static final DateFormat FORMATO = new SimpleDateFormat("HH:mm:ss");

	public JanelaConsultarClientes(String titulo) {
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

		this.jlCabecalho = new JLabel("Consulta");
		jlCabecalho.setFont(fontemaior);
		this.jlLogo = new JLabel(logopequeno);

		this.jlCpf = new JLabel("CPF");
		this.jlNome = new JLabel("Nome");
		this.jlBairro = new JLabel("Bairro");
		this.jlCidade = new JLabel("Cidade");
		this.jlCep = new JLabel("CEP");
		this.jlRg = new JLabel("RG");
		this.jlSexo = new JLabel("Sexo");
		this.jlTelefone1 = new JLabel("Telefone Residencial");
		this.jlTelefone2 = new JLabel("Telefone Celular");
		this.jlLogradouro = new JLabel("Logradouro");
		this.jlNumero = new JLabel("Número");
		this.jlComplemento = new JLabel("Complemento");

		this.jtNome = new JTextField();
		this.jtBairro = new JTextField();
		this.jtCidade = new JTextField();
		this.jtRg = new JTextField();
		this.jtCpf = new JTextField();
		this.jtCep = new JTextField();
		this.jtTelefone1 = new JTextField();
		this.jtTelefone2 = new JTextField();
		this.jtLogradouro = new JTextField();
		this.jtNumero = new JTextField();
		this.jtComplemento = new JTextField();
		
		getContentPane().add(getLblHora());
		this.getContentPane().add(jlCabecalho);
		this.getContentPane().add(jlLogo);
		this.getContentPane().add(btOk);
		this.getContentPane().add(btCancelar);
		this.getContentPane().add(btVoltar);

		this.getContentPane().add(jlCpf);
		this.getContentPane().add(jtCpf);
		this.getContentPane().add(jlNome);
		this.getContentPane().add(jtNome);
		this.getContentPane().add(jlRg);
		this.getContentPane().add(jtRg);
		this.getContentPane().add(jlBairro);
		this.getContentPane().add(jtBairro);
		this.getContentPane().add(jlCidade);
		this.getContentPane().add(jtCidade);
		this.getContentPane().add(jlCep);
		this.getContentPane().add(jtCep);
		this.getContentPane().add(jlTelefone1);
		this.getContentPane().add(jtTelefone1);
		this.getContentPane().add(jlTelefone2);
		this.getContentPane().add(jtTelefone2);
		this.getContentPane().add(jlLogradouro);
		this.getContentPane().add(jtLogradouro);
		this.getContentPane().add(jlComplemento);
		this.getContentPane().add(jtComplemento);
		this.getContentPane().add(jlNumero);
		this.getContentPane().add(jtNumero);
	

		this.jlCabecalho.setBounds(10, 20, 500, 50);
		this.jlHora.setBounds(100, 450, 100, 100);
		this.jlLogo.setBounds(700, 50, 90, 84);

		this.btOk.setBounds(570, 450, 64, 64);
		this.btCancelar.setBounds(640, 450, 64, 64);
		this.btVoltar.setBounds(710, 450, 64, 64);

		this.jlCpf.setBounds(10, 90, 50, 30);
		this.jtCpf.setBounds(100, 90, 100, 30);
		this.jlNome.setBounds(10, 190, 50, 30);
		this.jtNome.setBounds(100, 190, 250, 30);
		this.jlRg.setBounds(220, 90, 50, 30);
		this.jtRg.setBounds(240, 90, 110, 30);
		this.jlBairro.setBounds(10, 220, 100, 30);
		this.jtBairro.setBounds(100, 220, 250, 30);
		this.jlCidade.setBounds(10, 250, 100, 30);
		this.jtCidade.setBounds(100, 250, 250, 30);
		this.jlCep.setBounds(400, 150, 100, 30);
		this.jtCep.setBounds(600, 150, 100, 30);
		this.jlTelefone1.setBounds(400, 180, 150, 30);
		this.jtTelefone1.setBounds(600, 180, 100, 30);
		this.jlTelefone2.setBounds(400, 210, 200, 30);
		this.jtTelefone2.setBounds(600, 210, 100, 30);
		this.jlLogradouro.setBounds(10, 120, 100, 30);
		this.jtLogradouro.setBounds(100, 120, 250, 30);
		this.jlNumero.setBounds(10, 150, 100, 30);
		this.jtNumero.setBounds(100, 150, 250, 30);
		

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
			JanelaConsultaCliente jcc = new JanelaConsultaCliente(
					"Farmácia Mercus - Consultar Clientes");
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

	public JTextField getJtCpf() {
		return jtCpf;
	}

	public void setJtCpf(JTextField jtCpf) {
		this.jtCpf = jtCpf;
	}

	public JTextField getJtNome() {
		return jtNome;
	}

	public void setJtNome(JTextField jtNome) {
		this.jtNome = jtNome;
	}

	public JTextField getJtLogradouro() {
		return jtLogradouro;
	}

	public void setJtLogradouro(JTextField jtLogradouro) {
		this.jtLogradouro = jtLogradouro;
	}

	public JTextField getJtComplemento() {
		return jtComplemento;
	}

	public void setJtComplemento(JTextField jtComplemento) {
		this.jtComplemento = jtComplemento;
	}

	public JTextField getJtBairro() {
		return jtBairro;
	}

	public void setJtBairro(JTextField jtBairro) {
		this.jtBairro = jtBairro;
	}

	public JTextField getJtCidade() {
		return jtCidade;
	}

	public void setJtCidade(JTextField jtCidade) {
		this.jtCidade = jtCidade;
	}

	public JTextField getJtRg() {
		return jtRg;
	}

	public void setJtRg(JTextField jtRg) {
		this.jtRg = jtRg;
	}

	public JTextField getJtTelefone1() {
		return jtTelefone1;
	}

	public void setJtTelefone1(JTextField jtTelefone1) {
		this.jtTelefone1 = jtTelefone1;
	}

	public JTextField getJtTelefone2() {
		return jtTelefone2;
	}

	public void setJtTelefone2(JTextField jtTelefone2) {
		this.jtTelefone2 = jtTelefone2;
	}

	public JTextField getJtNumero() {
		return jtNumero;
	}

	public void setJtNumero(JTextField jtNumero) {
		this.jtNumero = jtNumero;
	}

	public JTextField getJtCep() {
		return jtCep;
	}

	public void setJtCep(JTextField jtCep) {
		this.jtCep = jtCep;
	}
	
	public JLabel getJlTelefone1() {
		return jlTelefone1;
	}

	public void setJlTelefone1(JLabel jlTelefone1) {
		this.jlTelefone1 = jlTelefone1;
	}

	public JLabel getJlTelefone2() {
		return jlTelefone2;
	}

	public void setJlTelefone2(JLabel jlTelefone2) {
		this.jlTelefone2 = jlTelefone2;
	}

}

