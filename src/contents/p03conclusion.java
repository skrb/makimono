package contents;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;

public class p03conclusion implements PageFactory {

    @Override
    public Page create() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("p03conclusion.fxml"));
        
        Page page = new Page(node);
        
        return page;
    }
}
