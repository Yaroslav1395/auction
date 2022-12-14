//конкретная стратегия
public class Silver_Code implements Strategy{
    @Override
    public String makeCode(String id) {
        //для того чтобы не переписывать код, метод был прописан в отдельном классе
        //в этот метод передаются параметры соответствующие конкретной стратегии
        return CodeGenerator.makeCode("Silver" + id);
    }
}
