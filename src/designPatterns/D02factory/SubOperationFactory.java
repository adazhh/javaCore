package designPatterns.D02factory;

public class SubOperationFactory implements OperationFactory {
    @Override
    public operationType createType() {
        return new SubType();
    }
}
