public class For_sale extends State{
    public For_sale(Lot lot) {
        super(lot);
    }

    @Override
    public void startSale() {
        System.out.println("Товар уже на торгах");
    }

    @Override
    public void raisePrice() {
        super.getLot().setPrice(super.getLot().getPrice() + 20);
        super.getLot().setIs_sale(true);
        System.out.println("Цена повышена");
        System.out.println("Введите номер действия: ");
    }

    @Override
    public void withdraw() {
        if (super.getLot().isIs_sale()){
            System.out.println("Товар продан");
            System.out.println("Введите номер действия: ");
        }
        else {
            super.getLot().setState(new In_stock(super.getLot()));
            super.getLot().setState_as_string("На складе");
            System.out.println("Введите номер действия: ");
        }
    }

    @Override
    public void giveToTheWinner() {
        if(super.getLot().isIs_sale()){
            super.getLot().setState(new Sold(super.getLot()));
            //часть метода отвечающая за логику реализации патерна стратегия
            if(super.getLot().getPrice() >= 1000){
                super.getLot().setContext(new Context(new Gold_Code()));
            } else if (super.getLot().getPrice() >= 500 && super.getLot().getPrice() < 1000) {
                //имея доступ к состоянию объекта(контексту), мы можем создать новый объект контекста и
                //и через конструктор передеать в него конкретную реализацию стратегии
                super.getLot().setContext(new Context(new Silver_Code()));
            } else {
                super.getLot().setContext(new Context(new Bronze_Code()));
            }
            //имея в контексте ссылку на объект стратегии, метод вызываемый у контекста, сработает согласно
            // той стратегии, ссылка на которую хранится в поле контекста
            super.getLot().setHonorary_code(super.getLot().getContext().getCode(super.getLot().getId()));
            super.getLot().setState_as_string("Продано");
            System.out.println("Товар выдан победителю");
            System.out.println("Введите номер действия: ");
        }
        else {
            System.out.println("Товар не куплен. Невозможно отдать");
            System.out.println("Введите номер действия: ");
        }
    }
}



