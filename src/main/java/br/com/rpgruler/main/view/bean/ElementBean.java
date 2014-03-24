package br.com.rpgruler.main.view.bean;

import br.com.gmp.utils.image.ImageUtil;
import br.com.rpgruler.data.entitity.Effect;
import br.com.rpgruler.data.entitity.Element;
import br.com.rpgruler.data.entitity.ElementBoost;
import br.com.rpgruler.data.entitity.ElementWeakness;
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

    public void addElement(String title, String symbol, ElementBoost boost, ElementWeakness wek) {
        elementView.getModel().add(new Element(Integer.SIZE, null, null));
    }

    public void removeElement() {

    }

    /**
     *
     * @return
     */
    public List<Element> getElements() {
        List<Element> data = new ArrayList<>();
        ElementBoost[] boosts = getBoosts();
        ElementWeakness[] weaks = getWeaks();
        List<Element> elements = getElement();
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).setElementBoost(boosts[i]);
            elements.get(i).setElementWeakness(weaks[i]);
            data.add(elements.get(i));
        }
        return data;
    }

    public List<Element> getElement() {
        List<Element> data = new ArrayList<>();
        String[] names = getNames();
        String[] images = getImages();
        for (int i = 0; i < 7; i++) {
            data.add(new Element(i, names[i], images[i]));
        }
        return data;
    }

    public ElementWeakness[] getWeaks() {
        Effect[] effects = getEffects();
        ElementWeakness[] array = new ElementWeakness[7];
        array[0] = (new ElementWeakness(0, "Fogo", effects[1]));
        array[1] = (new ElementWeakness(1, "Agua", effects[1]));
        array[2] = (new ElementWeakness(2, "Vento", effects[1]));
        array[3] = (new ElementWeakness(3, "Terra", effects[1]));
        array[4] = (new ElementWeakness(4, "Luz", effects[1]));
        array[5] = (new ElementWeakness(5, "Sombra", effects[1]));
        array[6] = (new ElementWeakness(6, "Alquimia", effects[1]));
        return array;
    }

    public ElementBoost[] getBoosts() {
        Effect[] effects = getEffects();
        ElementBoost[] array = new ElementBoost[7];
        array[0] = (new ElementBoost(0, "Fogo", effects[0]));
        array[1] = (new ElementBoost(1, "Agua", effects[0]));
        array[2] = (new ElementBoost(2, "Vento", effects[0]));
        array[3] = (new ElementBoost(3, "Terra", effects[0]));
        array[4] = (new ElementBoost(4, "Luz", effects[0]));
        array[5] = (new ElementBoost(5, "Sombra", effects[0]));
        array[6] = (new ElementBoost(6, "Alquimia", effects[0]));
        return array;
    }

    public Effect[] getEffects() {
        Effect[] array = new Effect[4];
        array[0] = (new Effect(0, "Aumento", 20));
        array[1] = (new Effect(1, "Reduçao", 20));
        array[2] = (new Effect(2, "Parada", 10));
        array[3] = (new Effect(3, "Aceleraçao", 10));
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

    public String[] getNames() {
        return new String[]{"Fire",
            "Water",
            "Wind",
            "Earth",
            "Light",
            "Dark",
            "Alchemy"};
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
