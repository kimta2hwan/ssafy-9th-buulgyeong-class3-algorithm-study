class P20546 {
	public static void main(String[] args) throws Exception {
		int[] day = new int[14];
		int june, sung, juneCount, sungCount;
		june = sung = read();
		juneCount = sungCount = 0;
		
		for (int i = 0; i < 14; i++) {
			day[i] = read();
		}
		
		for (int i = 0; i < 14; i++) {
			if (day[i] > 0 && june / day[i] > 0) {
				juneCount += june / day[i];
				june %= day[i];
			}
			
			if (i >= 3) {
				if (day[i - 1] > day[i - 2] && day[i - 2] > day[i - 3]) {
					if (sungCount > 0) {
						sung += sungCount * day[i];
						sungCount = 0;
					}
					
				} else if (day[i - 1] < day[i - 2] && day[i - 2] < day[i - 3]) {
					if (day[i] > 0 && sung / day[i] > 0) {
						sungCount += sung / day[i];
						sung %= day[i];
					}
				}
			}
		}
		
		int juneTotal = june + juneCount * day[13];
		int sungTotal = sung + sungCount * day[13];
		
		if (juneTotal == sungTotal) {
			System.out.print("SAMESAME");
		} else {
			System.out.print(juneTotal > sungTotal ? "BNP" : "TIMING");
		}
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}

        if (c == 13) {
            System.in.read();
        }
		
		return n;
	}
}
