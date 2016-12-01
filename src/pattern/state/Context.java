package pattern.state;

/**
 * 状态模式
 * Created by lzf on 2016/10/9.
 */
public class Context {
    private State state;

    Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void showState() {
        state.showState();
    }

    public static void main(String[] args) {
         Context context = new Context( new Sleep());
         context.showState();
    }
}
