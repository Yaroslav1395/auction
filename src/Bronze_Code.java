public class Bronze_Code implements Strategy{
    @Override
    public String makeCode(String id) {
        return CodeGenerator.makeCode("Bronze" + id);
    }
}
