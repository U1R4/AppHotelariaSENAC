package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import view.components.Buttons;
import view.components.Sidebar;

public class CadFuncionario extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane mainPane = new BorderPane();
        mainPane.setStyle("-fx-background-image: url(/view/resources/img/BackGroundMainPane.jpg);");


        Buttons buttons = new Buttons();
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(20,20,20,20));

        Sidebar sidebar = new Sidebar();
        mainPane.setLeft(sidebar);

        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansRegular.ttf"), 12);
        Font fontSemiBold = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansSemiBold.ttf"), 12);

        String styleSemiBold = "-fx-text-fill: #000000;" +
                "-fx-font-size: 18;" +
                "-fx-font-family: '" + fontSemiBold.getFamily() + "';";

        String styleRegular = "-fx-text-fill: #000000;" +
                "-fx-font-size: 12;" +
                "-fx-font-family: '" + fontRegular.getFamily() + "';";



        Image logo = new Image(getClass().getResourceAsStream("/view/resources/img/raccoonIcon.png"));

        Image iconBtnFunc = new Image(getClass().getResourceAsStream("/view/resources/img/Funcionario.png"));
        ImageView iconPessoa = new ImageView(iconBtnFunc);
        iconPessoa.setFitWidth(20);
        iconPessoa.setFitHeight(20);

        Label lblTitulo = new Label("Cadastro de Funcionários");
        lblTitulo.setStyle(styleSemiBold);
        HBox tituloBox = new HBox(iconPessoa, lblTitulo);
        tituloBox.setPadding(new Insets(20,20,20,20));
        tituloBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome do Funcionário");
        lblNome.setStyle(styleRegular);
        TextField txtNome = new TextField();
        txtNome.setMaxWidth(250);

        Label lblSenha = new Label("Senha do Funcionário");
        lblSenha.setStyle(styleRegular);
        TextField txtSenha = new TextField();
        txtSenha.setMaxWidth(250);

        Label lblEmail = new Label("Email");
        lblEmail.setStyle(styleRegular);
        TextField txtEmail = new TextField();


        ComboBox emailOpt = new ComboBox();
        emailOpt.getItems().addAll("@gmail.com", "@email.com","@yahoo.com");
        emailOpt.setMinWidth(115);

        Label lblrg = new Label("RG do Funcionário");
        TextField txtRg = new TextField();
        txtRg.setMaxWidth(250);

        Label lblbox = new Label("Setor do Funcionário");
        lblbox.setFont(Font.font(fontRegular.getFamily(), 20));
        lblbox.setStyle("-fx-text-fill: #000000; -fx-font-size: 12;");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Limpeza", "Organizção", "Segurança","TI","Professor","Diretor","Cordenador","Cozinha","Gestão");
        comboBox.setValue("Selecione uma opção");
        Label resulBox = new Label("Opção selecionada: Nenhuma");
        comboBox.setOnAction(e -> {
            String selecionado = comboBox.getValue();
            resulBox.setText("Opção selecionada: " + selecionado);
        });
        comboBox.setMaxWidth(250);

        GridPane gridEmail = new GridPane();
        gridEmail.add(txtEmail, 1, 0);
        gridEmail.add(emailOpt, 2, 0);
        gridEmail.setMaxWidth(250);

        GridPane fromGrid = new GridPane();
        fromGrid.setAlignment(Pos.CENTER);
        fromGrid.add(lblNome, 0, 0);
        fromGrid.add(txtNome, 1, 0);
        fromGrid.add(lblSenha, 0, 1);
        fromGrid.add(txtSenha, 1, 1);
        fromGrid.add(lblEmail, 0, 2);
        fromGrid.add(gridEmail, 1, 2);
        fromGrid.add(lblbox, 0, 3);
        fromGrid.add(comboBox, 1, 3);
        fromGrid.setHgap(10);
        fromGrid.setVgap(10);

        VBox layout = new VBox(tituloBox, fromGrid, buttons);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 800,600);
        stage.getIcons().add(logo);
        stage.setTitle("Raccoon Hotel");
        stage.setScene (scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}