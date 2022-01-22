public class Arbol {
	
    private Integer index;
    private String bordea;
    private String bordeb;

    public Arbol(Integer index, String bordea, String bordeb){
        this.index = index;
        this.bordea = bordea;
        this.bordeb = bordeb;
    }

    public Arbol() {
		// TODO Auto-generated constructor stub
        this.bordea = "null";
        this.bordeb = "null";
	}

	public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public String getBordea() {
        return bordea;
    }

    public String getBordeb() {
        return bordeb;
    }
    
    public Boolean isMulti() {
        return bordea.equalsIgnoreCase(bordeb) && bordea.equalsIgnoreCase("r");
    }
    
    public Boolean containRed() {
        return bordea.equalsIgnoreCase("r") || bordeb.equalsIgnoreCase("r");
    }
    
    public Boolean aIsRed() {
        return bordea.equalsIgnoreCase("r");
    }
    
    public Boolean bIsRed() {
        return bordeb.equalsIgnoreCase("r");
    }
    
    public Boolean aIsBlack() {
        return bordea.equalsIgnoreCase("r");
    }
    
    public Boolean bIsBlack() {
        return bordeb.equalsIgnoreCase("r");
    }
    
    public Boolean aIsColorValid(String color) {
        return bordea.equalsIgnoreCase(color);
    }
    
    public Boolean bIsColorValid(String color) {
        return bordeb.equalsIgnoreCase(color);
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "" + bordea + " <- " + index + " -> " + bordeb;
    }
}
