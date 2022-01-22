import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {

	public static void main(String args[]) throws Exception {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int vertices = sc.nextInt();
		var arbolito = createArbolList(vertices);
		System.out.print("Tripletas Rojas: ");
		findTripletas(arbolito, "r");
		System.out.print("Tripletas Negras: ");
		findTripletas(arbolito, "b");
		sc.close();
		}catch (Exception e) {
			System.out.print("Error: " + e.getMessage());
		}
	}

	private static void findTripletas(List<Arbol> arboles, String color) {
		List<List<Integer>> tripletaList = new ArrayList<>();
		arboles.forEach(arbolbase -> {
			var triple = 0;
			Integer[] tripleta = new Integer[3];
			tripleta[triple] = arbolbase.getIndex();
			for (int i = arbolbase.getIndex(); i < arboles.size(); i++) {
				triple = 1;
				var z = arboles.get(i);
				if (validarBorde(arbolbase, z, color)) {
					tripleta[triple] = z.getIndex();
					for (int ii = z.getIndex(); ii < arboles.size(); ii++) {
						triple = 2;
						var y = arboles.get(ii);
						if (validarBorde(z, y, color)) {
							tripleta[triple] = y.getIndex();
							update(tripleta, tripletaList);
							triple--;
						}
					}
				}
			}
		});

		System.out.println(tripletaList.size());
		tripletaList.forEach(tl -> System.out.println("" + tl.get(0) + "," + tl.get(1) + "," + tl.get(2) + ""));
	}

	private static List<List<Integer>> update(Integer[] tripleta, List<List<Integer>> tripletaList) {
		if (!validarSiContieneExtistePermuta(tripletaList, tripleta)) {
			// System.out.println(" ********** *******
			// "+tripleta[0]+","+tripleta[1]+","+tripleta[2]+" ******* **********" );
			tripletaList.add(sortListTripleta(tripleta));
		}
		return tripletaList;
	}

	private static List<Integer> sortListTripleta(Integer[] tripleta) {
		List<Integer> lList = new ArrayList<Integer>();
		lList.add(tripleta[0]);
		lList.add(tripleta[1]);
		lList.add(tripleta[2]);
		Collections.sort(lList);
		return lList;
	}

	private static Boolean validarSiContieneExtistePermuta(List<List<Integer>> tripletaList, Integer[] tripleta) {
		Boolean contiene = false;
		for (var w : tripletaList) {
			contiene = (w.get(0) == tripleta[0] || w.get(0) == tripleta[1] || w.get(0) == tripleta[2])
					&& (w.get(1) == tripleta[0] || w.get(1) == tripleta[1] || w.get(1) == tripleta[2])
					&& (w.get(2) == tripleta[0] || w.get(2) == tripleta[1] || w.get(2) == tripleta[2]);
			if (contiene)
				break;
		}
		return contiene;
	}

	private static Boolean validarBorde(Arbol arbola, Arbol arbolb, String color) {
		return ((arbola.bIsColorValid(color) || arbolb.aIsColorValid(color)) && arbola.getIndex() < arbolb.getIndex()
				&& arbola.getBordeb() != null && arbolb.getBordea() != null) ||
				((arbola.aIsColorValid(color) || arbolb.bIsColorValid(color)) && arbola.getIndex() > arbolb.getIndex()
						&& arbola.getBordeb() != null && arbolb.getBordea() != null);
	}

	private static List<Arbol> createArbolList(int vertices) throws Exception {

		Scanner sc = new Scanner(System.in);
		List<Arbol> arbolList = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			arbolList.add(new Arbol());
		}
		for (int i = 0; i < vertices - 1; i++) {
			System.out.print("Enter line: ");
			String lineBordes = sc.nextLine();
			var arrInputValue = lineBordes.split(" ");
			if (arrInputValue.length != 3) {
				sc.close();
				throw new Error("badRequest -> invalid input");
			}
			else if(!arrInputValue[2].equals("r") && !arrInputValue[2].equals("b")) {
				sc.close();
				throw new Error("badRequest -> invalid color "+arrInputValue[2]);
			}
			arbolList.set(
					Integer.parseInt(arrInputValue[0]) - 1,
					new Arbol(
							Integer.parseInt(arrInputValue[0]),
							arbolList.get(Integer.parseInt(arrInputValue[0]) - 1).getBordea(),
							arrInputValue[2]));
			arbolList.set(
					Integer.parseInt(arrInputValue[1]) - 1,
					new Arbol(
							Integer.parseInt(arrInputValue[1]),
							arrInputValue[2],
							arbolList.get(Integer.parseInt(arrInputValue[1]) - 1).getBordeb()));
		}
		for (int i = 0; i < vertices; i++) {
			System.out.println(arbolList.get(i).toString());
		}

		sc.close();
		return arbolList;
	}
}