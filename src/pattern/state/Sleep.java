package pattern.state;

/**
 * Created by lzf on 2016/10/9.
 */
public class Sleep implements State{
    @Override
    public void showState() {
        System.out.println("sleep");
    }
}
