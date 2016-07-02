/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;

/**
 *
 * @author DiegoAvila
 */
public class DialogosJavaFX extends Application {

    /**
     * Método que exibe uma informação na tela.
     *
     * @param titulo
     * @param descricao
     * @param complemento
     */
    public void informacao(String titulo, String descricao, String complemento) {
        Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
        dialogo.setTitle(titulo);
        dialogo.setHeaderText(descricao);
        dialogo.setContentText(complemento);
        /**
         * A linha a baixo é opcional, caso queira alterar o icone padrão.
         * Aconcelho colocar imagens de 60px, 60px.
         */
        //dialogo.setGraphic(new ImageView("10.png"));

        // Localizo o arquivo css.
        dialogo.getDialogPane().getStylesheets().add("Dialogos.css");
        // Defino a classe que ele pertence.
        dialogo.getDialogPane().getStyleClass().add("dialog-pane");
        // Executa o DialogPane.
        dialogo.showAndWait();
    }

    /**
     * Método que exibe uma mensagem de erro
     *
     * @param titulo
     * @param descricao
     * @param complemento
     */
    public void erro(String titulo, String descricao, String complemento) {
        Alert dialogo = new Alert(Alert.AlertType.ERROR);
        dialogo.setTitle(titulo);
        dialogo.setHeaderText(descricao);
        dialogo.setContentText(complemento);
        /**
         * A linha a baixo é opcional, caso queira alterar o icone padrão.
         * Aconcelho colocar imagens de 60px, 60px.
         */
        //dialogo.setGraphic(new ImageView("10.png"));
        // Localizo o arquivo css.
        dialogo.getDialogPane().getStylesheets().add("Dialogos.css");
        // Defino a classe que ele pertence.
        dialogo.getDialogPane().getStyleClass().add("dialog-pane");
        // Executa o DialogPane.
        dialogo.showAndWait();
    }

    /**
     * Método que exibe uma mensagem de atenção
     *
     * @param titulo
     * @param descricao
     * @param complemento
     */
    public void atencao(String titulo, String descricao, String complemento) {
        Alert dialogo = new Alert(Alert.AlertType.WARNING);
        dialogo.setTitle(titulo);
        dialogo.setHeaderText(descricao);
        dialogo.setContentText(complemento);
        /**
         * A linha a baixo é opcional. Ela serve para alterar o icone padrão.
         * Aconcelho colocar imagens de 60px, 60px.
         */
        //dialogo.setGraphic(new ImageView("10.png"));
        // Localizo o arquivo css.
        dialogo.getDialogPane().getStylesheets().add("Dialogos.css");
        // Defino a classe que ele pertence.
        dialogo.getDialogPane().getStyleClass().add("dialog-pane");
        // Executa o DialogPane.
        dialogo.showAndWait();
    }

    /**
     * Método que exibe um botão de confirmação Retorna um boleano
     *
     * @param titulo
     * @param descricao
     * @param complemento
     * @return
     */
    public boolean confirmacao(String titulo, String descricao, String complemento) {
        boolean retorno = false;
        Alert dialogo = new Alert(Alert.AlertType.CONFIRMATION);
        dialogo.setTitle(titulo);
        dialogo.setHeaderText(descricao);
        dialogo.setContentText(complemento);
        /**
         * A linha a baixo é opcional. Ela serve para alterar o icone padrão.
         * Aconcelho colocar imagens de 60px, 60px.
         */
        //dialogo.setGraphic(new ImageView("10.png"));
        // Localizo o arquivo css.
        dialogo.getDialogPane().getStylesheets().add("Dialogos.css");
        // Defino a classe que ele pertence.
        dialogo.getDialogPane().getStyleClass().add("dialog-pane");

        // Aqui foi criado um objeto resultado do tipo ButtonType.
        // Ele tem a finalidade de verificar qual botão foi clicado.
        Optional<ButtonType> resultado = dialogo.showAndWait();
        // Se o botão clicado for o ButtonType.OK ele retorna true.
        retorno = resultado.get() == ButtonType.OK;
        // Se não ele retorna false.
        // A função só cai aqui se for clicado o ButtonType.CANCEL.
        return retorno;
    }

    /**
     * Método que exibe a opção de sim ou não Retorna um byte. Sim =1, Não = 2,
     * Cancelar = 0
     *
     * @param titulo
     * @param descricao
     * @param complemento
     * @return
     */
    public byte simNao(String titulo, String descricao, String complemento) {
        byte retorno = 0;
        Alert dialogo = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType btnSim = new ButtonType("Sim");
        ButtonType btnNao = new ButtonType("Não");
        dialogo.setTitle(titulo);
        dialogo.setHeaderText(descricao);
        dialogo.setContentText(complemento);
        /**
         * A linha a baixo é opcional. Ela serve para alterar o icone padrão.
         * Aconcelho colocar imagens de 60px, 60px.
         */
        //dialogo.setGraphic(new ImageView("10.png"));
        // Localizo o arquivo css.
        dialogo.getDialogPane().getStylesheets().add("Dialogos.css");
        // Defino a classe que ele pertence.
        dialogo.getDialogPane().getStyleClass().add("dialog-pane");
        dialogo.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        // Aqui foi criado um objeto resultado do tipo ButtonType.
        // Ele tem a finalidade de verificar qual botão foi clicado.
        Optional<ButtonType> resultado = dialogo.showAndWait();
        if (resultado.get() == ButtonType.OK) {
            // Se o botão clicado for o ButtonType.OK ele retorna 1.
            retorno = 1;
        } else if (resultado.get() == ButtonType.NO) {
            // Se o botão clicado for o ButtonType.NO ele retorna 2.
            retorno = 2;
        } else {
            // A função só cai aqui se for clicado o ButtonType.CANCEL.
            retorno = 0;
        }
        return retorno;
    }

    /**
     * Método que exibe 3 opções de botões Retorna um byte Botão1 = 1, Botão2 =
     * 2, Botão3 = 3, cancelar = 0
     *
     * @param titulo
     * @param descricao
     * @param complemento
     * @param botao1
     * @param botao2
     * @param botao3
     * @return
     */
    public byte tresOpcoes(String titulo, String descricao, String complemento, String botao1, String botao2, String botao3) {
        byte retorno = 0;
        Alert dialogo = new Alert(Alert.AlertType.CONFIRMATION);
        dialogo.setTitle(titulo);
        dialogo.setHeaderText(descricao);
        dialogo.setContentText(complemento);
        /**
         * A linha a baixo é opcional. Ela serve para alterar o icone padrão.
         * Aconcelho colocar imagens de 60px, 60px.
         */
        //dialogo.setGraphic(new ImageView("10.png"));
        // Localizo o arquivo css.
        dialogo.getDialogPane().getStylesheets().add("Dialogos.css");
        // Defino a classe que ele pertence.
        dialogo.getDialogPane().getStyleClass().add("dialog-pane");
        // Como esta função precisa de 3 botões mais o cancelar.
        // E crio os tres como ButtonType.
        ButtonType botaoUm = new ButtonType(botao1);
        ButtonType botaoDois = new ButtonType(botao2);
        ButtonType botaoTres = new ButtonType(botao3);
        dialogo.getButtonTypes().setAll(botaoUm, botaoDois, botaoTres, ButtonType.CANCEL);
        // Aqui foi criado um objeto resultado do tipo ButtonType.
        // Ele tem a finalidade de verificar qual botão foi clicado.
        Optional<ButtonType> resultado = dialogo.showAndWait();
        if (resultado.get() == botaoUm) {
            // Só entra nesta condição se for o botaoUm e retorna 1.
            retorno = 1;
        } else if (resultado.get() == botaoDois) {
            // Só entra nesta condição se for o botaoDois e retorna 2.
            retorno = 2;
        } else if (resultado.get() == botaoTres) {
            // Só entra nesta condição se for o botaoTres e retorna 3.
            retorno = 3;
        } else {
            // Só entra nesta condição se for o ButtonType.CANCEL e retorna 0.
            retorno = 0;
        }
        return retorno;
    }

    /**
     * Método que valida um login Retorna um boleano true se a verificação bater
     * Se não bater, chama ele mesmo novamente
     *
     * @param titulo
     * @param descricao
     * @param complemento
     * @param promptTexto
     * @return
     */
    public boolean validaLogin(String titulo, String descricao, String complemento, String promptTexto) {
        boolean retorno = false;
        Dialog dialogo = new Dialog<>();
        dialogo.setTitle(titulo);
        dialogo.setHeaderText(descricao);
        /**
         * A linha a baixo é opcional. Ela serve para alterar o icone padrão.
         * Aconcelho colocar imagens de 60px, 60px.
         */
        //dialogo.setGraphic(new ImageView("10.png"));
        // Localizo o arquivo css.
        dialogo.getDialogPane().getStylesheets().add("Dialogos.css");
        // Defino a classe que ele pertence.
        dialogo.getDialogPane().getStyleClass().add("dialog-pane");
        dialogo.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        // Crio o GridPane para alinhar o campo de login e senha.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        //crio os labels e os txtfields.
        TextField txtLogin = new TextField();
        txtLogin.setFont(Font.font("Arial", 14));
        txtLogin.setPromptText("Login");
        PasswordField txtSenha = new PasswordField();
        txtSenha.setFont(Font.font("Arial", 14));
        txtSenha.setPromptText("Senha");
        Label lblLogin = new Label("Login:");
        lblLogin.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Label lblSenha = new Label("Senha:");
        lblSenha.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        // posiciono os mesmos no GridPane.
        grid.add(lblLogin, 0, 0);
        grid.add(txtLogin, 1, 0);
        grid.add(lblSenha, 0, 1);
        grid.add(txtSenha, 1, 1);
        // Adiciono o GridPane no Dialog.
        dialogo.getDialogPane().setContent(grid);
        // Aqui foi criado um objeto resultado do tipo ButtonType.
        // Ele tem a finalidade de verificar qual botão foi clicado.
        Optional<ButtonType> resultado = dialogo.showAndWait();
        if (resultado.get() == ButtonType.OK) {
            /**
             * Se o botão clicado foi ButtonType.OK ele verifica se o login e a
             * senha correspondem com o inserido. Se sim, ele retorna true. Se
             * não ele retorna ele chama a si mesmo novamente.
             */
            if ((!"".equals(txtLogin.getText())) && (!"".equals(txtSenha.getText()))) {
                if (txtLogin.getText().equalsIgnoreCase("admin") && txtSenha.getText().equalsIgnoreCase("admin")) {
                    retorno = true;
                } else {
                    // Login e senha não bateram. Chama a si mesmo novamente.
                    validaLogin(titulo, descricao, complemento, promptTexto);
                }
            } else {
                // Os campos estão vazios. Chama a si mesmo novamente.
                validaLogin(titulo, descricao, complemento, promptTexto);
            }
        } else {
            // Botão ButtonType.CANCEL foi clicado e sai do dialogo.
            retorno = false;
        }
        return retorno;
    }

    /**
     * Método que exibe uma lista de erros(Exception)
     *
     * @param titulo
     * @param descricao
     * @param complemento
     * @param ex
     */
    public void ExibeErro(String titulo, String descricao, String complemento, Exception ex) {
        Alert dialogo = new Alert(AlertType.ERROR);
        dialogo.setTitle(titulo);
        dialogo.setHeaderText(descricao);
        dialogo.setContentText(complemento);
        /**
         * A linha a baixo é opcional, caso queira alterar o icone padrão.
         * Aconcelho colocar imagens de 60px, 60px.
         */
        //dialogo.setGraphic(new ImageView("10.png"));
        // Localizo o arquivo css.
        dialogo.getDialogPane().getStylesheets().add("Dialogos.css");
        // Defino a classe que ele pertence.
        dialogo.getDialogPane().getStyleClass().add("dialog-pane");
        // Aqui ele transfere o erro para uma String
        String exceptionText = ex.toString();
        Label label = new Label("Lista de erros encontrados:");
        // Cria o TextArea que recebe a String do erro.
        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        // Cria um botãozinho que expande para ver a lista de erros.
        dialogo.getDialogPane().setExpandableContent(expContent);
        dialogo.showAndWait();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //informacao("Titulo", "Descrição", "Complemento");
        //erro("Titulo", "Descrição", "Complemento");
        //atencao("Titulo", "Descrição", "Complemento");
        //System.out.println(confirmacao("Titulo", "Descrição", "Complemento"));
        //System.out.println(simNao("Titulo", "Descrição", "Complemento"));
        //System.out.println(tresOpcoes("Titulo", "Descrição", "complemento", "BotãoUm", "BotãoDois", "BotãoTres"));
        //System.out.println(validaLogin("Titulo", "Obrigatório", "Digite seu nome malandro", "Digite Seu Nome"));
        //Exception ex = new Exception("Deu erro");
        //ExibeErro("Titulo", "Descrição", "Complemento",ex);
         
    }

}
