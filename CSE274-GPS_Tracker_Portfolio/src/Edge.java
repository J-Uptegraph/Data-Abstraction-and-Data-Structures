import java.awt.*;
import java.util.ArrayList;


public class Edge {
	// toSymbol/toSymbol/timeCost/distCost
	public Vertex fromVertex;
	public Vertex toVertex;
	public int timeCost;
	public int distCost;
	public int leastAmountOfStops;
	public Color currentPath;
	
	public enum enuEdgeState {
		SHORTEST_DISTANCE,
		SHORTEST_TIME,
		LEAST_AMOUNT_OF_STOPS,
		SHORTEST_DISTANCE_SHORTEST_TIME,
		SHORTEST_TIME_LEAST_AMOUNT_OF_STOPS,
		LEAST_AMOUNT_OF_STOPS_SHORTEST_DISTANCE,
		UNSELECTED
	}
	public enuEdgeState state = enuEdgeState.UNSELECTED;

	public Edge(Vertex fromVertex, Vertex toVertex, int timeCost, int distCost, int leastAmountOfStops) {
		super();
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
		this.timeCost = timeCost;
		this.distCost = distCost;
		this.leastAmountOfStops = leastAmountOfStops;
	}
	
	@Override
	public String toString() {
		// Should eventually say miles and minutes as a potential conversion
		return String.format("%s -> %s \t %s -> %s \t \t \t \t [Trip Details]:   Miles -> %s \t Minutes -> %d \t Stoplights -> %d",
				fromVertex,
				fromVertex.symbol,
				toVertex,
				toVertex.symbol,
//				Graph.useDistCost ? distCost : timeCost,
//				Graph.useDistCost ? "miles" : "minutes");
				distCost, leastAmountOfStops, timeCost);
	}

	
	public void draw(Graphics g) {
		// Consider drawing a path that is "VERIFIED OR VALID" IN A DIFFERENT COLOR/COLORS?

																					// Least Amount of Stops = Red
		if(state == enuEdgeState.LEAST_AMOUNT_OF_STOPS)								g.setColor(Color.RED);
																					// Shortest Distance = Blue
		else if(state == enuEdgeState.SHORTEST_DISTANCE)							g.setColor(Color.BLUE);
																					// Shortest Time = Green
		else if(state == enuEdgeState.SHORTEST_TIME) 								g.setColor(Color.GREEN);
																					// Shortest Distance and Shortest Time = Yellow
		else if (state == enuEdgeState.SHORTEST_DISTANCE_SHORTEST_TIME)				g.setColor(Color.YELLOW);
																					// Shortest Time and Least Amount of Stops
		else if (state == enuEdgeState.SHORTEST_TIME_LEAST_AMOUNT_OF_STOPS)			g.setColor(new Color(102, 51, 0));
																					// Least Amount of Stops and Shortest Distance
		else if (state == enuEdgeState.LEAST_AMOUNT_OF_STOPS_SHORTEST_DISTANCE) 	g.setColor(new Color(102, 0, 153));
																					// UNSELECTED
		// Sets the color of the lines
		else 																		g.setColor(Color.BLACK);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		// "off" is our offset
		int off = fromVertex.width/2;
		g2.drawLine(fromVertex.x+off, fromVertex.y+off, toVertex.x+off, toVertex.y+off);
		fromVertex.draw(g2);
		toVertex.draw(g2);
	}
}
