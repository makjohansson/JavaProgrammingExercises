package mj223vn_assign1;
/**
 * A program creating a very ugly Pie Chart using xChart 
 */
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

public class ThePieChart implements MyPieChart<PieChart> {
	public static void main(String[] args) throws FileNotFoundException {
		 
	    MyPieChart<PieChart> theChart = new ThePieChart();
	    PieChart chart = theChart.getChart();
	    new SwingWrapper<PieChart>(chart).displayChart();
	  }
	 
	  public PieChart getChart() throws FileNotFoundException {
			File inputFile = new File("heltal.txt");
			Scanner reader = new Scanner(inputFile);
			int[] inInterval = new int[10];
			int outOfBoundsCounter = 0;
			int inIntervallCounter = 0;
			while(reader.hasNext()) {
				
				int integer = reader.nextInt();
				if(integer >0 && integer < 101) {
					int temp = (integer/10)%10;
					inInterval[temp]++;	
					inIntervallCounter++;
				}
				else {
					outOfBoundsCounter++;
				}
			}
			System.out.println(inIntervallCounter);
			reader.close();
			 

		    PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
		    chart.setTitle("Histogram");
		 
	
		    Color background = new Color(255,0,0);
		    Color[] sliceColors = new Color[] { new Color(0, 0, 191), new Color(51, 102, 0), new Color(255, 0, 0), new Color(0, 255,0 ), new Color(0, 200, 182),
		    		new Color(219, 0, 191), new Color(51,36, 54), new Color(255, 54, 12), new Color(100, 255,40 ), new Color(10, 100, 14), new Color(10, 150, 50)};
		    chart.getStyler().setSeriesColors(sliceColors);
		    chart.getStyler().setChartBackgroundColor(background)
		   ;
		 
		    // Series
		    chart.addSeries("Percent integers 1-10", inInterval[0]);
		    chart.addSeries("Percent integers 11-20", inInterval[1]);
		    chart.addSeries("Percent integers 21-30", inInterval[2]);
		    chart.addSeries("Percent integers 31-40", inInterval[3]);
		    chart.addSeries("Percent integers 41-50", inInterval[4]);
		    chart.addSeries("Percent integers 51-60", inInterval[5]);
		    chart.addSeries("Percent integers 61-70", inInterval[6]);
		    chart.addSeries("Percent integers 71-80", inInterval[7]);
		    chart.addSeries("Percent integers 81-90", inInterval[8]);
		    chart.addSeries("Percent integers 91-100", inInterval[9]);
		    chart.addSeries("Out of bounds ", outOfBoundsCounter);
		    return chart;
	  }
}
