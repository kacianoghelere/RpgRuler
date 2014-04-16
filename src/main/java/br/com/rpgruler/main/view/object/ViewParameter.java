package br.com.rpgruler.main.view.object;

/**
 * Parametro para carregamento de views
 *
 * @author kaciano
 */
public class ViewParameter {

    private Boolean canSave;
    private Boolean canProcess;
    private Boolean canClear;
    private Boolean canLoad;

    /**
     *
     * @param canSave
     * @param canProcces
     * @param canClear
     * @param canLoad
     */
    public ViewParameter(Boolean canSave, Boolean canProcces,
            Boolean canClear, Boolean canLoad) {
        this.canSave = canSave;
        this.canProcess = canProcces;
        this.canClear = canClear;
        this.canLoad = canLoad;
    }

    @Override
    public String toString() {
        return "ViewParameter{\n"
                + "canSave=" + canSave + ",\n"
                + "canProcces=" + canProcess + ",\n"
                + "canClear=" + canClear + ",\n"
                + "canLoad=" + canLoad + "\n" + '}';
    }

    /**
     *
     * @return
     */
    public Boolean isSave() {
        return canSave;
    }

    /**
     *
     * @param canSave
     */
    public void setSave(Boolean canSave) {
        this.canSave = canSave;
    }

    /**
     *
     * @return
     */
    public Boolean isProcess() {
        return canProcess;
    }

    /**
     *
     * @param canProcces
     */
    public void setProcess(Boolean canProcces) {
        this.canProcess = canProcces;
    }

    /**
     *
     * @return
     */
    public Boolean isClear() {
        return canClear;
    }

    /**
     *
     * @param canClear
     */
    public void setClear(Boolean canClear) {
        this.canClear = canClear;
    }

    /**
     *
     * @return
     */
    public Boolean isLoad() {
        return canLoad;
    }

    /**
     *
     * @param canLoad
     */
    public void setLoad(Boolean canLoad) {
        this.canLoad = canLoad;
    }

}
