import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main3 {
	public static Integer count = 0;
	public static Integer triple = 0;

	public static Integer[] tripleold = new Integer[3];
	public static List<List<Integer>> tripletaList = new ArrayList<>();
	
    public static void main(String args[]) {
    	Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
    	System.out.print("Enter first number- ");  
    	int vertices= sc.nextInt();  
    	var arbolito = createArbolList(vertices); 
    	//findTripletas(arbolito);
    }
    private static void findTripletas(List<Arbol> arboles) {
    	arboles.forEach(arbolbase -> {
    		var triple = 0;
    		Integer[] tripleta = new Integer[3];
    		tripleta[triple] = arbolbase.getIndex();
    		System.out.println("arbolbase: " + arbolbase.toString());
    		for (int i = arbolbase.getIndex(); i < arboles.size(); i++) {
    			triple = 1;
    			var z = arboles.get(i);
    			System.out.println("n: " + arbolbase.getIndex().toString() + " - z: " + z.getIndex().toString());
    			if (validarBorde(arbolbase,z)) {
    				//triple++;
    	    		System.out.println("z: " + z.toString());
    				System.out.println("triple: " + triple);
    				tripleta[triple] = z.getIndex();
    				for (int ii = z.getIndex(); ii < arboles.size(); ii++) {
    					triple = 2;
    	    			var y = arboles.get(ii);
    	    			if (validarBorde(z,y)) {
    	    				//triple++;
    	    	    		System.out.println("y: " + y.toString());
    	    				System.out.println("triple: " + triple);
    	    				tripleta[triple] = y.getIndex();
        	    			Boolean contiene = validarSiContieneExtistePermuta(tripletaList, tripleta);
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
        					triple--;
        					//break;
    	    			}
    				}
				}
    		}
    	});
     
        System.out.println(count);
        
        System.out.println(tripletaList.size());
        tripletaList.forEach(tl -> System.out.println(""+tl.get(0)+","+tl.get(1)+","+tl.get(2)+"" ));
    }
    
    private static Boolean validarSiContieneExtistePermuta(List<List<Integer>> tripletaList, Integer[] tripleta) {
    	Boolean contiene = false;
    	for (var w : tripletaList) {
			contiene = (w.get(0) == tripleta[0] || w.get(0) == tripleta[1] || w.get(0) == tripleta[2])
					&& (w.get(1) == tripleta[0] || w.get(1) == tripleta[1] || w.get(1) == tripleta[2])
					&& (w.get(2) == tripleta[0] || w.get(2) == tripleta[1] || w.get(2) == tripleta[2]);
			if(contiene) break;
		}
    	return contiene;
    }
    
    private static Boolean validarBorde(Arbol arbola, Arbol arbolb) {
    	return ((arbola.bIsRed() || arbolb.aIsRed()) && arbola.getIndex() < arbolb.getIndex() && arbola.getBordeb()!=null && arbolb.getBordea()!=null)
				|| ((arbola.aIsRed() || arbolb.bIsRed()) && arbola.getIndex() > arbolb.getIndex() && arbola.getBordeb()!=null && arbolb.getBordea()!=null);
    }

    
    private static void findAllPermutasFake(List<Arbol> arbolito) {
    	arbolito.forEach(n -> {
    		triple = 0;
    		tripleold[triple] = n.getIndex();
    		System.out.println("n: " + n.toString());
    		arbolito.stream().filter(a -> a.getIndex() != n.getIndex()).forEach(z -> {
        		System.out.println("n: " + n.getIndex().toString() + " - z: " + z.getIndex());
    			if (
    					((n.bIsRed() || z.aIsRed()) && n.getIndex() < z.getIndex() && n.getBordeb()!=null && z.getBordea()!=null)
    					|| ((n.aIsRed() || z.bIsRed()) && n.getIndex() > z.getIndex() && n.getBordeb()!=null && z.getBordea()!=null)
    				) {
    				triple++;
    				tripleold[triple] = z.getIndex();
    	    		System.out.println("z: " + z.toString());
    				System.out.println("triple: " + triple);
    	    		if(triple==2)
    	    		{
    	    			Boolean contiene = false;
    	    			for (var w : tripletaList) {
    	    				contiene = (w.get(0) == tripleold[0] || w.get(0) == tripleold[1] || w.get(0) == tripleold[2])
    	    						&& (w.get(1) == tripleold[0] || w.get(1) == tripleold[1] || w.get(1) == tripleold[2])
    	    						&& (w.get(2) == tripleold[0] || w.get(2) == tripleold[1] || w.get(2) == tripleold[2]);
    	    				if(contiene) break;
    	    			}
    	    			if(!contiene) {
    	    				System.out.println(" ********** ******* "+tripleold[0]+","+tripleold[1]+","+tripleold[2]+" ******* **********" );
        	    			Integer[] arr = new Integer[3];
        	    			arr[0] = tripleold[0];
        	    			arr[1] = tripleold[1];
        	    			arr[2] = tripleold[2];
        	    			List<Integer> lList = new ArrayList<Integer>();
        	    			lList.add(tripleold[0]);
        	    			lList.add(tripleold[1]);
        	    			lList.add(tripleold[2]);
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
    }

    private static List<Arbol> createArbolList(int vertices) {
    	

    	List<Arbol> arbolList = new ArrayList<>();
    	for (int i = 0; i < vertices; i++) {
    		arbolList.add(new Arbol());
		}
    	for (int i = 0; i < vertices-1; i++) {
        	Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
        	System.out.print("Enter line- ");  
        	String lineBordes= sc.nextLine();
        	var bb = lineBordes.split(" ");
        	if(bb.length!=3)
        		new Error("badRequest");
    		arbolList.set(
				Integer.parseInt(bb[0])-1, 
				new Arbol(
					Integer.parseInt(bb[0]),
					arbolList.get(Integer.parseInt(bb[0])-1).getBordea(),
					bb[2]
				)
    		);
    		arbolList.set(
    				Integer.parseInt(bb[1])-1, 
    				new Arbol(
    						Integer.parseInt(bb[1]),
    						bb[2],
    						arbolList.get(Integer.parseInt(bb[1])-1).getBordeb()
    				)
    		);
		}
    	for (int i = 0; i < vertices; i++) {
    		System.out.println(arbolList.get(i).toString());
		}
        /*InputDto e1 = new InputDto(1, 2, "b");
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
        arbolList.set(e4.getOut()-1, arbolito);*/
        return arbolList;
    }
}