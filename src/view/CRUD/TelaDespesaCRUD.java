/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.CRUD;
import java.lang.System.Logger;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.CategoriaDespesa;
import model.bean.Despesa;
import model.dao.DespesaDAO;
import model.dao.CategoriaDespesaDAO;
import view.TelaMenuPrincipal;
/**
 *
 * @author heyto
 */
public class TelaDespesaCRUD extends javax.swing.JFrame {

    /**
     * Creates new form TelaReceitaCRUD
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    private int id_usuario;

    public TelaDespesaCRUD(int id_usuario) throws ClassNotFoundException, SQLException {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo( null );

        this.id_usuario = id_usuario;
        
        listarComboBox();

         try {
            readJtable();
        } catch (SQLException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }
    
    public final void listarComboBox () {
        CategoriaDespesaDAO dao = new CategoriaDespesaDAO();
        try {
            for(CategoriaDespesa d: dao.readCategoriaByIdUser(id_usuario)){
                comboBoxCat.addItem(d.getCode()+ " - " + d.getNome());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDespesaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private TelaDespesaCRUD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void readJtable() throws  ClassNotFoundException, SQLException {
        DefaultTableModel modelo = (DefaultTableModel) TabelaExibir.getModel();
        modelo.setNumRows(0);
        DespesaDAO pdao = new DespesaDAO();
        System.out.println("usaurio id DESPESA" + id_usuario);

        pdao.readDepesaByIdUser(id_usuario).stream().forEach((d) -> {
            modelo.addRow(new Object[]{
                d.getId_despesa(),
                d.getTitulo(),
                d.getValor(),
                d.getData(),
                d.getCode()
            });
        });
    }
    
    public void readJtableForDesc(String titulo) throws SQLException, ClassNotFoundException  {
    DefaultTableModel modelo = (DefaultTableModel) TabelaExibir.getModel();
    modelo.setNumRows(0);
    DespesaDAO pdao = new DespesaDAO();


    pdao.readForDesc(titulo, id_usuario).stream().forEach((d) -> {
        modelo.addRow(new Object[]{
            d.getId_despesa(),
                d.getTitulo(),
                d.getValor(),
                d.getData(),
                d.getCode()
        });
    });
}
    public String converterDataParaMySQL(String texto) {
        String regex = "\\b(\\d{4})-(0?[1-9]|1[0-2])-(0?[1-9]|[12][0-9]|3[01])\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        
        if (matcher.find()) {
            String dataMySQL = matcher.group(1) + "-" + matcher.group(2) + "-" + matcher.group(3);
            return dataMySQL;
        } else {
            return null; // Retorna null se não encontrar uma data no formato especificado
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaExibir = new javax.swing.JTable();
        BotaoExcluir = new javax.swing.JButton();
        InputPesquisa = new javax.swing.JTextField();
        BotaoCadastrar = new javax.swing.JButton();
        buttonPesquisa = new javax.swing.JButton();
        BotaoAtualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        InputTitulo = new javax.swing.JTextField();
        InputValor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botaoSair = new javax.swing.JButton();
        Inputdata = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxCat = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciar Despesas");

        TabelaExibir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Titulo", "Valor", "Data", "Cod. Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaExibir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabelaExibirKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaExibir);

        BotaoExcluir.setText("Excluir");
        BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirActionPerformed(evt);
            }
        });

        InputPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPesquisaActionPerformed(evt);
            }
        });

        BotaoCadastrar.setText("Cadastrar");
        BotaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastrarActionPerformed(evt);
            }
        });

        buttonPesquisa.setText("Buscar");
        buttonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisaActionPerformed(evt);
            }
        });

        BotaoAtualizar.setText("Atualizar");
        BotaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAtualizarActionPerformed(evt);
            }
        });

        jLabel4.setText("Pesquisa(titulo)");

        jLabel1.setText("titulo");

        jLabel3.setText("valor");

        botaoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/door_out.png"))); // NOI18N
        botaoSair.setText("Sair");
        botaoSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        Inputdata.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        Inputdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputdataActionPerformed(evt);
            }
        });

        jLabel5.setText("Categoria");

        jLabel6.setText("Data(yyyy-mm-dd)");

        comboBoxCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(BotaoCadastrar)
                .addGap(18, 18, 18)
                .addComponent(BotaoExcluir)
                .addGap(30, 30, 30)
                .addComponent(BotaoAtualizar)
                .addGap(18, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InputPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(buttonPesquisa)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(InputTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(147, 147, 147)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InputValor, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Inputdata, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(108, 108, 108))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(comboBoxCat, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InputTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Inputdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoExcluir)
                        .addComponent(BotaoAtualizar)
                        .addComponent(BotaoCadastrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonPesquisa)
                        .addComponent(InputPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaExibirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaExibirKeyReleased
         if (TabelaExibir.getSelectedRow() == -1) {
        return; // Se nenhuma linha estiver selecionada, não faz nada
    }

    int dados;
    try {
        dados = (int) TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 4);
    } catch (Exception e) {
        System.err.println("Erro ao obter dados da tabela: " + e.getMessage());
        return;
    }

    CategoriaDespesaDAO cdao = new CategoriaDespesaDAO();
    List<CategoriaDespesa> categoriaDespesa;
    
    System.out.println(dados);

    // Encontrar o índice correto do comboBox
    Integer indexCategoria = null;
    for (int i = 0; i < comboBoxCat.getItemCount(); i++) {
        String item = comboBoxCat.getItemAt(i).toString();
        int itemCode = Integer.parseInt(item.split("-")[0].trim());
        if (dados == itemCode) {
            indexCategoria = i;
            break;
        }
    }

    // Atualizar campos de texto
    InputTitulo.setText(TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 1).toString());
    InputValor.setText(TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 2).toString());
    Inputdata.setText(TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 3).toString());

    // Atualizar comboBox
    if (indexCategoria != null) {
        comboBoxCat.setSelectedIndex(indexCategoria);
    }

    // Pesquisar a categoria de despesa
    try {
        categoriaDespesa = cdao.readByIdAndCode(id_usuario, dados);

        if (!categoriaDespesa.isEmpty()) {
            comboBoxCat.setSelectedItem(categoriaDespesa.get(0)); // Assumindo que a lista tenha pelo menos um item
        }
    } catch (ClassNotFoundException | SQLException ex) {
        java.util.logging.Logger.getLogger(TelaDespesaCRUD.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_TabelaExibirKeyReleased

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed

        if (TabelaExibir.getSelectedRow() != -1) {
            int id_despesa = ((int)TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 0));
            try {
                if(Controller.DespesaController.validateDespesaDelete(id_despesa)){
                      InputTitulo.setText("");
                        InputValor.setText("");
                        Inputdata.setText("");
                        readJtable();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void InputPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPesquisaActionPerformed

    private void BotaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarActionPerformed
        if(comboBoxCat.getSelectedItem() == null){
                    JOptionPane.showMessageDialog(null, "Erro: não é possivel criar uma despesa sem uma categoria");
                    return;
                }
        String[] dados = comboBoxCat.getSelectedItem().toString().split("-");
        Integer code = Integer.valueOf(dados[0].trim());
        String titulo = InputTitulo.getText();
        double valor;
        String data = Inputdata.getText();

        try {
            valor = Double.parseDouble(InputValor.getText()); // Converter o input para double
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido");
            return; 
        }

        try {
            if(Controller.DespesaController.validateDespesaCreate(titulo, valor, data, code, id_usuario)){
                InputTitulo.setText("");
                InputValor.setText("");
                Inputdata.setText("");
            }
            readJtable();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDespesaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TelaDespesaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoCadastrarActionPerformed

    private void buttonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisaActionPerformed
        System.out.println(id_usuario);
        try {
            readJtableForDesc(InputPesquisa.getText());
        } catch (SQLException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }        
        System.out.println("id usuario "+ id_usuario);;
    }//GEN-LAST:event_buttonPesquisaActionPerformed

    private void BotaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAtualizarActionPerformed

        if (TabelaExibir.getSelectedRow() != -1) {
        String[] dados = comboBoxCat.getSelectedItem().toString().split("-");
        Integer code = Integer.valueOf(dados[0].trim());
        String titulo = InputTitulo.getText();
        double valor;
        String data = Inputdata.getText();
        int id_despesa = (int) TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 0);

        try {
            valor = Double.parseDouble(InputValor.getText()); // Converter o input para double
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido");
            return; 
        }

        try {
            if (Controller.DespesaController.validateDespesaUpdate(titulo, valor, data, code, id_usuario, id_despesa)) {
                InputTitulo.setText("");
                InputValor.setText("");
                Inputdata.setText("");
            }
            readJtable();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDespesaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TelaDespesaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_BotaoAtualizarActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            new TelaMenuPrincipal(id_usuario).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_botaoSairActionPerformed

    private void InputdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputdataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputdataActionPerformed

    private void comboBoxCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDespesaCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAtualizar;
    private javax.swing.JButton BotaoCadastrar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JTextField InputPesquisa;
    private javax.swing.JTextField InputTitulo;
    private javax.swing.JTextField InputValor;
    private javax.swing.JFormattedTextField Inputdata;
    private javax.swing.JTable TabelaExibir;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton buttonPesquisa;
    private javax.swing.JComboBox<Object> comboBoxCat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}