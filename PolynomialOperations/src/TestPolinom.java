import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import poli_model.Monom;
import poli_model.Polinom;

class TestPolinom {
@Test
	void test_adunare() {
	String [] s1= {"x^2+1", "-x^2+9", "-15x^5+3"};
	String [] s2= {"x^2+1", "13x-2", "3x^2-9"};
	String [] rez= {"+2x^2+2", "-x^2+13x+7", "-15x^5+3x^2-6"};
	for(int i=0; i<3; i++) {
	Polinom p1=new Polinom();
	p1.setPolinom(s1[i]);
	Polinom p2=new Polinom();
	p2.setPolinom(s2[i]);
	Polinom p3=new Polinom();
	p3=p1.adunare(p2);
	assertEquals(p3.FormarePolinom(), rez[i]);
	}
	
}
@Test
void test_scadere() {
	String [] s1= {"x^2+1", "6x^3+5x^2+5", "-15x^3+3"};
	String [] s2= {"x","-6x^2-4x+1","3x^2+9"};
	String [] rez= {"+x^2-x+1","+6x^3+11x^2+4x+4", "-15x^3-3x^2-6"};
	for(int i=0; i<3; i++)
	{
		Polinom p1=new Polinom();
		p1.setPolinom(s1[i]);
		Polinom p2=new Polinom();
		p2.setPolinom(s2[i]);
		Polinom p3=new Polinom();
		p3=p1.scadere(p2);
		assertEquals(p3.FormarePolinom(), rez[i]);
	}
}
@Test
void test_inmultire() {
	String [] s1= {"x^2+1", "6x^3+5x^2+5", "-15x^3+3"};
	String [] s2= {"x","-6x^2-4x+1","3x^2+9"};
	String [] rez= {"+x^3+x","-36x^5-24x^4+6x^3-30x^4-20x^3+5x^2-30x^2-20x+5", "-45x^5-135x^3+9x^2+27"};
	for(int i=0; i<3; i++)
	{
		Polinom p1=new Polinom();
		p1.setPolinom(s1[i]);
		Polinom p2=new Polinom();
		p2.setPolinom(s2[i]);
		Polinom p3=new Polinom();
		p3=p1.inmulteste(p2);
		assertEquals(p3.FormarePolinom(), rez[i]);
	}
}
@Test
void test_derivare() {
	String [] s1= {"x^2+1", "6x^3+5x^2+5", "-15x^3+3"};
	String [] rez= {"+2x","+18x^2+10x", "-45x^2"};
	for(int i=0; i<3; i++)
	{
		Polinom p1=new Polinom();
		p1.setPolinom(s1[i]);
		Polinom p3=new Polinom();
		p3=p1.derivare();
		assertEquals(p3.FormarePolinom(), rez[i]);
	}
}
@Test
void test_integrare() {
	String [] s1= {"x^2+1", "6x^3+5x^2+5", "-15x^3+3"};
	String [] rez= {"+0.3333333333333333x^3+x","+1.5x^4+1.6666666666666667x^3+5.0x", "-3.75x^4+3.0x"};
	for(int i=0; i<3; i++)
	{
		Polinom p1=new Polinom();
		p1.setPolinom(s1[i]);
		Polinom p3=new Polinom();
		p3=p1.integrare();
		assertEquals(p3.FormarePolinomDouble(), rez[i]);
	}
	
}
@Test
void test_impartire() {
	String [] s1= {"x^2+1", "x^2+x"};
	String [] s2= {"x","x"};
	String [] rez= {"cat: +x  rest: +1.0","cat: +x  rest: +x"};
	for(int i=0; i<2; i++)
	{
		Polinom p1=new Polinom();
		p1.setPolinom(s1[i]);
		Polinom p2=new Polinom();
		p2.setPolinom(s2[i]);
		String p3;
		p3=p1.imparte(p2);
		assertEquals(p3, rez[i]);
	}
}

}
