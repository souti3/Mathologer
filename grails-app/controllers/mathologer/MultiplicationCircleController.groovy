package mathologer

class MultiplicationCircleController {

    static int radius = 200
    static int cx = radius
    static int cy = radius

    def index(MultiplicationCircleModel circleModel) {
        circleModel.lines = []

        // TODO: Compute the model, the data you need on client side to be displayed. To simplify, start with table base 2.
        for (int i = 0; i < circleModel.segmentCount; i++){
            double x1 = xValueOf(i, circleModel.segmentCount)
            double y1 = yValueOf(i, circleModel.segmentCount)
            double x2 = xValueOf(i * 2, circleModel.segmentCount)
            double y2 = yValueOf(i * 2, circleModel.segmentCount)
            def line = new Line(x1: x1, y1: y1, x2: x2, y2: y2)
            circleModel.lines.add(line)
        }

        render view: "show", model: [circleInstance: circleModel]
    }

    private static double arc(int segment, int segmentCount) {
        2 * Math.PI * segment / segmentCount
    }

    def xValueOf(int segment, int segmentCount) {
        return cx + Math.cos(arc(segment, segmentCount)) * radius
    }

    def yValueOf(int segment, int segmentCount) {
        return cy + Math.sin(arc(segment, segmentCount)) * radius
    }
}

class MultiplicationCircleModel {

    List<Line> lines = Collections.EMPTY_LIST
    int segmentCount = 10

    // TODO: Add a property tableBase such that we can modify and refer to it
    int tableCount = 2

}

class Line {
    double x1, y1, x2, y2
}
