package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class MainViewController {

    @FXML
    private MenuItem miAboutUs;

    @FXML
    private MenuItem miChangeFont;

    @FXML
    private MenuItem miCopy;

    @FXML
    private MenuItem miCut;

    @FXML
    private MenuItem miDelete;

    @FXML
    private MenuItem miExit;

    @FXML
    private MenuItem miFind;

    @FXML
    private MenuItem miHelp;

    @FXML
    private MenuItem miNew;

    @FXML
    private MenuItem miNewWindow;

    @FXML
    private MenuItem miOpen;

    @FXML
    private MenuItem miReplace;

    @FXML
    private MenuItem miSave;

    @FXML
    private MenuItem miSelectAll;

    @FXML
    private AnchorPane root;

    @FXML
    private TextArea txtNotePad;

    public void initialize(){

    }

    @FXML
    void miAboutUsOnAction(ActionEvent e) {

    }

    @FXML
    void miChangeFontOnAction(ActionEvent e) {

    }

    @FXML
    void miCopyOnAction(ActionEvent e) {

    }

    @FXML
    void miCutOnAction(ActionEvent e) {

    }

    @FXML
    void miDeleteOnAction(ActionEvent e) {

    }

    @FXML
    void miExitOnAction(ActionEvent e) {
    System.exit(1);
    }

    @FXML
    void miFindOnAction(ActionEvent e) {

    }

    @FXML
    void miHelpOnAction(ActionEvent e) {

    }

    @FXML
    void miNewOnAction(ActionEvent e) throws Exception {
        AnchorPane newSceneRoot = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Scene newScene = new Scene(newSceneRoot);
        Stage newStage = (Stage) root.getScene().getWindow();
        newStage.setScene(newScene);
        newStage.setTitle("New file");
        newStage.sizeToScene();
    }

    @FXML
    void miNewWindowOnAction(ActionEvent e) throws Exception{
        AnchorPane newWindowSceneRoot = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Scene newWindowScene = new Scene(newWindowSceneRoot);
        Stage newWindowStage = new Stage();
        newWindowStage.initModality(Modality.WINDOW_MODAL);
        newWindowStage.initOwner(root.getScene().getWindow());
        newWindowStage.setScene(newWindowScene);
        newWindowStage.setTitle("New window file");
        newWindowStage.sizeToScene();
        newWindowStage.show();
    }

    @FXML
    void miOpenOnAction(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files","*.txt"));
        fileChooser.setTitle("Select only text file");
        File textFile = fileChooser.showOpenDialog(root.getScene().getWindow());

        if(textFile != null){
            File file = new File(textFile.toURI());
            try {
                int read = -1;
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                try {
                    byte[] buffer = new byte[1024];
                    String content = "";
                    while ((read = bis.read(buffer)) != -1){
                        content += new String(buffer,0,read);
                    }
                    txtNotePad.setText(content);
                } finally {
                    bis.close();
                }
            } catch (Throwable t){
                t.printStackTrace();
            }
        } else {
            txtNotePad.setText(null);
        }
    }

    @FXML
    void miReplaceOnAction(ActionEvent e) {

    }

    @FXML
    void miSaveOnAction(ActionEvent e) {

    }

    @FXML
    void miSelectAllOnAction(ActionEvent e) {

    }

}
