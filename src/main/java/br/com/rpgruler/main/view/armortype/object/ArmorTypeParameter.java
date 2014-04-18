package br.com.rpgruler.main.view.armortype.object;

/**
 * Parametro de transferencia para ArmorType
 *
 * @author kaciano
 */
public class ArmorTypeParameter {

    private String typeName;
    private Double materialAmount1;
    private Double materialAmount2;
    private Double base;

    /**
     *
     */
    public ArmorTypeParameter() {
    }

    /**
     *
     * @param typeName
     * @param materialAmount1
     * @param materialAmount2
     */
    public ArmorTypeParameter(String typeName, Double materialAmount1, Double materialAmount2) {
        this.typeName = typeName;
        this.materialAmount1 = materialAmount1;
        this.materialAmount2 = materialAmount2;
    }

    public ArmorTypeParameter(String typeName, Double materialAmount1, Double materialAmount2, Double base) {
        this.typeName = typeName;
        this.materialAmount1 = materialAmount1;
        this.materialAmount2 = materialAmount2;
        this.base = base;
    }

    /**
     *
     * @return
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     *
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     *
     * @return
     */
    public Double getMaterialAmount1() {
        return materialAmount1;
    }

    /**
     *
     * @param materialAmount1
     */
    public void setMaterialAmount1(Double materialAmount1) {
        this.materialAmount1 = materialAmount1;
    }

    /**
     *
     * @return
     */
    public Double getMaterialAmount2() {
        return materialAmount2;
    }

    /**
     *
     * @param materialAmount2
     */
    public void setMaterialAmount2(Double materialAmount2) {
        this.materialAmount2 = materialAmount2;
    }

    /**
     *
     * @return
     */
    public Double getBase() {
        return base;
    }

    /**
     *
     * @param base
     */
    public void setBase(Double base) {
        this.base = base;
    }

}
