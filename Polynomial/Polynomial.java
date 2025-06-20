public class Polynomial {
	int degcoeff[];
	
	Polynomial(){
		degcoeff = new int[20];
	}
	
	public void setCoefficient(int degree, int coeff) {
		if(degree >= degcoeff.length) {
			int temp[] = degcoeff;
			degcoeff = new int[degree+1];
			for(int i = 0;i<temp.length;i++) {
				degcoeff[i] = temp[i];
			}
		}
		degcoeff[degree] = coeff;
	}
	
	public void print() {
		for(int i = 0;i<degcoeff.length;i++) {
			if(degcoeff[i]!=0) {
				System.out.print(degcoeff[i]+ "x"+ i +" ");
			}
		}
		System.out.println();
	}
	
	public Polynomial add(Polynomial p) {
		Polynomial ans = new Polynomial();
		int plen1 = this.degcoeff.length;
		int plen2 = p.degcoeff.length;
		
		int len = Math.min(plen1, plen2);
		int i;
		for(i = 0;i<len;i++) {
			ans.setCoefficient(i,this.degcoeff[i] + p.degcoeff[i]);
		}
		while(i<plen1) {
			ans.setCoefficient(i, this.degcoeff[i]);
			i++;
		}
		while(i<plen2) {
			ans.setCoefficient(i, p.degcoeff[i]);
			i++;
		}
		return ans;
	}
	
	public Polynomial substract(Polynomial p) {
		Polynomial ans = new Polynomial();
		int plen1 = this.degcoeff.length;
		int plen2 = p.degcoeff.length;
		int len = Math.min(plen1, plen2);
		int i;
		for(i = 0;i<len;i++) {
			ans.setCoefficient(i, this.degcoeff[i] - p.degcoeff[i]);
		}
		while(i<plen1) {
			ans.setCoefficient(i, this.degcoeff[i]);
			i++;
		}
		while(i<plen2) {
			ans.setCoefficient(i, -p.degcoeff[i]);
			i++;
		}
		return ans;
	}
	
	public int getCoeff(int degree) {
		if(degree < this.degcoeff.length) {
			return this.degcoeff[degree];
		}else {
			return 0;
		}
	}
	
	public Polynomial multiply(Polynomial p) {
		Polynomial ans = new Polynomial();
		for(int i=0;i<this.degcoeff.length;i++) {
			for(int j = 0;j<p.degcoeff.length;j++) {
				int termdegree = i + j;
				int termcoeff = this.degcoeff[i] * p.degcoeff[j];
				int oldcoeff = ans.getCoeff(termdegree);
				ans.setCoefficient(termdegree, oldcoeff+termcoeff);
			}
		}
		return ans;
	}

}
