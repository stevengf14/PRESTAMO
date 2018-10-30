/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.prestamos.modelo;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ec.edu.espe.arquitectura.prestamos.SessionBeans.Bean_UsuariosLocal;

/**
 *
 * @author Steven
 */
@ManagedBean()
@SessionScoped
public class cls_login {

    @EJB
    Bean_UsuariosLocal bean_usuarios;
    
    String usuario;
    String contrasenia;
    String mensaje;
    
    boolean visible_login = true;
    boolean visible_menu = false;

    public cls_login() {

    }

    public void setVisible_login(boolean visible_login) {
        this.visible_login = visible_login;
    }

    public void setVisible_menu(boolean visible_menu) {
        this.visible_menu = visible_menu;
    }

    public boolean isVisible_login() {
        return visible_login;
    }

    public boolean isVisible_menu() {
        return visible_menu;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void ingresar() {
        try {
         
            if (bean_usuarios.VerificarUsuario(usuario, contrasenia)) {
                mensaje = "Usuario Encontrado";
                showMenu();
            } else {
                mensaje = "Usuario y/o Contrasenia Incorrectos";
            }

        } catch (Exception e) {

        }

    }

    public void showLogin() {
        visible_login = true;
        visible_menu = false;
    }

    public void showMenu() {
        visible_login = false;
        visible_menu = true;
    }
}
