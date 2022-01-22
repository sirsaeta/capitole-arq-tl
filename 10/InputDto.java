public class InputDto {
	
    private Integer in;
    private Integer out;
    private String colorArista;
    public InputDto(){    }
    public InputDto(Integer out, Integer in, String colorArista){
        this.out = out;
        this.in = in;
        this.colorArista = colorArista;
    }

    public void setIn(Integer in) {
        this.in = in;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public void setColorArista(String colorArista) {
        this.colorArista = colorArista;
    }

    public Integer getIn() {
        return in;
    }

    public Integer getOut() {
        return out;
    }

    public String getColorArista() {
        return colorArista;
    }

}
