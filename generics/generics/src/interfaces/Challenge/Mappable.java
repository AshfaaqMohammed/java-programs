package interfaces.Challenge;

enum Geometry{LINE, POINT, POLYGON}

enum Color{BLACK, BLUE, RED, GREEN, ORANGE}

enum PointMarker{CIRCLE, PUSH_PIN, STAR, SQUARE, TRIANGLE}

enum LineMarker {DASHED, DOTTED, SOLID}

public interface Mappable {
    String JSON_PROPERTY = """
            "Properties": {%s}
            """;
    String getLabel();
    Geometry getShape();
    String getMarker();

    default String toJson(){
        return """
                "type":"%s", "label":"%s", "marker":"%s"
                """.formatted(getShape(),getLabel(),getMarker());
    }

    static void mapIt(Mappable mappable){
        System.out.println(JSON_PROPERTY.formatted(mappable.toJson()));
    }



}
