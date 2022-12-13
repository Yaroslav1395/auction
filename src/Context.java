public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public String getCode(String id){
        return strategy.makeCode(id);
    }
}
