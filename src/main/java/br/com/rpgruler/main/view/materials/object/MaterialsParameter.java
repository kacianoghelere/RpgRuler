package br.com.rpgruler.main.view.materials.object;

/**
 * Wrapper para enviar dados de materiais
 *
 * @author kaciano
 */
public class MaterialsParameter {

    private String materialName;
    private Integer materialClass;
    private Double materialWeight;

    /**
     * Cria novo MaterialsParameter
     *
     * @param materialName Nome do material
     * @param materialClass Classe do material
     * @param materialWeight Peso do material
     */
    public MaterialsParameter(String materialName, Integer materialClass, Double materialWeight) {
        this.materialName = materialName;
        this.materialClass = materialClass;
        this.materialWeight = materialWeight;
    }

    /**
     *
     * @return
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     *
     * @param materialName
     */
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    /**
     *
     * @return
     */
    public Integer getMaterialClass() {
        return materialClass;
    }

    /**
     *
     * @param materialClass
     */
    public void setMaterialClass(Integer materialClass) {
        this.materialClass = materialClass;
    }

    /**
     *
     * @return
     */
    public Double getMaterialWeight() {
        return materialWeight;
    }

    /**
     *
     * @param materialWeight
     */
    public void setMaterialWeight(Double materialWeight) {
        this.materialWeight = materialWeight;
    }

}
