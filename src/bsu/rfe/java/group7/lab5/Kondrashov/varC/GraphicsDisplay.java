package bsu.rfe.java.group7.lab5.Kondrashov.varC;

import java.awt.*;
import java.awt.geom.*;
import java.text.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.JPanel;

@SuppressWarnings({ "serial" })
public class GraphicsDisplay extends JPanel {

    class GraphPoint {
        double xd;
        double yd;
        int x;
        int y;
        int n;
    }

    class Zone {
        double MAXY;
        double tmp;
        double MINY;
        double MAXX;
        double MINX;
        boolean use;
    }

    private Zone zone = new Zone();
    private double[][] graphicsData;
    private int[][] graphicsDataI;
    private boolean showAxis = true;
    private boolean showMarkers = true;
    private boolean transform = false;
    private boolean showGrid = true;
    private boolean PPP = false;
    private boolean zoom = false;
    private boolean selMode = false;
    private boolean dragMode = false;
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private double scale;
    private double scaleX;
    private double scaleY;
    private DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();
    private BasicStroke graphicsStroke;
    private BasicStroke gridStroke;
    private BasicStroke hatchStroke;
    private BasicStroke axisStroke;
    private BasicStroke selStroke;
    private BasicStroke markerStroke;
    private Font axisFont;
    private Font captionFont;
    private int mausePX = 0;
    private int mausePY = 0;
    private GraphPoint SMP;
    double xmax;
    private Rectangle2D.Double rect;
    private Stack<Zone> stack = new Stack<Zone>();


    public GraphicsDisplay() {
        setBackground(Color.WHITE);
        graphicsStroke = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, new float[]{8, 2, 2, 2, 4, 2, 2, 2, 8, 2}, 0.0f);
        gridStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, null, 0.0f);
        hatchStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, null, 0.0f);
        axisStroke = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
        markerStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
        selStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[]{8, 8}, 0.0f);
        axisFont = new Font("Serif", Font.BOLD, 20);
        captionFont = new Font("Serif", Font.BOLD, 10);
        MouseMotionHandler mouseMotionHandler = new MouseMotionHandler();
        addMouseMotionListener(mouseMotionHandler);
        addMouseListener(mouseMotionHandler);
        rect = new Rectangle2D.Double();
        zone.use = false;
    }

    public void showGraphics(double[][] graphicsData) {
        this.graphicsData = graphicsData;
        graphicsDataI = new int[graphicsData.length][2];
        repaint();
    }

    public void setShowAxis(boolean showAxis) {
        this.showAxis = showAxis;
        repaint();
    }

    public void setTransform(boolean transform) {
        this.transform = transform;
        repaint();
    }

    public void setShowGrid(boolean showGrid) {
        this.showGrid = showGrid;
        repaint();
    }

    public int getDataLenght() {
        return graphicsData.length;
    }

    public double getValue(int i, int j) {
        return graphicsData[i][j];
    }

    public void setShowMarkers(boolean showMarkers) {
        this.showMarkers = showMarkers;
        repaint();
    }

    
}
