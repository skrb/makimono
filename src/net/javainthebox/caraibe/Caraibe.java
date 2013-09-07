package net.javainthebox.caraibe;

import java.io.IOException;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import contents.Configuration;

public class Caraibe extends Application {
    private Stage stage;
    
    private Cylinder cylinder;
    private double angle = 360.0;
    
    @Override
    public void start(Stage stage) {
        configuration();
        
        Constants constants = Constants.getInstance();
        
        this.stage = stage;
        
        Group root = new Group();
        
        Scene scene = new Scene(root, constants.getWidth(), constants.getHeight());
        scene.setCamera(new PerspectiveCamera());
        scene.setFill(null);
        stage.setScene(scene);
        
        try {
            Binder binder = new Binder(this, constants.getFactories());
            binder.setClip(new Rectangle(12, 0, 1000, 740));
            root.getChildren().add(binder);
            root.getChildren().add(createCylinder());

            binder.loadInitialPage();
        } catch (IOException ex) {
            root.getChildren().add(new Label("IOError"));
        }

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
    
    private void configuration() {
        Configuration config = new Configuration();
        Constants constants = Constants.getInstance();
        constants.init(config);
    }

    public void minimize() {
        stage.setIconified(true);
    }
    
    private Node createCylinder() {
        cylinder = new Cylinder(40, 1000.0);
        Rotate rotate = Transform.rotate(90, 0, 0);
        cylinder.getTransforms().add(rotate);
        cylinder.setTranslateX(510);
        cylinder.setTranslateY(740);

        PhongMaterial mat = new PhongMaterial();
        Image diffuseMap = new Image(getClass().getResource("images.jpg").toString());
        mat.setDiffuseMap(diffuseMap);
        cylinder.setMaterial(mat);

        return cylinder;
    }
    
    public void roll() {
        angle *= 1.1;
        
        RotateTransition trans = new RotateTransition(Duration.millis(2_000));
        trans.setAxis(new Point3D(1.0, 0.0, 0.0));
        trans.setNode(cylinder);
        trans.setByAngle(angle);
        trans.setInterpolator(Interpolator.LINEAR);
        trans.play();
        
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.millis(2_000),
                         new KeyValue(cylinder.radiusProperty(), cylinder.getRadius()*.95))
        );
        timeline.play();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
