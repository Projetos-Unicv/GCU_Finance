/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author heyto
 */
public class UsuarioController {
    
    public static void validateUserRegistration(String nome, String email, String senha, String confirmarSenha) throws ClassNotFoundException, SQLException{
        if(Service.Validations.Usuario.ValidateCreateUserService.validateCreateUser(nome, email, senha, confirmarSenha)){
            Service.RepositoryService.UsuarioRepositoriyService.create(nome, email, senha);
        }
    }
    public static void AlterarInfo(String NomeNovo, String EmailNovo, int id_usuario) throws ClassNotFoundException, SQLException{
       if(Service.Validations.Usuario.ValidationUserUpdate.validateUserUpdate(NomeNovo, EmailNovo, id_usuario)){
        Service.RepositoryService.UsuarioRepositoriyService.chargeUserInfo(NomeNovo, EmailNovo, id_usuario);
    }
    }
    public static void AlterarSenha(String AntigaSenhaDB, String AntigaSenhaInput, String SenhaInput, String SenhaInputConfirme, int id_usuario) throws SQLException, ClassNotFoundException{
        if(Service.Validations.Usuario.ValidationPassawordService.validatePasswordUpdate(AntigaSenhaDB, AntigaSenhaInput, SenhaInput, SenhaInputConfirme, id_usuario)){
           Service.RepositoryService.UsuarioRepositoriyService.chargePassword(SenhaInput, id_usuario);
       }
    }
    public static void ApagarTodososdados(int id_usuario) throws ClassNotFoundException, SQLException{
        try {
            JOptionPane.showMessageDialog(null,"Todos os registros foram apagados com sucesso!");
            Service.RepositoryService.UsuarioRepositoriyService.DeleteAllRegisters(id_usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
