import javax.sound.sampled.Line;
import java.util.List;

/**
 * Created by graver_mc on 13.05.2018.
 */
public class LineSegment {

    private Point start;
    private Point end;

    public LineSegment(){
        this.start = new Point();
        this.end = new Point();
    }

    public LineSegment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public LineSegment(int startxCoordinate, int startyCoordinate,int endxCoordinate,int endyCoordinate){
        this.start = new Point(startxCoordinate,startyCoordinate);
        this.end = new Point(endxCoordinate,endyCoordinate);
    }

    public double getLength(){
        double x = Double.parseDouble(String.valueOf(end.getxCoordinate()-start.getxCoordinate()));
        double y = Double.parseDouble(String.valueOf(end.getyCoordinate()-start.getyCoordinate()));
        return Math.sqrt(Math.pow(x,2)+(Math.pow(y,2)));
    }

    public boolean isPerpendicular(LineSegment ln){
        LineSegment temp = new LineSegment(ln.getEnd(),this.getStart());
        if((Math.pow(this.getLength(),2)+(Math.pow(ln.getLength(),2))==Math.pow(temp.getLength(),2))) { return true; }
        else return false;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineSegment that = (LineSegment) o;

        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        return end != null ? end.equals(that.end) : that.end == null;
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return start+" -> "+end;
    }
}
