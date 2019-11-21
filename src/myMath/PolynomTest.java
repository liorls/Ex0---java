package myMath;

public class PolynomTest
{
    public static void main(String[] args)
    {
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
		test9();
		test10();
    }

	public static void test2() {
		Polynom p1 = new Polynom(), p2 =  new Polynom();
		String[] monoms1 = {"2", "-x","-3.2x^2","4","-1.5x^2"};
		String[] monoms2 = {"5", "1.7x","3.2x^2","-3","-1.5x^2"};
		for(int i=0;i<monoms1.length;i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for(int i=0;i<monoms2.length;i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		System.out.println("p1: "+p1);
		System.out.println("p2: "+p2);
		p1.add(p2);
		System.out.println("p1+p2: "+p1);
		p1.multiply(p2);
		System.out.println("(p1+p2)*p2: "+p1);
		String s1 = p1.toString();
		Polynom_able pp1 = new Polynom(s1);
		System.out.println("from string: "+pp1);
	}

    /* test for derative */
	public static void test10()
	{
		Polynom p1 = new Polynom("x^2+5x^8+9");
		p1.derivative();
		System.out.println(p1);

		Polynom p2 = new Polynom("11x^6+5x^3+22x");
		p2.derivative();
		System.out.println(p2);
	}

    /* test for area (Rymn intergral) */
	public static void test9()
	{
		Polynom p1 = new Polynom("x");
		double area = p1.area(0, 1, 0.001);
		System.out.println(area);

		Polynom p2 = new Polynom("4x^2-3x+9");
		area = p2.area(0, 1, 0.001);
		System.out.println(area);
	}

    /* test for equals and isZero */
    public static void test8()
    {
        Polynom p1 = new Polynom("3+2.6X^3-76x");
        Polynom p2 = new Polynom("3+2.6X^3-76x");
        Polynom p3 = new Polynom("3+2.6X^3");

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));

        Polynom p4 = new Polynom();
        System.out.println((p4.isZero()));
        System.out.println((p1.isZero()));
    }

    /* test for multiply Poly with Poly */
    public static void test7()
    {
        Polynom p1 = new Polynom("3+2.6X^3-76x");
        Polynom p2 = new Polynom("2x");
        p1.multiply(p2);
        System.out.println(p1);
        System.out.println(p2); // assert didn't change

        Polynom p3 = new Polynom("5x+92x^3+5x^6");
        p1.multiply(p3);
        System.out.println(p1);
    }


    /* test for multiply Poly with Monom */
    public static void test6()
    {
        Polynom p1 = new Polynom("3+2.6X^3-76x");
        Monom m1 = new Monom("2x");
        p1.multiply(m1);
        System.out.println(p1);

        Monom m2 = new Monom("2x^3");
        p1.multiply(m2);
        System.out.println(p1);
    }


    /* test for substruct */
    public static void test5()
    {
        Polynom p1 = new Polynom("3+2.6X^3-76x");
        Polynom p2 = new Polynom("2+1.6X^3-66x-1x^8");
        p1.substract(p2);
        System.out.println(p1);
        System.out.println(p2); //shall remain unchanged (because using copy ctor)
    }

    /* test for add polynom */
    public static void test4()
    {
        Polynom p1 = new Polynom("3+1.4X^3-34x");
        Polynom p2 = new Polynom("2+1.6X^3-66x");
        p1.add(p2);
        System.out.println(p1);
        System.out.println(p2); //shall remain unchanged

        Polynom p3 = new Polynom("3X^2+1.4X^5-34x^8");
        Polynom p4 = new Polynom("2+1.6X^3-66x");
        p3.add(p4);
        System.out.println(p3); //shall remain unchanged
        System.out.println(p4); //shall remain unchanged
    }

    /* test for f(x) polynom */
    public static void test3()
    {
        Polynom p1 = new Polynom("3+1.4X^3-34x");
        System.out.println(p1.f(1));
        System.out.println(p1.f(2));
        System.out.println(p1.f(-2));
    }


}
