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

    public Boolean isSave() {
        return canSave;
    }

    public void setSave(Boolean canSave) {
        this.canSave = canSave;
    }

    public Boolean isProcess() {
        return canProcess;
    }

    public void setProcess(Boolean canProcces) {
        this.canProcess = canProcces;
    }

    public Boolean isClear() {
        return canClear;
    }

    public void setClear(Boolean canClear) {
        this.canClear = canClear;
    }

    public Boolean isLoad() {
        return canLoad;
    }

    public void setLoad(Boolean canLoad) {
        this.canLoad = canLoad;
    }

}
