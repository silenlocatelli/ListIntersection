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
    private RadioButton rb1, rb2;


    private ViewContainer(){

    }

    public static ViewContainer getView(){
        if(vC == null){
            vC = new ViewContainer();
        }
        return vC;
    }




    public void buildView(Stage stage){

        BorderPane bP = new BorderPane();

        ToggleGroup tG = new ToggleGroup();
        rb1 = new RadioButton();
        rb1.setToggleGroup(tG);
        rb1.setSelected(true);
        rb2 = new RadioButton();
        rb2.setToggleGroup(tG);

        Label hashLbl = new Label("<-List to hash->");

        Label sizeALbl = new Label("Size of List A");
        sizeATxt = new TextField("0");

        Label sizeBLbl = new Label("Size of List B");
        sizeBTxt = new TextField("0");


        Label timeTitleLbl = new Label("Time in Milliseconds: ");
        timeLbl = new Label("XX");

        Label intersectionSizeLbl = new Label("Intersections");
        intersectionLbl = new Label("XX");

        runBtn = new Button("Run");


        VBox left = new VBox();
        left.getChildren().addAll(sizeALbl,sizeATxt);
        VBox right = new VBox();
        right.getChildren().addAll(sizeBLbl,sizeBTxt);

        HBox top = new HBox();
        top.getChildren().addAll(rb1,hashLbl,rb2);
        top.setSpacing(110);

        HBox bottom = new HBox(intersectionSizeLbl,intersectionLbl,timeTitleLbl,timeLbl,runBtn);
        bottom.setSpacing(20);

        bP.setTop(top);
        bP.setLeft(left);
        bP.setRight(right);
        bP.setBottom(bottom);


        bP.setStyle("-fx-background-color: lightgrey; -fx-fill: black;");

        Scene scene = new Scene(bP,400,100);


        stage.setScene(scene);
        stage.show();
    }

    public RadioButton getRb1() {
        return rb1;
    }

    public RadioButton getRb2() {
        return rb2;
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
