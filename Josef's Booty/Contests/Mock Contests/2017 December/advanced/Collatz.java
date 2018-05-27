package mockContests.december2017.advanced;

import java.io.File;
import java.io.IOException;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

public class Collatz {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/advanced/data/judgesdata/collatz.dat"));
		for(int T = file.nextInt(); T > 0; --T)
			System.out.println(
					getCollatzStream(file.nextInt()).mapToObj(Long::toString).collect(Collectors.joining(" ")));
		file.close();
	}

	public static LongStream getCollatzStream(long seed) {
		final PrimitiveIterator.OfLong iterator = new PrimitiveIterator.OfLong() {
			long n = seed, prev = n;

			public boolean hasNext() {
				return this.prev != 1;
			}

			public long nextLong() {
				final long val = this.n;
				this.n = (this.n & 1) == 1 ? 3 * this.n + 1 : this.n / 2;
				prev = val;
				return val;
			}
		};
		return StreamSupport.longStream(Spliterators.spliteratorUnknownSize(iterator, 0), false);
	}
}
