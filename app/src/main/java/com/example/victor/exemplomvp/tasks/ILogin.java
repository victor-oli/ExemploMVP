package com.example.victor.exemplomvp.tasks;

public interface ILogin {
    interface IView {
        void onUserValid();
        void onUserInvalid();
        void onUserPasswordValid();
        void onUserPasswordInvalid();
        void onLoginSuccess();
        void onLoginFail();
    }

    interface IPresenter {
        void validarLogin(String nomeUsuario, String senha);
    }
}