package stages;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.DB;
import util.Strings;

public class CadastroUserStage {
	private Button btAdd, btLogin;
	private TextField txtUser;
	private PasswordField txtPass;
	
	public CadastroUserStage(Stage stage) {
		
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(160, 200);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		
		txtUser = new TextField();
		txtUser.setLayoutX(10);
		txtUser.setLayoutY(10);
		txtUser.setMaxWidth(150);
		txtUser.setMinWidth(150);
		txtUser.setPrefWidth(150);
		txtUser.setPromptText(Strings.username);
		
		txtPass = new PasswordField();
		txtPass.setLayoutX(10);
		txtPass.setLayoutY(50);
		txtPass.setMaxWidth(150);
		txtPass.setMinWidth(150);
		txtPass.setPrefWidth(150);
		txtPass.setPromptText(Strings.password);
		
		btAdd = new Button(Strings.btCadastro);
		btAdd.setLayoutX(10);
		btAdd.setLayoutY(130);
		btAdd.setMaxWidth(150);
		btAdd.setMinWidth(150);
		btAdd.setPrefWidth(150);
		
		btLogin = new Button(Strings.btLogin);
		btLogin.setLayoutX(10);
		btLogin.setLayoutY(90);
		btLogin.setMaxWidth(150);
		btLogin.setMinWidth(150);
		btLogin.setPrefWidth(150);
		
		btLogin.setOnMouseClicked(e -> {
			
				if (txtUser.getText().equals("admin") ||txtPass.getText().equals("admin")) {
					new AdministratorStage(new Stage());
					stage.close();
				}else {
					
					showLoginError();
				}
				
			
		});

		btAdd.setOnMouseClicked(e -> {
			
			if (txtUser.getText().equals("") || (txtPass.getText().equals(""))) {
				showRegisterError();
				
			}else {
				DB.users.addUser(txtUser.getText(), txtPass.getText());
				stage.close();	
			}
			
			
		});
		
		pane.getChildren().add(btLogin);
		pane.getChildren().add(btAdd);
		pane.getChildren().add(txtUser);
		pane.getChildren().add(txtPass);
		
		stage.setResizable(false);
		stage.show();
	}
	
	private void showRegisterError() {
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro 2");
        alert.setHeaderText("Nada inserido");
        alert.setContentText("Tente novamente.");
        alert.showAndWait();
	}
	
	private void showLoginError() {
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Login e/ou senha inválidos");
        alert.setContentText("Tente novamente.");
        alert.showAndWait();
	}
}
