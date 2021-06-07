import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;



public class MainFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ViewContainer.getView().buildView(primaryStage);
        ViewContainer.getView().getRunBtn().setOnAction(e->{
           try{

                int sizeA = Integer.valueOf(ViewContainer.getView().getSizeATxt().getText());
                int sizeB = Integer.valueOf(ViewContainer.getView().getSizeBTxt().getText());
                ViewContainer.getView().getRunBtn().setDisable(true);
                ListIntersecter lI = new ListIntersecter(sizeA,sizeB);
            } catch (NumberFormatException nFE){
                nFE.printStackTrace();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Something went wrong with your Input");
                alert.setContentText("Use Integers only");
                alert.show();
            }





        });

    }
}
