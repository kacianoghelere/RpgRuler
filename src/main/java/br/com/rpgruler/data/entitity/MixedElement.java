package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class MixedElement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String mixName;
    private Element element1;
    private Element element2;    

    public MixedElement() {
    }

    public MixedElement(Integer id, String mixName, Element element1, Element element2) {
        this.id = id;
        this.mixName = mixName;
        this.element1 = element1;
        this.element2 = element2;        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MixedElement other = (MixedElement) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "MixedElement{\n" 
                + "ID = " + id + ",\n"
                + "MixName =" + mixName + ",\n"
                + "Element1 =" + element1 + ",\n"
                + "Element2 =" + element2 + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMixName() {
        return mixName;
    }

    public void setMixName(String mixName) {
        this.mixName = mixName;
    }

    public Element getElement1() {
        return element1;
    }

    public void setElement1(Element element1) {
        this.element1 = element1;
    }

    public Element getElement2() {
        return element2;
    }

    public void setElement2(Element element2) {
        this.element2 = element2;
    }

}
