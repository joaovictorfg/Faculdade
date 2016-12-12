/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa.view;

import empresa.controller.Cliente;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author brunn
 */
public class TelaControleClientes extends JFrame {

    private JTextField txtNome = new JTextField(30);
    private JTextField txtCpf = new JTextField(12);
    private JTextField txtLogradouro = new JTextField(30);
    private JTextField txtBairro = new JTextField(30);
    private JTextField txtCidade = new JTextField(30);
    private JTextField txtEstado = new JTextField(2);
    private JTextField txtPais = new JTextField(12);
    private JTextField txtCep = new JTextField(12);
    private JButton btnSalvar = new JButton("Salvar");

    public TelaControleClientes() throws HeadlessException {
        super("Empresa");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(600, 700);
        this.setLayout(new FlowLayout());
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().add(new JLabel("Nome:"));
        this.getContentPane().add(txtNome);

        this.getContentPane().add(new JLabel("CPF:"));
        this.getContentPane().add(txtCpf);

        this.getContentPane().add(new JLabel("Logradouro:"));
        this.getContentPane().add(txtLogradouro);

        this.getContentPane().add(new JLabel("Bairro:"));
        this.getContentPane().add(txtBairro);

        this.getContentPane().add(new JLabel("Cidade:"));
        this.getContentPane().add(txtCidade);

        this.getContentPane().add(new JLabel("País:"));
        this.getContentPane().add(txtPais);

        this.getContentPane().add(new JLabel("Cep:"));
        this.getContentPane().add(txtCep);

        this.getContentPane().add(btnSalvar);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente(txtNome.getText(), txtCpf.getText());
                
                try {
                    cliente.save();
                    limpaTela();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Tela Controle de Clientes:"
                            + ex,
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(TelaControleClientes.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    private void limpaTela() {
        txtNome.setText("");
        txtCpf.setText("");
    }
}
