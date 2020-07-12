package mj223vn_assign1;
/**
 * A program graphing a Sin Curve using xChart.
 */
import java.util.ArrayList;
import java.util.List;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
public class SinMain {
	public static void main(String[] args) throws Exception {
		final double RANGE = 2 * Math.PI;
		final double PI = Math.PI;
		
		 
	    List<Double> xData = new ArrayList<Double>();
	    List<Double> yData = new ArrayList<Double>();
	    for (double x = 0; x <= 2 * RANGE; x = x + 0.01) {
	      double radians = (1 + x/PI)*Math.cos(x)*Math.cos(40*x);
	      xData.add(x);
	      yData.add(radians);
	    }
		
	    final XYChart chart = QuickChart.getChart("Sin Curve", "Radians", "Sine", "sine", xData, yData);
	 

	    final SwingWrapper<XYChart> sw = new SwingWrapper<XYChart>(chart);
	    sw.displayChart();
	  }

}
