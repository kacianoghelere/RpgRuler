package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Entidade de armaduras
 *
 * @author kaciano
 * @version 1.0
 */
public class Armor {

    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String name;
    @ColumnName(name = "Descrição")
    private String description;
    @ColumnName(name = "Tipo de armadura")
    private ArmorType type;
    @ColumnName(name = "Resistencia")
    private Double resistence;
    @ColumnName(name = "Material 1")
    private PrimeMaterial material1;
    @ColumnName(name = "Material 2")
    private PrimeMaterial material2;

    /**
     * Cria nova instancia de Armor
     */
    public Armor() {
    }

    /**
     * Cria nova instancia de Armor
     *
     * @param id <code>Long</code> ID da armadura
     * @param name <code>String</code> Nome da armadura
     * @param description <code>String</code> Descrição da armadura
     * @param type <code>ArmorType</code> Tipo da armadura
     * @param material1 <code>PrimeMaterial</code> Material 1
     * @param material2 <code>PrimeMaterial</code> Material 2
     */
    public Armor(Long id, String name, String description, ArmorType type, PrimeMaterial material1, PrimeMaterial material2) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.material1 = material1;
        this.material2 = material2;
    }

    /**
     * Calcula a resistencia da armadura com base nos materiais e na resistencia
     * basica
     */
    public void calcResistence() {
        this.resistence = (material1.getResistence()
                + material2.getResistence()
                + type.getBase());
    }

    /**
     * Retorna o ID da armadura
     *
     * @return <code>Long</code> ID da armadura
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID da armadura
     *
     * @param id <code>Long</code> ID da armadura
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome da armadura
     *
     * @return <code>String</code> Nome da armadura
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome da armadura
     *
     * @param name <code>String</code> Nome da armadura
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a Descrição da armadura
     *
     * @return <code>String</code> Descrição da armadura
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a Descrição da armadura
     *
     * @param description <code>String</code> Descrição da armadura
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o Tipo da armadura
     *
     * @return <code>ArmorType</code> Tipo da armadura
     */
    public ArmorType getType() {
        return type;
    }

    /**
     * Modifica o Tipo da armadura
     *
     * @param type <code>ArmorType</code> Tipo da armadura
     */
    public void setType(ArmorType type) {
        this.type = type;
    }

    /**
     * Retorna a Resistencia da armadura
     *
     * @return <code>Double</code> Resistencia da armadura
     */
    public Double getResistence() {
        return resistence;
    }

    /**
     * Modifica a Resistencia da armadura
     *
     * @param resistence <code>Double</code> Resistencia da armadura
     */
    public void setResistence(Double resistence) {
        this.resistence = resistence;
    }

    /**
     * Retorna o Material 1
     *
     * @return <code>PrimeMaterial</code> Material 1
     */
    public PrimeMaterial getMaterial1() {
        return material1;
    }

    /**
     * Modifica o Material 1
     *
     * @param material1 <code>PrimeMaterial</code> Material 1
     */
    public void setMaterial1(PrimeMaterial material1) {
        this.material1 = material1;
    }

    /**
     * Retorna o Material 2
     *
     * @return <code>PrimeMaterial</code> Material 2
     */
    public PrimeMaterial getMaterial2() {
        return material2;
    }

    /**
     * Modifica o Material 2
     *
     * @param material2 <code>PrimeMaterial</code> Material 2
     */
    public void setMaterial2(PrimeMaterial material2) {
        this.material2 = material2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.material1);
        hash = 53 * hash + Objects.hashCode(this.material2);
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
        final Armor other = (Armor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.material1, other.material1)) {
            return false;
        }
        return Objects.equals(this.material2, other.material2);
    }

    @Override
    public String toString() {
        return this.name;
    }

}
