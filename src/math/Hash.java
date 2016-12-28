package math;

public class Hash <T>{
	
	public void linearProbingInsert(T[] h, int m, int x, T entry) {
		int p = x%m;
		int i = 0;
		while(h[p] != null && i < m) {
			i++;
			p = (x + i)%m;
		}
		h[p] = entry;
	}
	
	public T linearProbingSearch(T[] h, int m, int x, T entry) {
		int p = x%m;
		int i = 0;
		while(h[p] != null && h[p] != entry && i < m) {
			i++;
			p = (x + i)%m;
		}
		
		if(h[p] == entry)
			return h[p];
		
		return null;
	}
}
