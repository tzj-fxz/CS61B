public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet other) {
        double dx = xxPos - other.xxPos;
        double dy = yyPos - other.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet other) {
        double dist = calcDistance(other);
        return G * mass * other.mass / (dist * dist);
    }

    public double calcForceExertedByX(Planet other) {
        double dx = other.xxPos - xxPos;
        return calcForceExertedBy(other) * dx / calcDistance(other);
    }
    public double calcForceExertedByY(Planet other) {
        double dy = other.yyPos - yyPos;
        return calcForceExertedBy(other) * dy / calcDistance(other);
    }

    public double calcNetForceExertedByX(Planet[] others) {
        double totalFx = 0;
        for (Planet p: others) {
            if (!this.equals(p)) {
                totalFx += calcForceExertedByX(p);
            }
        }
        return totalFx;
    }
    public double calcNetForceExertedByY(Planet[] others) {
        double totalFy = 0;
        for (Planet p: others) {
            if (!this.equals(p)) {
                totalFy += calcForceExertedByY(p);
            }
        }
        return totalFy;
    }

    public void update(double dt, double fX, double fY) {
        xxVel += fX / mass * dt;
        yyVel += fY / mass * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
}
