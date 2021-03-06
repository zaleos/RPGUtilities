package server;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PaneMapServer extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<MapTile> mapTiles;
	private int width;
	private int height;
	
	public PaneMapServer(){
		width=10;
		height=7;
		setLayout(new GridLayout(height, width));
		mapTiles=new ArrayList<MapTile>();
		for (int i=0;i<width*height;i++){
			mapTiles.add(new MapTile());
			add(mapTiles.get(i));
		}
	}
	
	public String getMapTiles(){
		StringBuilder output=new StringBuilder(mapTiles.get(0).getIntValue()+"");
		for (int i=1; i<width*height;i++){
			output.append(", "+mapTiles.get(i).getIntValue());
		}
		return output.toString();
	}
}
