package sample.jsfwitharquillian;

import javax.inject.Inject;
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
 * Arqullianを使ったCDI管理BeanなSumBeanクラスのテスト
 * @author kikuta
 */
@RunWith(Arquillian.class)
public class SumBeanTest {
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(SumBean.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Inject
    SumBean mySum;
    
    @Test
    public void sumTest() {
        assertThat(mySum.sum(1, 1), is(2));
        assertThat(mySum.sum(2, 2), is(4));
        assertThat(mySum.sum(3, 3), is(6));
        assertThat(mySum.sum(4, 4), is(8));
        assertThat(mySum.sum(5, 5), is(10));
    }
}
