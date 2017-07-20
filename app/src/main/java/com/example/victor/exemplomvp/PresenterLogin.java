package com.example.victor.exemplomvp;

import com.example.victor.exemplomvp.tasks.ILogin;

public class PresenterLogin implements ILogin.IPresenter {
    private ILogin.IView view;

    public PresenterLogin(ILogin.IView view) {
        this.view = view;
    }

    @Override
    public void validarLogin(String nomeUsuario, String senha) {
        if(nomeUsuario == null || nomeUsuario.trim().isEmpty()) {
            view.onUserInvalid();

            return;
        } else
            view.onUserValid();

        if(senha == null || senha.trim().isEmpty()) {
            view.onUserPasswordInvalid();

            return;
        } else
            view.onUserPasswordValid();

        if(nomeUsuario.trim().toLowerCase().equals("admin") && senha.trim().toLowerCase().equals("123"))
            view.onLoginSuccess();
        else
            view.onLoginFail();
    }
}