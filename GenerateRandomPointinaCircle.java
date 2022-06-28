class Solution {

    double radius;
    double x_center;
    double y_center;
    
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double co[] = new double[2];
        double theta = 2*Math.PI*Math.random(); // between [0, 2pi]
        double randRadius = Math.sqrt(Math.random())*radius;  // Math.sqrt for getting uniform random points
        co[0] = x_center + randRadius*Math.cos(theta); // X = a + r*cos(theta), converting parametric to cartesian co-ordinates
        co[1] = y_center + randRadius*Math.sin(theta);
        return co;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
