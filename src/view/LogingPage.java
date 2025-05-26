package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LogingPage extends Application {

    public void start(Stage stage) throws Exception{
        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansRegular.ttf"), 12);
        Font fontSemiBold = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansSemiBold.ttf"), 12);

        Image logo = new Image(getClass().getResourceAsStream("/view/resources/img/raccoonIcon.png"));

        Image eye = new Image(getClass().getResourceAsStream("/view/resources/img/eyeOpen.png"));
        ImageView eyeOpenView = new ImageView(eye);
        eyeOpenView.setFitWidth(15);
        eyeOpenView.setFitHeight(15);

        Image eyeClosed = new Image(getClass().getResourceAsStream("/view/resources/img/invisibleEye.png"));
        ImageView eyeClosedView = new ImageView(eyeClosed);
        eyeClosedView.setFitWidth(15);
        eyeClosedView.setFitHeight(15);

        Image backGround = new Image(getClass().getResourceAsStream("/view/resources/img/guaxininLogin.jpg"));
        ImageView viewBackGound = new ImageView(backGround);
        viewBackGound.setFitWidth(400);
        VBox image = new VBox(viewBackGound);

        Button eyeClose = new Button();
        eyeClose.setGraphic(eyeOpenView);
        eyeClose.setStyle("-fx-background-color: transparent;");
        eyeClose.setMaxSize(15,15);


        Label labelLogin = new Label("Faça seu login");
        labelLogin.setFont(fontSemiBold);
        labelLogin.setStyle("-fx-font-size: 30;");
        labelLogin.setAlignment(Pos.CENTER);

        Label email = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        txtEmail.setMaxWidth(200);
        txtEmail.setPromptText("E-mail");

        Label senha = new Label("Senha: ");
        PasswordField passSenha =new PasswordField();
        passSenha.setMaxWidth(200);
        passSenha.setPromptText("Digite sua senha");

        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite sua senha");

        StackPane senha123 = new StackPane();
        senha123.setPrefWidth(200);
        senha123.getChildren().addAll(txtSenha, passSenha, eyeClose);
        StackPane.setMargin(eyeClose, new Insets(0, 0, 0, 165));

        final boolean[] clicado = {false};
        eyeClose.setOnMouseClicked(evento -> {
            if (clicado[0]) {
                eyeClose.setGraphic(eyeOpenView);

                passSenha.setText(txtSenha.getText());
                passSenha.setVisible(true);
                passSenha.setManaged(true);
                txtSenha.setVisible(false);

            } else {
                eyeClose.setGraphic(eyeClosedView);

                txtSenha.setText(passSenha.getText());
                txtSenha.setVisible(true);
                txtSenha.setManaged(true);
                passSenha.setVisible(false);

            }
            clicado[0] = !clicado[0];
        });

        String styleButton2 = "-fx-text-fill: black;-fx-font-size: 14px;-fx-background-color: transparent;-fx-cursor: hand;" + "-fx-font-family: '" + fontRegular.getFamily() + "';"+"-fx-border-radius: 15px;-fx-background-radius: 15px";

        Button btnEsqueci = new Button("Esqueci minha senha!");
        btnEsqueci.setStyle(styleButton2);
        btnEsqueci.setFont(fontSemiBold);

        btnEsqueci.setOnMouseEntered(evento ->
                btnEsqueci.setStyle(styleButton2.replace("black", "#163083")));
        btnEsqueci.setOnMouseExited(evento -> btnEsqueci.setStyle(styleButton2));

        GridPane info = new GridPane();

        info.add(email,0,2);
        info.add(txtEmail,1,2);

        info.add(senha,0,3);
        info.add(senha123,1,3);

        info.setHgap(10);
        info.setVgap(10);
        info.setAlignment(Pos.CENTER);




        Button entrar = new Button("Login");
        entrar.setMaxWidth(150);


        String styleButton = "-fx-background-color: #8D9BA4;"+
                "-fx-border-color: transparent;"+
                "-fx-graphic-text-gap: 10px;"+
                "-fx-cursor: hand;" +
                "-fx-font-size: 14;" +
                "-fx-font-family: '" + fontRegular.getFamily() + "';"+"-fx-border-radius: 15px;-fx-background-radius: 15px";

        entrar.setStyle(styleButton);

        entrar.setOnMouseEntered(evento ->
                entrar.setStyle(styleButton.replace("#8D9BA4", "#7e8b93")));
        entrar.setOnMouseExited(evento -> entrar.setStyle(styleButton));


        VBox login = new VBox(labelLogin,info,entrar,btnEsqueci);
        login.setAlignment(Pos.CENTER);
        login.setSpacing(20);
        login.setPrefWidth(400);

        HBox main = new HBox(image,login);



        Scene scene = new Scene(main, 800,600);
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
