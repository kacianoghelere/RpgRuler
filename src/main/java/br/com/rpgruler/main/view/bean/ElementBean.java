package br.com.rpgruler.main.view.bean;

import br.com.gmp.utils.image.ImageUtil;
import br.com.rpgruler.data.entitity.Effect;
import br.com.rpgruler.data.entitity.Element;
import br.com.rpgruler.main.view.ElementView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author kaciano
 */
public class ElementBean extends DefaultViewBean<ElementView> {

    private ElementView elementView;

    public ElementBean(ElementView elementView) {
        super(elementView);
        this.elementView = elementView;
    }

    public void addElement(String title, int symbol) {
        Long id = Long.MIN_VALUE;
        for (Element element : elementView.getModel().getData()) {
            id = element.getId() > id ? element.getId() : id;
        }
        elementView.getModel().add(new Element(id, title, getImages()[symbol]));
    }

    public void removeElement() {

    }

    /**
     *
     * @return
     */
    public List<Element> getElements() {
        List<Element> data = new ArrayList<>();

        List<Element> elements = getElement();
        for (int i = 0; i < elements.size(); i++) {
            data.add(elements.get(i));
        }
        return data;
    }

    public List<Element> getElement() {
        List<Element> data = new ArrayList<>();
        String[] images = getImages();
        for (int i = 0; i < 7; i++) {
            data.add(new Element((long) i, i + "", images[i]));
        }
        return data;
    }

    public Effect[] getEffects() {
        Effect[] array = new Effect[4];
        array[0] = (new Effect((long) 0, "Aumento", 20));
        array[1] = (new Effect((long) 1, "Reduçao", 20));
        array[2] = (new Effect((long) 2, "Parada", 10));
        array[3] = (new Effect((long) 3, "Aceleraçao", 10));
        return array;
    }

    public String[] getImages() {
        return new String[]{"/RpgIcons/fire.png",
            "/RpgIcons/water.png",
            "/RpgIcons/wind.png",
            "/RpgIcons/earth.png",
            "/RpgIcons/light.png",
            "/RpgIcons/dark.png",
            "/RpgIcons/alchemy.png"};
    }

    public ImageIcon[] getElementsIcons() {
        ImageIcon[] icons = new ImageIcon[getImages().length];
        for (int i = 0; i < getImages().length; i++) {
            icons[i] = new ImageIcon(getClass().getResource(getImages()[i]));
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
