import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewContainer {

    private static ViewContainer vC;

    private TextField sizeATxt, sizeBTxt;
    private Label timeLbl, intersectionLbl;
    private Button runBtn;


    private ViewContainer(){

    }

    public static ViewContainer getView(){
        if(vC == null){
            vC = new ViewContainer();
        }
        return vC;
    }


    public static void setvC(ViewContainer vC) {
        ViewContainer.vC = vC;
    }

    public void buildView(Stage stage){

        BorderPane bP = new BorderPane();

        Label sizeALbl = new Label("Size of List A");
        sizeATxt = new TextField("0");

        Label sizeBLbl = new Label("Size of List B");
        sizeBTxt = new TextField("0");

        Label hashLbl = new Label("Lists");



        Label timeTitleLbl = new Label("Time in Milliseconds: ");
        timeLbl = new Label("XX");

        Label intersectionSizeLbl = new Label("Intersections");
        intersectionLbl = new Label("XX");

        runBtn = new Button("Run");


        VBox left = new VBox();
        left.getChildren().addAll(sizeALbl,sizeATxt);
        VBox right = new VBox();
        right.getChildren().addAll(sizeBLbl,sizeBTxt);

        VBox top = new VBox();
        top.getChildren().add(hashLbl);

        HBox bottom = new HBox(intersectionSizeLbl,intersectionLbl,timeTitleLbl,timeLbl,runBtn);
        bottom.setSpacing(10);

        bP.setTop(top);
        bP.setLeft(left);
        bP.setRight(right);
        bP.setBottom(bottom);


        bP.setStyle("-fx-background-color: lightgrey; -fx-fill: black;");

        Scene scene = new Scene(bP,300,100);


        stage.setScene(scene);
        stage.show();
    }

    public TextField getSizeATxt() {
        return sizeATxt;
    }

    public TextField getSizeBTxt() {
        return sizeBTxt;
    }

    public Label getTimeLbl() {
        return timeLbl;
    }

    public Button getRunBtn() {
        return runBtn;
    }

    public Label getIntersectionLbl() {
        return intersectionLbl;
    }
}
