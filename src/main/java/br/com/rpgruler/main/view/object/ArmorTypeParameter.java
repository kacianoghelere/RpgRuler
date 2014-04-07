package br.com.rpgruler.main.view.object;

/**
 * Parametro de transferencia para ArmorType
 *
 * @author kaciano
 */
public class ArmorTypeParameter {

    private String typeName;
    private Double materialAmount1;
    private Double materialAmount2;

    public ArmorTypeParameter() {
    }

    public ArmorTypeParameter(String typeName, Double materialAmount1, Double materialAmount2) {
        this.typeName = typeName;
        this.materialAmount1 = materialAmount1;
        this.materialAmount2 = materialAmount2;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Double getMaterialAmount1() {
        return materialAmount1;
    }

    public void setMaterialAmount1(Double materialAmount1) {
        this.materialAmount1 = materialAmount1;
    }

    public Double getMaterialAmount2() {
        return materialAmount2;
    }

    public void setMaterialAmount2(Double materialAmount2) {
        this.materialAmount2 = materialAmount2;
    }

}
