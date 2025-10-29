package interfaces.Challenge;

enum UtilityType { ELECTRIC, WATER , GAS, FABRIC_OPTIC}

public class Utility implements Mappable {
    String name;
    UtilityType utilityType;

    public Utility(String name, UtilityType utilityType){
        this.name = name;
        this.utilityType = utilityType;
    }

    public String getLabel(){
        return name + "(" + this.utilityType + ")";
    }

    public Geometry getShape(){
        return Geometry.LINE;
    }

    public String getMarker(){
        return switch (utilityType){
            case GAS -> Color.GREEN + " "+ LineMarker.DOTTED;
            case ELECTRIC -> Color.ORANGE + " " + LineMarker.DASHED;
            case WATER -> Color.BLUE + " " + LineMarker.DOTTED;
            case FABRIC_OPTIC -> Color.RED + " " + LineMarker.SOLID;
            default -> Color.BLACK + " " + LineMarker.DASHED;
        };
    }

}
