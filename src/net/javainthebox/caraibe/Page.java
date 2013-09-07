package net.javainthebox.caraibe;

import net.javainthebox.caraibe.pagetransition.PageTransition;
import java.util.Arrays;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class Page extends Group {
    private PageTransition pageTranslator;
    
    public Page(Node... nodes) {
        double w = Constants.getInstance().getWidth();
        double h = Constants.getInstance().getHeight();
        this.setClip(new Rectangle(0, 0, w, h));

        this.getChildren().addAll(Arrays.asList(nodes));
    }
    
    public void setPageTransition(PageTransition pageTranslator) {
        if (this.pageTranslator == null) {
            this.pageTranslator = pageTranslator;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public PageTransition getPageTranslator() {
        return pageTranslator;
    }
}
