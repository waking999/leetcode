package history.common;

import org.junit.Assert;

public interface ISolution<R,I> {
	public R solution(I i);
	
	public default void test(I i,R e){
		R r=this.solution(i);
		
		Assert.assertEquals(r, e);
		
	}
}
