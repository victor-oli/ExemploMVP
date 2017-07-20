package com.example.victor.exemplomvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.victor.exemplomvp.tasks.ILogin;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends Fragment implements ILogin.IView {
    @BindView(R.id.main_txt_login)
    EditText txtLogin;

    @BindView(R.id.main_txt_senha)
    EditText txtSenha;

    @BindView(R.id.main_layout_main)
    LinearLayout layoutMain;

    private ILogin.IPresenter loginPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginPresenter = new PresenterLogin(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);

        ButterKnife.bind(this, view);

        return view;
    }

    public void btnLogarOnClick(View v) {
        String login = txtLogin.getText().toString();
        String senha = txtSenha.getText().toString();

        loginPresenter.validarLogin(login, senha);
    }

    @Override
    public void onUserValid() {
        txtLogin.setError(null);
    }

    @Override
    public void onUserInvalid() {
        txtLogin.setError("o usuário é obrigatório!");
    }

    @Override
    public void onUserPasswordValid() {
        txtSenha.setError(null);
    }

    @Override
    public void onUserPasswordInvalid() {
        txtSenha.setError("a senha é obrigatória!");
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(getActivity(), OtherActivity.class));
    }

    @Override
    public void onLoginFail() {
        Snackbar.make(layoutMain, "Login ou Senha inválido!", Snackbar.LENGTH_SHORT).show();
    }
}