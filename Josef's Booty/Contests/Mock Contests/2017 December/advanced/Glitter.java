package mockContests.december2017.advanced;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Glitter {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("src/mockContests/december2017/advanced/data/sampledata/glitter.dat")).skip(1)
				.map(BigInteger::new).map(Glitter::sqrt).forEachOrdered(System.out::println);
	}

	public static BigInteger sqrtExp(BigInteger x) {
		BigInteger sqrt = BigInteger.ZERO;
		while(sqrt.pow(2).compareTo(x) < 0)
			for(int base = 10; base > 1; base--) {
				BigInteger b = BigInteger.valueOf(base);
				while(sqrt.add(b).pow(2).compareTo(x) < 0)
					b = b.multiply(BigInteger.valueOf(base));
				sqrt = sqrt.add(b.divide(BigInteger.valueOf(base)));
			}
		while(sqrt.pow(2).compareTo(x) > 0)
			sqrt = sqrt.subtract(BigInteger.ONE);
		return sqrt;
	}

	public static BigInteger sqrtBabylon(BigInteger x) {
		BigInteger guess = x.shiftRight(x.bitLength() / 2), previous = x;
		while(!guess.equals(previous)) {
			previous = guess;
			guess = x.divide(guess).add(guess).divide(BigInteger.valueOf(2));
		}
		return guess;
	}

	public static BigInteger sqrt(BigInteger x) {
		if(x.equals(BigInteger.ZERO))
			return BigInteger.ZERO;
		BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2), div2 = div;
		for(;;) {
			BigInteger y = div.add(x.divide(div)).shiftRight(1);
			if(y.equals(div) || y.equals(div2))
				return y;
			div2 = div;
			div = y;
		}
	}
	// proof
	// x = 250
	// div = 2 ^ (bitLen(250) / 2)
	// = 2 ^ 4
	// = 8
	// div2 = div = 8
	// ---------------------------------
	// y = (8 + (250 / 8)) >> 1
	// = (8 + 31) >> 1
	// = 39 >> 1
	// = 19
	// if(y == div || y == div2)
	// if(19 == 8 || 19 == 8)
	// false
	// div2 = div = 8
	// div = 19
	// *********************************
	// y = (19 + (250 / 19)) >> 1
	// = (19 + 13) >> 1
	// = 16
	// if(16 == 19 || 16 == 8)
	// false
	// div2 = div = 19
	// div = 16
	// *********************************
	// y = (16 + (250 / 16)) >> 1
	// = (16 + 15) >> 1
	// = 15
	// if(15 == 16 || 15 == 19)
	// false
	// div2 = div = 16
	// div = 15
	// *********************************
	// y = (15 + (250 / 15)) >> 1
	// = (15 + 16) >> 1
	// = 15
	// if(15 == 15 || 15 == 16)
	// true... return 15
	// *********************************
	// 15^2 = 225 < 250
	// 16^2 = 256 > 250
}
