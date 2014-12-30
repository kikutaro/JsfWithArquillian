package sample.jsfwitharquillian;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;

/**
 *
 * @author kikuta
 */
@Named(value = "sumBean")
@RequestScoped
//@SessionScoped
//@ViewScoped //なぜかViewScopedは駄目
public class SumBean implements Serializable{
    public int sum(int x, int y){
        return x + y;
    }
}
