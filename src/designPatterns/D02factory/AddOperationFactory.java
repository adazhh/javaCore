package designPatterns.D02factory;

public class AddOperationFactory implements OperationFactory {
    @Override
    public operationType createType() {
        return new AddType();
    }
}
