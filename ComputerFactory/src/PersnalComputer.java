public class PersnalComputer extends Product{

    private Monitor monitor;
    private MotherBoard motherBoard;
    private ComputerCase computerCase;

    public PersnalComputer(String model, String manufacturer, Monitor monitor, MotherBoard motherBoard, ComputerCase computerCase){
        super(model, manufacturer);
        this.computerCase = computerCase;
        this.monitor = monitor;
        this.motherBoard = motherBoard;
    }

    public void drawLogo(){
        this.monitor.drawPixelAt(1200,500,"black");
    }

    public void load(){
        this.computerCase.pressPowerButton();
        drawLogo();
    }

    @Override
    public String toString() {
        return "PersnalComputer{" +
                "monitor=" + monitor +
                ", motherBoard=" + motherBoard +
                ", computerCase=" + computerCase +
                "} " + super.toString();
    }
}
