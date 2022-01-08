
import java.awt.*;

class FontChooserFrame extends FontChooser {
    public FontChooserFrame() {
        m_font = FontChooser.showDialog(this, "Wybierz Czcionkę");
   }
    Font m_font;
}

