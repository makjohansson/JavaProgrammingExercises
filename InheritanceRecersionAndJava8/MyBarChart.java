package mj223vn_assign1;

import java.io.FileNotFoundException;
import org.knowm.xchart.internal.chartpart.Chart;

public interface MyBarChart <C extends Chart<?, ?>>{
	 
	C getChart() throws FileNotFoundException;
}
