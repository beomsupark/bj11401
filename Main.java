import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[] factorial;
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		long p = 1000000007;
		factorial = new long[n+1];
		factorial[0]=1;
		for( int i=1;i<=n;i++)
		{
			factorial[i]=(i*factorial[i-1]%p);
		}
		long bound = (factorial[n-k] * factorial[k])%p;
		long answer = 1;
		long index = p-2;
		while(index>0)
		{
			if(index%2==1)
			{
				answer = (answer * bound)%p;
			}
			bound = (bound*bound)%p;
			index =index/2;
		}
		long answer_2 = (factorial[n] * answer)%p;
		System.out.print(answer_2);
	}
}

