public class Silver_Code implements Strategy{
    @Override
    public String makeCode(String id) {
        return CodeGenerator.makeCode("Silver" + id);
    }
}
