public class Gold_Code implements Strategy{
    @Override
    public String makeCode(String id) {
        return CodeGenerator.makeCode("Gold" + id);
    }
}
