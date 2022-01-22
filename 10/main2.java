import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MainOld1 {
	public static Integer count = 0;
	public static Integer triple = 0;

	public static Integer[] tripleta = new Integer[3];
	public static List<List<Integer>> tripletaList = new ArrayList<>();
	
    public static void main(String args[]) {
    	var arbolito = createArbolList(); 
    	arbolito.forEach(n -> {
    		triple = 0;
    		tripleta[triple] = n.getIndex();
    		System.out.println("n: " + n.toString());
    		arbolito.stream().filter(a -> a.getIndex() != n.getIndex()).forEach(z -> {
        		System.out.println("n: " + n.getIndex().toString() + " - z: " + z.getIndex());
    			if (
    					((n.bIsRed() || z.aIsRed()) && n.getIndex() < z.getIndex() && n.getBordeb()!=null && z.getBordea()!=null)
    					|| ((n.aIsRed() || z.bIsRed()) && n.getIndex() > z.getIndex() && n.getBordeb()!=null && z.getBordea()!=null)
    				) {
    				triple++;
    				tripleta[triple] = z.getIndex();
    	    		System.out.println("z: " + z.toString());
    				System.out.println("triple: " + triple);
    	    		if(triple==2)
    	    		{
    	    			Boolean contiene = false;
    	    			for (var w : tripletaList) {
    	    				contiene = (w.get(0) == tripleta[0] || w.get(0) == tripleta[1] || w.get(0) == tripleta[2])
    	    						&& (w.get(1) == tripleta[0] || w.get(1) == tripleta[1] || w.get(1) == tripleta[2])
    	    						&& (w.get(2) == tripleta[0] || w.get(2) == tripleta[1] || w.get(2) == tripleta[2]);
    	    				if(contiene) break;
    	    			}
    	    			if(!contiene) {
    	    				System.out.println(" ********** ******* "+tripleta[0]+","+tripleta[1]+","+tripleta[2]+" ******* **********" );
        	    			Integer[] arr = new Integer[3];
        	    			arr[0] = tripleta[0];
        	    			arr[1] = tripleta[1];
        	    			arr[2] = tripleta[2];
        	    			List<Integer> lList = new ArrayList<Integer>();
        	    			lList.add(tripleta[0]);
        	    			lList.add(tripleta[1]);
        	    			lList.add(tripleta[2]);
        	    			Collections.sort(lList);
        	    			tripletaList.add(lList);
        	    			count++;
        					System.out.println(" ********** ******* count++: " + count + " ******* **********");
    	    			}
    					triple = 1;
    	    		}
				}
    		});
    	});
     
        System.out.println(count);
        
        System.out.println(tripletaList.size());
        tripletaList.forEach(tl -> System.out.println(""+tl.get(0)+","+tl.get(1)+","+tl.get(2)+"" ));
        /*result = createArbolList().stream()
        .map(n -> n.getBordeb())
          .collect(Collectors.joining(",", "", ""));
     
        System.out.println(result);*/
    }

    private static List<Arbol> createArbolList() {
    	

    	List<Arbol> arbolList = new ArrayList<>();
    	for (int i = 0; i < 5; i++) {
    		arbolList.add(new Arbol());
		}
        InputDto e1 = new InputDto(1, 2, "b");
        InputDto e2 = new InputDto(2, 3, "r");
        InputDto e3 = new InputDto(3, 4, "r");
        InputDto e4 = new InputDto(4, 5, "b");

        var arbolito = new Arbol(e1.getIn(),e1.getColorArista(),arbolList.get(e1.getIn()-1).getBordeb());
        arbolList.set(e1.getIn()-1, arbolito);

        arbolito = new Arbol(e1.getOut(),arbolList.get(e1.getOut()-1).getBordea(),e1.getColorArista());
        arbolList.set(e1.getOut()-1, arbolito);

        arbolito = new Arbol(e2.getIn(),e2.getColorArista(),arbolList.get(e2.getIn()-1).getBordeb());
        arbolList.set(e2.getIn()-1, arbolito);

        arbolito = new Arbol(e2.getOut(),arbolList.get(e2.getOut()-1).getBordea(),e2.getColorArista());
        arbolList.set(e2.getOut()-1, arbolito);

        arbolito = new Arbol(e3.getIn(),e3.getColorArista(),arbolList.get(e3.getIn()-1).getBordeb());
        arbolList.set(e3.getIn()-1, arbolito);

        arbolito = new Arbol(e3.getOut(),arbolList.get(e3.getOut()-1).getBordea(),e3.getColorArista());
        arbolList.set(e3.getOut()-1, arbolito);

        arbolito = new Arbol(e4.getIn(),e4.getColorArista(),arbolList.get(e4.getIn()-1).getBordeb());
        arbolList.set(e4.getIn()-1, arbolito);

        arbolito = new Arbol(e4.getOut(),arbolList.get(e4.getOut()-1).getBordea(),e4.getColorArista());
        arbolList.set(e4.getOut()-1, arbolito);
        return arbolList;
    }
}