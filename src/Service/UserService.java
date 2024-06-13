/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.SQLException;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author Usuario
 */
public class UserService {


    public static void create(String nome, String email, String senha) throws ClassNotFoundException, SQLException{
        Usuario u = new Usuario();
        UsuarioDAO userdao = new UsuarioDAO();

        u.setLogin(nome);
        u.setEmail(email);
        u.setSenha(senha);
        
        userdao.Create(u);
    }
    public void update(String nome, String email, int id_usuario) throws ClassNotFoundException, SQLException{
        Usuario u = new Usuario();
        UsuarioDAO userdao = new UsuarioDAO();
                
        u.setLogin(nome);
        u.setEmail(email);
        u.setId_usuario(id_usuario);

        userdao.AlterarUsuario(nome, email, id_usuario);
    }
    public void changePassword(String senha, int id_usuario) throws ClassNotFoundException, SQLException{
        Usuario u = new Usuario();
        UsuarioDAO userdao = new UsuarioDAO();

        u.setSenha(senha);
        u.setId_usuario(id_usuario);
        userdao.AlterarSenha(senha, id_usuario);

    }
    public void checkUsuario(String email, String senha) throws ClassNotFoundException, SQLException{
        Usuario u = new Usuario();
        UsuarioDAO userdao = new UsuarioDAO();
        u.setEmail(email);
        u.setSenha(senha);
        userdao.Create(u);
    }
        
}
