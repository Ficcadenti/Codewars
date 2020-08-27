package it.raffo.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test
{
	public static String	a		= "code";
	public static String	b		= "wa.rs";
	public static String	name	= a + b;

	public static int findLongest(final String str)
	{
		String[] spl = str.split(" ");
		int longest = 0;
		for (int i = 0; i > spl.length; i++)
		{
			if (spl[i].length() > longest)
			{
				longest = spl[i].length();
			}
		}
		return longest;
	}

	public static boolean validatePin(String pin)
	{
		System.out.println(pin);
		return pin.matches("/[0-9]/g");
	}

	public static int sum(int[] arr)
	{
		return Arrays.stream(arr).filter(v -> v > 0).sum();
	}

	public static boolean isMagic(long num)
	{
		boolean bRet = false;
		String strNum = "" + num;
		long tot = 0;
		for (int i = 0; i < strNum.length(); i++)
		{
			tot += (long) Math.pow(Long.parseLong("" + strNum.charAt(i)), i + 1);
		}
		return tot == num;
	}

	public static List<Long> sumDigPow(long a, long b)
	{
		List<Long> eureka = new ArrayList<>();
		for (long val = a; val < b; val++)
		{
			if (isMagic(val))
			{
				eureka.add(val);
			}
		}

		return eureka;
	}

	public static String expandedForm(int num)
	{
		String strNum = Integer.toString(num);
		int esponente = strNum.length() - 1;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < strNum.length(); i++)
		{
			int base = Integer.valueOf("" + strNum.charAt(i));
			if (base != 0)
			{
				list.add((int) (base * Math.pow(10, esponente)));
			}
			esponente--;
		}
		return list.stream().map(Object::toString).collect(Collectors.joining(" + "));
	}

	final static int	START	= 0;
	final static int	END		= 1;

	public static int sumIntervals(int[][] intervals)
	{
		if ((intervals == null) || (intervals.length == 0))
		{
			return 0;
		}
		int[][] intervalliUniti = unisci(intervals);
		int somma = 0;
		for (int i = 0; i < intervalliUniti.length; i++)
		{
			somma += intervalliUniti[i][1] - intervalliUniti[i][0];
		}
		return somma;
	}

	private static int[][] ordinaIntervalli(int[][] intervals)
	{

		Arrays.sort(intervals, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] intervallo, int[] intervallo2)
			{
				if (intervallo[Test.START] > intervallo2[Test.START])
				{
					return 1;
				}
				else if (intervallo[Test.START] < intervallo2[Test.START])
				{
					return -1;
				}
				else
				{
					return 0;
				}
			}
		});

		return intervals;
	}

	private static int[][] unisci(int[][] intervals)
	{

		intervals = ordinaIntervalli(intervals);

		int[][] intervalliUniti = new int[intervals.length][2];
		int start = intervals[0][START];
		int end = intervals[0][END];
		int startAttuale;
		int endAttuale;
		for (int i = 1; i < intervals.length; i++)
		{
			startAttuale = intervals[i][START];
			endAttuale = intervals[i][END];
			if (startAttuale == endAttuale)
			{
				continue;
			}
			if (startAttuale <= end)
			{
				end = Math.max(endAttuale, end);
			}
			else
			{
				intervalliUniti[i][START] = start;
				intervalliUniti[i][END] = end;
				start = startAttuale;
				end = endAttuale;
			}
		}
		intervalliUniti[0][START] = start;
		intervalliUniti[0][END] = end;
		return intervalliUniti;
	}

	public static int sumIntervals1(int[][] intervals)
	{
		if (intervals == null)
		{
			return 0;
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < intervals.length; i++)
		{
			for (int j = intervals[i][0]; j < intervals[i][1]; j++)
			{
				set.add(j);
			}
		}

		return set.size();
	}

	// List lst = Arrays.asList(arr);

	public static int findSmallestInt(int[] args)
	{
		List<Integer> lista = Arrays.stream(args).boxed().collect(Collectors.toList());
		Collections.sort(lista);
		// return Collections.min(lista);
		return Arrays.stream(args).boxed().collect(Collectors.toList()).stream().mapToInt(e -> e).min().orElse(Integer.MAX_VALUE);

	}

	public static int[] digitize(long n)
	{
		StringBuilder sb = new StringBuilder("" + n);
		String strNum = sb.reverse().toString();
		int[] num = new int[strNum.length()];
		for (int i = 0; i < strNum.length(); i++)
		{
			num[i] = Integer.parseInt("" + strNum.charAt(i));
		}
		return num;
	}

	public static void main(String[] args)
	{
		System.out.println(MorseCodeDecoder.decode(".-. .- ..-. ..-. ---"));
		System.out.println(validatePin("123456"));
		List<Long> eureka = sumDigPow(1, 100);
		eureka.forEach(e -> System.out.println(e));
		System.out.println(expandedForm(91));
		System.out.println(sumIntervals1(new int[][] { { 1, 2 }, { 3, 5 } }));
		System.out.println(findSmallestInt(new int[] { 5, 3, -10, 1 }));

		List<Integer> lista = Arrays.stream(digitize(12345)).boxed().collect(Collectors.toList());
		lista.stream().forEach(e -> System.out.println(e));
	}

}
