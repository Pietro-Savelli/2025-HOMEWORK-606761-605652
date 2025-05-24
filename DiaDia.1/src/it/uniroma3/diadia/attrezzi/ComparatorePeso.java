package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatorePeso implements Comparator<Attrezzo>{

	@Override
	public int compare(Attrezzo a1, Attrezzo a2) {
		int app = a1.getPeso()-a2.getPeso();
		if(app==0)
			app = a1.compareTo(a2);
		return app;
	}

}
