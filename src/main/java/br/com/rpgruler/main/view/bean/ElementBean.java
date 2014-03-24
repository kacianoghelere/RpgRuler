package br.com.rpgruler.main.view.bean;

import br.com.gmp.utils.image.ImageUtil;
import br.com.rpgruler.data.entitity.Element;
import br.com.rpgruler.main.view.ElementView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author kaciano
 */
public class ElementBean {

    private ElementView elementView;

    public ElementBean(ElementView elementView) {
        this.elementView = elementView;
    }

    public void addElement() {
        elementView.getModel().add(new Element(Integer.SIZE, null, null));
    }

    public void removeElement() {

    }

    /**
     *
     * @return
     */
    public List<Element> getDefaultElements() {
        List<Element> data = new ArrayList<>();
        data.add(new Element(1, "Fogo", "/RpgIcons/fire.png"));
        data.add(new Element(2, "Água", "/RpgIcons/water.png"));
        data.add(new Element(3, "Vento", "/RpgIcons/wind.png"));
        data.add(new Element(4, "Terra", "/RpgIcons/earth.png"));
        data.add(new Element(5, "Luz", "/RpgIcons/light.png"));
        data.add(new Element(6, "Sombra", "/RpgIcons/dark.png"));
        data.add(new Element(7, "Alquimia", "/RpgIcons/alchemy.png"));
        return data;
    }
    
    public String[] getElementImages() {
        return new String[]{"/RpgIcons/fire.png",
            "/RpgIcons/water.png",
            "/RpgIcons/wind.png",
            "/RpgIcons/earth.png",
            "/RpgIcons/light.png",
            "/RpgIcons/dark.png",
            "/RpgIcons/alchemy.png"};
    }

    public ImageIcon[] getElementsIcons() {
        ImageIcon[] icons = new ImageIcon[getElementImages().length];
        for (int i = 0; i < getElementImages().length; i++) {
            icons[i] = new ImageIcon(getClass().getResource(getElementImages()[i]));
            icons[i].setImage(new ImageUtil().getScaledImage(icons[i].getImage(), 20, 20));
        }
        return icons;
    }

    public ElementView getElementView() {
        return elementView;
    }

    public void setElementView(ElementView elementView) {
        this.elementView = elementView;
    }

}
