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

import control.AlterarCliente;
import control.Conexao;

public class JanelaAlteraCliente extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Conexao conexao = new Conexao();

	JLabel jlLogo, jlCpf, jlNome, jlLogradouro, jlComplemento, jlBairro,
			jlCidade, jlRg, jlTelefone1, jlTelefone2, jlSexo,jlNumero, jlCep, jlHora;

	
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

	JTextField jtCpf, jtNome, jtLogradouro, jtComplemento, jtBairro, jtCidade,
			jtRg, jtTelefone1, jtTelefone2, jtNumero, jtCep;

	JRadioButton rbMasc, rbFem;

	JButton btOk, btCancelar, btVoltar;

	ImageIcon ok = new ImageIcon("ok.png");

	ImageIcon cancelar = new ImageIcon("cancelar.png");

	ImageIcon voltar = new ImageIcon("voltar.png");

	ImageIcon logo = new ImageIcon("logopequeno.fw.png");

	private static final DateFormat FORMATO = new SimpleDateFormat("HH:mm:ss");

	public JanelaAlteraCliente(String Titulo) {
		super("Farmácia Mercus - Alterar Clientes");
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(100, 100);

		this.jlLogo = new JLabel(logo);
		this.jlCpf = new JLabel("CPF");
		this.jlNome = new JLabel("Nome");
		this.jlLogradouro = new JLabel("Logradouro");
		this.jlNumero = new JLabel("Número");
		this.jlComplemento = new JLabel("Complemento");
		this.jlBairro = new JLabel("Bairro");
		this.jlCidade = new JLabel("Cidade");
		this.jlCep = new JLabel("CEP");
		this.jlRg = new JLabel("RG");
		this.jlTelefone1 = new JLabel("Telefone Residencial");
		this.jlTelefone2 = new JLabel("Telefone Celular/Comercial");
		this.jlSexo = new JLabel("Sexo");

		this.jtNome = new JTextField();
		this.jtLogradouro = new JTextField();
		this.jtNumero = new JTextField();
		this.jtComplemento = new JTextField();
		this.jtBairro = new JTextField();
		this.jtCidade = new JTextField();
		this.jtRg = new JTextField();
		this.jtCpf = new JTextField();
		this.jtCep = new JTextField();
		this.jtTelefone1 = new JTextField();
		this.jtTelefone2 = new JTextField();

		this.rbMasc = new JRadioButton("Masculino");
		this.rbFem = new JRadioButton("Feminino");

		this.btOk = new JButton(ok);
		this.btCancelar = new JButton(cancelar);
		this.btVoltar = new JButton(voltar);

		this.getContentPane().add(jlLogo);
		this.getContentPane().add(jlCpf);
		this.getContentPane().add(jtCpf);
		this.getContentPane().add(jlNome);
		this.getContentPane().add(jtNome);
		this.getContentPane().add(jlLogradouro);
		this.getContentPane().add(jtLogradouro);
		this.getContentPane().add(jlRg);
		this.getContentPane().add(jtRg);
		this.getContentPane().add(jlNumero);
		this.getContentPane().add(jtNumero);
		this.getContentPane().add(jlComplemento);
		this.getContentPane().add(jtComplemento);
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
		this.getContentPane().add(jlSexo);
		this.getContentPane().add(rbMasc);
		this.getContentPane().add(rbFem);
		this.getContentPane().add(btOk);
		this.getContentPane().add(btCancelar);
		this.getContentPane().add(btVoltar);
		getContentPane().add(getLblHora());

		this.jlLogo.setBounds(700, 50, 90, 84);
		this.jlCpf.setBounds(10, 90, 50, 30);
		this.jtCpf.setBounds(100, 90, 100, 30);
		this.jlNome.setBounds(10, 120, 50, 30);
		this.jtNome.setBounds(100, 120, 250, 30);
		this.jlLogradouro.setBounds(10, 150, 100, 30);
		this.jtLogradouro.setBounds(100, 150, 250, 30);
		this.jlRg.setBounds(220, 90, 50, 30);
		this.jtRg.setBounds(240, 90, 110, 30);
		this.jlNumero.setBounds(10, 180, 100, 30);
		this.jtNumero.setBounds(100, 180, 250, 30);
		this.jlComplemento.setBounds(10, 210, 100, 30);
		this.jtComplemento.setBounds(100, 210, 250, 30);
		this.jlBairro.setBounds(10, 240, 100, 30);
		this.jtBairro.setBounds(100, 240, 250, 30);
		this.jlCidade.setBounds(10, 270, 100, 30);
		this.jtCidade.setBounds(100, 270, 250, 30);
		this.jlCep.setBounds(400, 150, 100, 30);
		this.jtCep.setBounds(600, 150, 100, 30);
		this.jlTelefone1.setBounds(400, 180, 150, 30);
		this.jtTelefone1.setBounds(600, 180, 100, 30);
		this.jlTelefone2.setBounds(400, 210, 200, 30);
		this.jtTelefone2.setBounds(600, 210, 100, 30);
		this.jlSexo.setBounds(400, 100, 100, 30);
		this.rbMasc.setBounds(490, 100, 100, 30);
		this.rbFem.setBounds(590, 100, 100, 30);
		this.jlHora.setBounds(100, 450, 100, 100);

		btOk.setBounds(570, 450, 64, 64);
		btCancelar.setBounds(640, 450, 64, 64);
		btVoltar.setBounds(710, 450, 64, 64);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rbMasc);
		grupo.add(rbFem);
		rbMasc.setSelected(true);

		Font fontemaior = new Font("TimesRoman", Font.BOLD, 20);
		this.jlHora.setFont(fontemaior);
		Timer t = new Timer("ClockTimer", true);
		t.schedule(new ClockTask(), 0, 1000);

		this.btOk.setToolTipText("Alterar");
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
			AlterarCliente aCliente = new AlterarCliente();
			aCliente.alteraCliente(jtCpf.getText(), jtRg.getText(), jtNome
					.getText(), jtBairro.getText(), jtCidade.getText(), jtCep
					.getText(),  jtLogradouro.getText(),
					jtNumero.getText(), jtComplemento.getText(),jtTelefone1.getText(),
					jtTelefone2	.getText(),conexao.getConexao());
			
			JOptionPane.showMessageDialog(null,
					"Cliente cadastrado com sucesso");
	
			dispose();
		}
		if (evento.getSource() == this.btCancelar) {
			dispose();
		}
		if (evento.getSource() == this.btVoltar) {
			dispose();
			JanelaAlteraCliente jca = new JanelaAlteraCliente(
					"Farmácia Mercus - Alterar Clientes");
		}
	}
}
