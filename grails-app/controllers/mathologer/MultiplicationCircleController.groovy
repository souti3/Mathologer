package mathologer

class MultiplicationCircleController {

    static int radius = 200
    static int cx = radius
    static int cy = radius

    def index(MultiplicationCircleModel circleModel) {

        // TODO: Compute the model, the data you need on client side to be displayed. To simplify, start with table base 2.

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

    List lines = []
    int segmentCount = 10

    // TODO: Add a property tableBase such that we can modify and refer to it

}
