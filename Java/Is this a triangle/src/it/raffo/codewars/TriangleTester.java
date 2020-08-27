package it.raffo.codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleTester
{
	public static boolean isTriangle(int a, int b, int c)
	{
		boolean bRet = false;
		List<Integer> lista = new ArrayList<>();
		lista.add(a);
		lista.add(b);
		lista.add(c);

		Integer max = Collections.max(lista);
		int somma = a + b + c;
		bRet = (somma - max) > max;
		return bRet;
	}
}
