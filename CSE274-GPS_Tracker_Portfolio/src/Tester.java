import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tester extends JPanel {
	JFrame window = new JFrame("Game Template");
	Timer tmr = null;
	Random rnd = new Random();   
	// sets orientation
	Graph map = new Graph("MapInformation.txt", 50, 25);
	Vertex fromV, toV = null;

	public Tester() {
		window.setBounds(50, 50, 500, 500);
		window.setAlwaysOnTop(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.getContentPane().add(this);
		window.setVisible(true);

		//============================================================ Events
		tmr = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});

		//============================================================ Mouse Pressed
		addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				for(Vertex v : map.vertices.values()) {
					if(v.contains(e.getPoint())) {
						if(fromV  == null) {
							v.state = Vertex.enuState.START;
							fromV = v;
						}
						else if(toV == null) {
							v.state = Vertex.enuState.END;
							toV = v;
							
							// if checkbox (shortest Time Path)
							// if checkbox (shortest Distance Path)
							// if checkbox (least Amount of stops)
							
							String messageDiaglog = "From: " + fromV.symbol + "\nTo: " + toV.symbol;
							if (Dijkstra.shortestPath(map, fromV.symbol, toV.symbol) == null) {
								messageDiaglog += "\nShortest Distance: No path found.";
							} else {
								messageDiaglog += "\nShortest Distance: " + Dijkstra.shortestPath(map, fromV.symbol, toV.symbol).toString();
							}
							if (Dijkstra.shortestTimePath(map, fromV.symbol, toV.symbol) == null) {
								messageDiaglog += "\nShortest Time: No path found.";
							} else {
								messageDiaglog += "\nShortest Time: " + Dijkstra.shortestTimePath(map, fromV.symbol, toV.symbol).toString();
							}
							if (Dijkstra.leastAmountOfStops(map, fromV.symbol, toV.symbol) == null) {
								messageDiaglog += "\nLeast Amount of Stops: No path found.";
							} else {
								messageDiaglog += "\nLeast Amount of Stops: " + Dijkstra.leastAmountOfStops(map, fromV.symbol, toV.symbol).toString();
							}
							JOptionPane.showMessageDialog(window, messageDiaglog);
							// Change the path color:
							ArrayList<Edge> allEdges = Graph.edges;

							// SHORTEST DISTANCE PATH
								String shortestDistancePathString;
								if (Dijkstra.shortestTimePath(map, fromV.symbol, toV.symbol) == null) {
									shortestDistancePathString = "";
								} else {
									shortestDistancePathString = Dijkstra.shortestPath(map, fromV.symbol, toV.symbol).pathStr;
								}
								String[] shortestDistancePathArray = shortestDistancePathString.split("(?!^)");
								for (int i = 0; i < shortestDistancePathArray.length - 1; i++) {
									for (int j = 0; j < allEdges.size(); j++) {
										repaint();
										if (allEdges.get(j).fromVertex.symbol.equals(shortestDistancePathArray[i]) && allEdges.get(j).toVertex.symbol.equals(shortestDistancePathArray[i + 1])) {
											System.out.println(allEdges.get(j).fromVertex.symbol + " -> " + allEdges.get(j).toVertex.symbol + " Edge: " + j);
											allEdges.get(j).state = Edge.enuEdgeState.SHORTEST_DISTANCE;
										}
									}
								}

							// SHORTEST TIME PATH
							String shortestTimePathString;
							if (Dijkstra.shortestTimePath(map, fromV.symbol, toV.symbol) == null) {
								shortestTimePathString = "";
							} else {
								shortestTimePathString = Dijkstra.shortestTimePath(map, fromV.symbol, toV.symbol).pathStr;
							}
							String[] shortestTimePathArray = shortestTimePathString.split("(?!^)");
							for (int i = 0; i < shortestTimePathArray.length - 1; i++) {
								for (int j = 0; j < allEdges.size(); j++) {
									
									if (allEdges.get(j).fromVertex.symbol.equals(shortestTimePathArray[i]) && allEdges.get(j).toVertex.symbol.equals(shortestTimePathArray[i + 1])) {
										System.out.println(allEdges.get(j).fromVertex.symbol + " -> " + allEdges.get(j).toVertex.symbol + " Edge: " + j);
										allEdges.get(j).state = Edge.enuEdgeState.SHORTEST_TIME;
									}
								}
							}

							// LEAST AMOUNT OF STOPS
							String leastAmountofStopsPathString;
							if (Dijkstra.leastAmountOfStops(map, fromV.symbol, toV.symbol) == null) {
								leastAmountofStopsPathString = "";
							} else {
								leastAmountofStopsPathString = Dijkstra.leastAmountOfStops(map, fromV.symbol, toV.symbol).pathStr;
							}
							String[] leastAmountofStopsPathArray = leastAmountofStopsPathString.split("(?!^)");
							for (int i = 0; i < leastAmountofStopsPathArray.length - 1; i++) {
								for (int j = 0; j < allEdges.size(); j++) {
									repaint();
									if (allEdges.get(j).fromVertex.symbol.equals(leastAmountofStopsPathArray[i]) && allEdges.get(j).toVertex.symbol.equals(leastAmountofStopsPathArray[i + 1])) {
										System.out.println(allEdges.get(j).fromVertex.symbol + " -> " + allEdges.get(j).toVertex.symbol + " Edge: " + j);
										allEdges.get(j).state = Edge.enuEdgeState.LEAST_AMOUNT_OF_STOPS;
									}
								}
							}

							// TWO PATHS ARE THE SAME
							if (shortestDistancePathString.equals(shortestTimePathString)) {
								for (int i = 0; i < shortestDistancePathArray.length - 1; i++) {
									for (int j = 0; j < allEdges.size(); j++) {
										repaint();
										if (allEdges.get(j).fromVertex.symbol.equals(shortestDistancePathArray[i]) && allEdges.get(j).toVertex.symbol.equals(shortestDistancePathArray[i + 1])) {
											System.out.println(allEdges.get(j).fromVertex.symbol + " -> " + allEdges.get(j).toVertex.symbol + " Edge: " + j);
											allEdges.get(j).state = Edge.enuEdgeState.SHORTEST_DISTANCE_SHORTEST_TIME;
										}
									}
								}
							}
							if (shortestTimePathString.equals(leastAmountofStopsPathString)) {
								for (int i = 0; i < shortestTimePathArray.length - 1; i++) {
									for (int j = 0; j < allEdges.size(); j++) {
										repaint();
										if (allEdges.get(j).fromVertex.symbol.equals(shortestTimePathArray[i]) && allEdges.get(j).toVertex.symbol.equals(shortestTimePathArray[i + 1])) {
											System.out.println(allEdges.get(j).fromVertex.symbol + " -> " + allEdges.get(j).toVertex.symbol + " Edge: " + j);
											allEdges.get(j).state = Edge.enuEdgeState.SHORTEST_TIME_LEAST_AMOUNT_OF_STOPS;
										}
									}
								}
							}
							if (leastAmountofStopsPathString.equals(shortestDistancePathString)) {
								for (int i = 0; i < leastAmountofStopsPathArray.length - 1; i++) {
									for (int j = 0; j < allEdges.size(); j++) {
										repaint();
										if (allEdges.get(j).fromVertex.symbol.equals(leastAmountofStopsPathArray[i]) && allEdges.get(j).toVertex.symbol.equals(leastAmountofStopsPathArray[i + 1])) {
											System.out.println(allEdges.get(j).fromVertex.symbol + " -> " + allEdges.get(j).toVertex.symbol + " Edge: " + j);
											allEdges.get(j).state = Edge.enuEdgeState.LEAST_AMOUNT_OF_STOPS_SHORTEST_DISTANCE;
										}
									}
								}
							}
						}
						else {
							fromV.state = toV.state = Vertex.enuState.UNSELECTED;
							// Repaints all the edges
							ArrayList<Edge> allEdges = Graph.edges;
							for (int i = 0; i < allEdges.size(); i++) {
								allEdges.get(i).state = Edge.enuEdgeState.UNSELECTED;
							}

							toV = null;
							v.state = Vertex.enuState.START;
							fromV = v;
						}
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		//============================================================ Mouse Moved, Dragged
		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				window.setTitle("");
				for(Vertex v: map.vertices.values())
					if (v.contains(e.getPoint()))
						window.setTitle(v.address);
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				mouseMoved(e);
			}
		});

		//============================================================ Key pressed
		window.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

		});

		tmr.start();
	}

	//============================================================ Drawing
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		map.draw(g);
	}

	//======================================================
	public static void main(String[] args) {
        Graph map = new Graph("MapInformation.txt");        

		new Tester();
		
        Graph.returnAddress = true;
        Graph.useDistCost = false;
        System.out.println("================================================================[Dijkstra's Algorithm]================================================================\n");
        
        System.out.println("                                  								 [Graph Information]                                                                  \n");
        System.out.print(map);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		
//		System.out.println(Dijkstra.shortestPath(map, "B", "B"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "B"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "C"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "D"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "E"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "F"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "map"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "H"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "I"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "J"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "K"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "L"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "M"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "N"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "O"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "P"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "Q"));
//		System.out.println(Dijkstra.shortestPath(map, "B", "T"));
//		
//		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
//		
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "B"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "B"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "C"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "D"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "E"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "F"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "map"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "H"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "I"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "J"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "K"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "L"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "M"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "N"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "O"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "P"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "Q"));
//		System.out.println(Dijkstra.shortestTimePath(map, "B", "T"));
//		
//		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
//		
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "B"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "B"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "C"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "D"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "E"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "F"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "map"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "H"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "I"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "J"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "K"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "L"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "M"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "N"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "O"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "P"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "Q"));
//		System.out.println(Dijkstra.leastAmountOfStops(map, "B", "T"));
	
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("[Dijkstra's Shortest Distance Algorithm]: " );
        System.out.println("[Shortest Time Path]: " + Dijkstra.shortestPath(map, "B" , "S").cost + " miles");
        System.out.println("[From]: " + Dijkstra.pathStr.charAt(0));
        System.out.println("[To]: " + Dijkstra.pathStr.charAt(Dijkstra.pathStr.length()-1));
        System.out.println("[Path]: " + Dijkstra.shortestPath(map, "B" , "S").toString());
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        
        System.out.println("[Dijkstra's Shortest Time Algorithm]: " );
        System.out.println("[Shortest Distance Path]: " + Dijkstra.shortestTimePath(map, "B" , "S").cost + " minutes");
        System.out.println("[From]: " + Dijkstra.pathStr.charAt(0));
        System.out.println("[To]: " + Dijkstra.pathStr.charAt(Dijkstra.pathStr.length()-1));
        System.out.println("[Path]: " + Dijkstra.shortestTimePath(map, "B" , "S").toString());
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        System.out.println("[Dijkstra's Least Amount of Stops Algorithm]: " );
        System.out.println("[Least Amount of Stops Algorithm]: " + Dijkstra.leastAmountOfStops(map, "B" , "S").cost + " stop lights");
        System.out.println("[From]: " + Dijkstra.pathStr.charAt(0));
        System.out.println("[To]: " + Dijkstra.pathStr.charAt(Dijkstra.pathStr.length()-1));
        System.out.println("[Path]: " + Dijkstra.leastAmountOfStops(map, "B" , "S").toString());
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------\n");

    }

}
