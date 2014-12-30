package sample.jsfwitharquillian;

import static org.hamcrest.CoreMatchers.is;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 * Arqullianを使ったPOJOなSumクラスのテスト
 * @author kikuta
 */
@RunWith(Arquillian.class)
public class SumTest {
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Sum.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Test
    public void sumTest() {
        Sum mySum = new Sum();
        assertThat(mySum.sum(1, 1), is(2));
        assertThat(mySum.sum(2, 2), is(4));
        assertThat(mySum.sum(3, 3), is(6));
        assertThat(mySum.sum(4, 4), is(8));
        assertThat(mySum.sum(5, 5), is(10));
    }
}
