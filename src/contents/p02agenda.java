package contents;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;

public class p02agenda implements PageFactory {

    @Override
    public Page create() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("p02agenda.fxml"));
        
        Page page = new Page(node);
        
        return page;
    }
}
