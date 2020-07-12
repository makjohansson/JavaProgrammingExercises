package mj223vn_assign1;
/**
 * A program creating a bar chart using xChart
 * @author Marcus
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.LegendPosition;

public class BarChart implements MyBarChart<CategoryChart>{
	
	public static void main(String[] args) throws FileNotFoundException {
		
		MyBarChart<CategoryChart> myBarChart = new BarChart();
		CategoryChart barChart = myBarChart.getChart();
		new SwingWrapper<CategoryChart>(barChart).displayChart();
		
	}
	 public CategoryChart getChart() throws FileNotFoundException {
		 File inputFile = new File("heltal.txt");
			Scanner reader = new Scanner(inputFile);
			int[] inInterval = new int[10];
			int[] span = {10,20,30,40,50,60,70,80,90,100};
			int[] out = {101};
			
			int outOfBoundsCounter= 0;
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
			int[] numOut = {outOfBoundsCounter};
			System.out.println(inIntervallCounter);
			System.out.println(outOfBoundsCounter);
			
			reader.close();
		 
		 CategoryChart barChart = new CategoryChartBuilder().width(800).height(600).title("Histogram").xAxisTitle("Integer interval")
				 .yAxisTitle("Number of integers").build();
		 barChart.getStyler().setLegendPosition(LegendPosition.InsideN);
		 barChart.getStyler().setHasAnnotations(true);
		 
		
		 barChart.addSeries("Number of integers in interval 1 - 100", span, inInterval);
		 barChart.addSeries("Out of bounds", out, numOut);
		 
		 return barChart;
	 }

}
