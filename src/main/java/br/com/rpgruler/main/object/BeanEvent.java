package br.com.rpgruler.main.object;

/**
 * Evento de transporte de dados
 *
 * @author kaciano
 */
public class BeanEvent {

    private Object frame;
    private Object value;

    /**
     *
     * @param frame Tela que carregou o evento
     * @param value Objeto transportado
     */
    public BeanEvent(Object frame, Object value) {
        this.frame = frame;
        this.value = value;
    }

    public Object getFrame() {
        return frame;
    }

    public void setFrame(Object frame) {
        this.frame = frame;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
