
package contents;

import net.javainthebox.caraibe.Direction;
import net.javainthebox.caraibe.pagetransition.SlideInOutPageTransition;

public class Configuration extends net.javainthebox.caraibe.Configuration {
    {
        factories = new String[] {
            "contents.p01title",
            "contents.p02agenda",
            "contents.p03conclusion",
        };

        width = 1024;
        height = 768;
        defaultPageTransition = new SlideInOutPageTransition(Direction.BOTTOM);
    }
}
