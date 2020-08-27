package it.raffo.codewars;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class test
{
	private boolean[]		operands;
	private char[]			operators;
	private BigInteger[][]	cacheT;
	private BigInteger[][]	cacheF;

	public void BooleanOrder(final String operands, final String operators)
	{
		this.operands = new boolean[operands.length()];
		this.operators = new char[operators.length()];
		this.cacheT = new BigInteger[operands.length()][operands.length()];
		this.cacheF = new BigInteger[operands.length()][operands.length()];

		for (int i = 0; i < operands.length(); ++i)
		{
			this.operands[i] = operands.charAt(i) == 't';
			if (i < operators.length())
			{
				this.operators[i] = operators.charAt(i);
			}
		}
	}

	public BigInteger solve()
	{
		int n = this.operands.length - 1;
		for (int s = 0; s <= n; ++s)
		{
			for (int i = 0; i <= (n - s); ++i)
			{
				int j = s + i;
				BigInteger[] tf = this.calcTF(i, j);
				this.cacheT[i][j] = tf[0];
				this.cacheF[i][j] = tf[1];
			}
		}
		return this.cacheT[0][n];
	}

	private BigInteger[] calcTF(int i, int j)
	{
		BigInteger[] res = new BigInteger[2];

		if (i == j)
		{
			res[0] = this.operands[i] ? BigInteger.ONE : BigInteger.ZERO;
			res[1] = this.operands[i] ? BigInteger.ZERO : BigInteger.ONE;
			return res;
		}

		res[0] = res[1] = BigInteger.ZERO;
		for (int k = i; k < j; ++k)
		{
			int leftI = i;
			int leftJ = k;
			int rightI = k + 1;
			int rightJ = j;

			BigInteger leftT = this.cacheT[leftI][leftJ];
			BigInteger leftF = this.cacheF[leftI][leftJ];
			BigInteger rightT = this.cacheT[rightI][rightJ];
			BigInteger rightF = this.cacheF[rightI][rightJ];

			char op = this.operators[k];
			switch (op)
			{
				case '&':
				{
					res[0] = res[0].add(leftT.multiply(rightT));
					res[1] = res[1].add(leftF.multiply(rightF).add(leftF.multiply(rightT)).add(leftT.multiply(rightF)));
					break;
				}
				case '|':
				{
					res[0] = res[0].add(leftT.multiply(rightT).add(leftF.multiply(rightT)).add(leftT.multiply(rightF)));
					res[1] = res[1].add(leftF.multiply(rightF));
					break;
				}
				case '^':
				{
					res[0] = res[0].add(leftT.multiply(rightF).add(leftF.multiply(rightT)));
					res[1] = res[1].add(leftT.multiply(rightT).add(leftF.multiply(rightF)));
					break;
				}
				default:
					throw new RuntimeException("errore: " + op);
			}
		}

		return res;
	}

	static String lcs(String a, String b)
	{
		int m = a.length();
		int n = b.length();
		return lcs(a, b, m, n);
	}

	static String lcs(String a, String b, int max, int min)
	{
		int[][] l = new int[max + 1][min + 1];

		for (int i = 0; i <= max; i++)
		{
			for (int j = 0; j <= min; j++)
			{
				if ((i == 0) || (j == 0))
				{
					l[i][j] = 0;
				}
				else if (a.charAt(i - 1) == b.charAt(j - 1))
				{
					l[i][j] = l[i - 1][j - 1] + 1;
				}
				else
				{
					l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);
				}
			}
		}

		int idx = l[max][min];
		int temp = idx;

		char[] lcs = new char[idx + 1];
		lcs[idx] = '\0';

		int i = max;
		int j = min;
		while ((i > 0) && (j > 0))
		{
			if (a.charAt(i - 1) == b.charAt(j - 1))
			{
				lcs[idx - 1] = a.charAt(i - 1);
				i--;
				j--;
				idx--;
			}
			else if (l[i - 1][j] > l[i][j - 1])
			{
				i--;
			}
			else
			{
				j--;
			}
		}

		return getString(temp, lcs);
	}

	private static String getString(int temp, char[] lcs)
	{
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k <= temp; k++)
		{
			sb.append(lcs[k]);
		}
		return sb.deleteCharAt(temp).toString();
	}

	public double evaluate(String expr)
	{
		if (expr.isEmpty())
		{
			return 0d;
		}
		Deque<String> stack = new ArrayDeque<>();
		String[] strArray = expr.split(" ");
		for (int i = 0; i < strArray.length; i++)
		{
			String c = strArray[i];
			if (c.matches("\\+"))
			{
				String b = stack.pop();
				String a = stack.pop();
				int s = Integer.valueOf(a) + Integer.valueOf(b);
				stack.push(String.valueOf(s));
			}
			else if (c.matches("\\-"))
			{
				String b = stack.pop();
				String a = stack.pop();
				int s = Integer.valueOf(a) - Integer.valueOf(b);
				stack.push(String.valueOf(s));
			}
			else if (c.matches("\\*"))
			{
				String b = stack.pop();
				String a = stack.pop();
				int s = Integer.valueOf(a) * Integer.valueOf(b);
				stack.push(String.valueOf(s));
			}
			else if (c.matches("\\/"))
			{
				String b = stack.pop();
				String a = stack.pop();
				int s = Integer.valueOf(a) / Integer.valueOf(b);
				stack.push(String.valueOf(s));
			}
			else
			{
				stack.push(c);
			}
		}

		return Double.valueOf(stack.pop());
	}

	public static boolean scramble(String str1, String str2)
	{
		HashMap<Character, Integer> mappa = new HashMap<>();
		for (char c : str1.toCharArray())
		{
			mappa.put(c, 1 + mappa.getOrDefault(c, 0));
		}
		for (char c : str2.toCharArray())
		{
			Integer contatore = mappa.getOrDefault(c, 0);
			if (contatore == 0)
			{
				return false;
			}
			mappa.put(c, --contatore);
		}
		return true;
	}

	public static double going(int n)
	{

		BigDecimal fattore = BigDecimal.ONE.setScale(6, BigDecimal.ROUND_UNNECESSARY);
		BigDecimal somma = BigDecimal.ZERO.setScale(6, BigDecimal.ROUND_UNNECESSARY);
		for (int i = 1; i <= n; i++)
		{
			fattore = fattore.multiply(BigDecimal.valueOf(i));
			somma = somma.add(fattore);
		}

		BigDecimal graneNumero = somma.divide(fattore, BigDecimal.ROUND_FLOOR);
		return graneNumero.doubleValue();
	}

	public static String rangeExtraction(int[] arr)
	{
		List<String> listaArr = new ArrayList<>();
		int consecutivi = 0;
		for (int i = 0; i < arr.length;)
		{
			consecutivi = 0;
			String start = String.valueOf(arr[i]);
			while ((i != (arr.length - 1)) && ((arr[i + 1] - arr[i]) == 1))
			{
				consecutivi++;
				i++;
			}
			if (consecutivi > 0)
			{
				if (consecutivi > 1)
				{
					start += "-" + (Integer.parseInt(start) + consecutivi);
				}
				else
				{
					i--;
				}
			}
			listaArr.add(start);
			i++;
		}

		return String.join(",", listaArr);
	}

	public static int calcolaOccorrenze(List<Integer> listaElements, int val)
	{
		int occ = 0;
		for (Integer e : listaElements)
		{
			if (e.intValue() == val)
			{
				occ++;
			}
		}
		return occ;
	}

	public static int[] deleteNth(int[] elements, int maxOccurrences)
	{
		List<Integer> listaElements = new ArrayList<>();
		int arr[] = null;
		for (int e : elements)
		{
			if (calcolaOccorrenze(listaElements, e) < maxOccurrences)
			{
				listaElements.add(e);
			}
		}
		arr = listaElements.stream().mapToInt(e -> e).toArray();
		return arr;
	}

	public static int[][] twosDifference(int[] array)
	{

		List<int[]> aRet = new ArrayList<int[]>();

		List<Integer> lista = Arrays.stream(array).boxed().collect(Collectors.toList());
		Collections.sort(lista);

		int[] arrayOredr = lista.stream().mapToInt(i -> i).toArray();

		for (int i = 0; i < arrayOredr.length; i++)
		{
			for (int j = 0; j < arrayOredr.length; j++)
			{
				if ((arrayOredr[j] - arrayOredr[i]) == 2)
				{
					int arr[] = new int[2];
					arr[0] = arrayOredr[i];
					arr[1] = arrayOredr[j];
					aRet.add(arr);
				}
			}
		}

		// aRet.stream().forEach(a -> System.out.println(a[0] + "," + a[1]));

		int a[][] = new int[aRet.size()][2];
		for (int x = 0; x < aRet.size(); x++)
		{
			a[x] = new int[] { aRet.get(x)[0], aRet.get(x)[1] };
			System.out.println(a[x][0] + "," + a[x][1]);
		}

		return a;

	}

	public static String recoverSecret(char[][] triplets)
	{
		List<Character> chiave_segreta = new ArrayList<>();
		for (int i = 0; i < triplets.length; i++)
		{
			char[] tripletta = triplets[i];
			handleTriplet(chiave_segreta, tripletta);
		}
		for (int i = triplets.length - 1; i >= 0; i--)
		{
			char[] tripletta = triplets[i];
			handleTriplet(chiave_segreta, tripletta);
		}
		return chiave_segreta.stream().map(String::valueOf).collect(Collectors.joining());
	}

	private static void handleTriplet(List<Character> chiave_segreta, char[] tripletta)
	{
		Boolean pulita = true;
		for (char ch : tripletta)
		{
			if (chiave_segreta.contains(ch))
			{
				pulita = false;
			}
		}
		if (pulita)
		{
			gestisciTriplettaPulita(chiave_segreta, tripletta);
		}
		else
		{
			gestisciTriplettaSporca(chiave_segreta, tripletta);
		}
	}

	private static void gestisciTriplettaPulita(List<Character> chiave_segreta, char[] tripletta)
	{
		for (char ch : tripletta)
		{
			chiave_segreta.add(ch);
		}
	}

	private static void gestisciTriplettaSporca(List<Character> chiave_segreta, char[] triplet)
	{
		for (int i = 0; i < triplet.length; i++)
		{
			if (chiave_segreta.contains(triplet[i]) && (i < (triplet.length - 1)))
			{
				if (!chiave_segreta.contains(triplet[i + 1]))
				{
					chiave_segreta.add(chiave_segreta.indexOf(triplet[i]), triplet[i + 1]);
				}
				else if (chiave_segreta.indexOf(triplet[i]) > chiave_segreta.indexOf(triplet[i + 1]))
				{
					chiave_segreta.remove(chiave_segreta.indexOf(triplet[i]));
					chiave_segreta.add(chiave_segreta.indexOf(triplet[i + 1]), triplet[i]);
				}
			}
			if (chiave_segreta.contains(triplet[i]) && (i > 0))
			{
				if (!chiave_segreta.contains(triplet[i - 1]))
				{
					chiave_segreta.add(chiave_segreta.indexOf(triplet[i]), triplet[i - 1]);
				}
				else if (chiave_segreta.indexOf(triplet[i]) < chiave_segreta.indexOf(triplet[i - 1]))
				{
					chiave_segreta.remove(chiave_segreta.indexOf(triplet[i]));
					chiave_segreta.add(chiave_segreta.indexOf(triplet[i - 1]) + 1, triplet[i]);
				}
			}
		}
	}

	public static String encryptThis(String text)
	{
		if ((text == null) || text.isEmpty())
		{
			return "";
		}
		String str = "";
		List<String> listStr = Arrays.asList(text.split("\\s+"));

		for (String s : listStr)
		{
			String appo = s;
			if (s.length() >= 2)
			{
				char[] aAppo = s.toCharArray();
				char temp = aAppo[1];
				aAppo[1] = aAppo[s.length() - 1];
				aAppo[s.length() - 1] = temp;
				appo = new String(aAppo);
			}

			appo = (int) s.charAt(0) + appo.substring(1);
			System.out.println("STR: " + appo);
		}
		return str;
	}

	public static String[] solution(String s)
	{
		s = s.replaceAll("\\s", ".");
		List<String> lStr = new ArrayList<>();
		int a = 0, b = 0;
		for (int i = 0; i <= (s.length() / 2); i++)
		{
			a = i * 2;
			b = (a + 2) > s.length() ? s.length() : a + 2;
			String tmp = s.substring(a, b);
			if (!tmp.isEmpty())
			{
				tmp = String.format("%-2s", tmp);
				tmp = tmp.replaceAll("\\s", "_");
				tmp = tmp.replaceAll("\\.", " ");
				lStr.add(tmp);
			}
		}
		lStr.stream().forEach(e -> System.out.println(e));
		return lStr.stream().toArray(String[]::new);
	}

	public static int findMissingNumber(int[] numbers)
	{
		int num = numbers.length + 1;
		for (int i = 0; i < numbers.length; i++)
		{
			num += (1 + i) - numbers[i];
		}
		return num;
	}

	public static String capitalize(String str)
	{
		if ((str == null) || str.isEmpty())
		{
			return str;
		}

		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String greet(String name)
	{
		System.out.println(name);
		return "Hello " + capitalize(name.toLowerCase());
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// int[] array = new int[] { -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14,
		// 15, 17, 18, 19, 20 };
		// System.out.println(rangeExtraction(array));
		// int a[] = deleteNth(new int[] {}, 2);
		//
		// Arrays.stream(a).boxed().collect(Collectors.toList()).stream().forEach(i ->
		// System.out.print(i + ","));
		int[] arr = new int[] { 1, 23, 3, 4, 7 };
		twosDifference(arr);

		char[][] triplette = { { 't', 'u', 'p' }, { 'w', 'h', 'i' }, { 't', 's', 'u' }, { 'a', 't', 's' }, { 'h', 'a', 'p' }, { 't', 'i', 's' }, { 'w', 'h', 's' } };
		System.out.println(recoverSecret(triplette));

		System.out.println(encryptThis("lived"));

		solution(" bcde");

		System.out.println(findMissingNumber(new int[] { 1, 2, 3, 4 }));

		System.out.println(greet("ciao"));

	}

}
