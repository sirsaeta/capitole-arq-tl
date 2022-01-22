package com.capitole.harryarbol.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capitole.harryarbol.dtos.Arbol;
import com.capitole.harryarbol.dtos.InputDto;
import com.capitole.harryarbol.dtos.ResponseDto;

import lombok.NoArgsConstructor;

@Service("HarryService")
@NoArgsConstructor
public class HarryServiceImpl implements HarryService {
	public ResponseDto getTripletas(InputDto input) throws Exception {
		try {
			var arboles = createArbolList(input.getListInput());
			System.out.println(arboles);
			System.out.print("Tripletas Rojas: ");
			var reds = findTripletas(arboles, "r");
			System.out.print("Tripletas Negras: ");
			var blacks = findTripletas(arboles, "b");
			return new ResponseDto(reds.size(),reds,blacks.size(),blacks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Error(e.getMessage());
		}
	}

	private static List<Arbol> createArbolList(List<String> input) throws Exception {

		List<Arbol> arbolList = new ArrayList<>();
		for (int i = 0; i < Integer.parseInt(input.get(0)); i++) {
			arbolList.add(new Arbol());
		}
		for (int i = 1; i < Integer.parseInt(input.get(0)); i++) {
			String lineBordes = input.get(i);
			var arrInputValue = lineBordes.split(" ");
			if (arrInputValue.length != 3) {
				throw new Exception("badRequest -> invalid input");
			}
			else if(!arrInputValue[2].equals("r") && !arrInputValue[2].equals("b")) {
				throw new Exception("badRequest -> invalid color "+arrInputValue[2]);
			}
			arbolList.set(
					Integer.parseInt(arrInputValue[0]) - 1,
					new Arbol(
							Integer.parseInt(arrInputValue[0]),
							arbolList.get(Integer.parseInt(arrInputValue[0]) - 1).getBordeIzquierdo(),
							arrInputValue[2]));
			arbolList.set(
					Integer.parseInt(arrInputValue[1]) - 1,
					new Arbol(
							Integer.parseInt(arrInputValue[1]),
							arrInputValue[2],
							arbolList.get(Integer.parseInt(arrInputValue[1]) - 1).getBordeDerecho()));
		}
		for (int i = 0; i < Integer.parseInt(input.get(0)); i++) {
			System.out.println(arbolList.get(i).toString());
		}
		return arbolList;
	}

	private static List<List<Integer>> findTripletas(List<Arbol> arboles, String color) {
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
		return tripletaList;
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
				&& arbola.getBordeDerecho() != null && arbolb.getBordeIzquierdo() != null) ||
				((arbola.aIsColorValid(color) || arbolb.bIsColorValid(color)) && arbola.getIndex() > arbolb.getIndex()
						&& arbola.getBordeDerecho() != null && arbolb.getBordeIzquierdo() != null);
	}
}
