import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

/**
 * <p>The applicatiewindow for a slideviewcomponent</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/01/01 Terry Ioannou
*/

public class FrameApplication extends JFrame {

	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;

	private ComponentSlides componentSlides;


	public FrameApplication(String title, Presentation presentation) {
		super(title);
		ComponentSlides componentSlides = new ComponentSlides(presentation, this);
		presentation.setShowView(componentSlides);
		setupWindow(componentSlides, presentation);
	}

//Setup the GUI
	public void setupWindow(ComponentSlides componentSlides, Presentation presentation) {
		setTitle(JABTITLE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(componentSlides);
		addKeyListener(new KeyController(presentation)); // Add a controller
		setMenuBar(new MenuController(this, presentation)); // Add another controller
		setSize(new Dimension(WIDTH, HEIGHT)); // Same sizes a slide has
		setVisible(true);
	}
}
