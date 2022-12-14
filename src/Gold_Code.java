//конкретная стратегия
public class Gold_Code implements Strategy{
    //реализация метода интерфейса
    @Override
    public String makeCode(String id) {
        //для того чтобы не переписывать код, метод был прописан в отдельном классе
        //в этот метод передаются параметры соответствующие конкретной стратегии
        return CodeGenerator.makeCode("Gold" + id);
    }
}
