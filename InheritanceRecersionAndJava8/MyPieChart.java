package mj223vn_assign1;
/**
 * Interface for PieChart.
 */
import java.io.FileNotFoundException;
import org.knowm.xchart.internal.chartpart.Chart;

public interface MyPieChart<C extends Chart<?, ?>> {

   C getChart() throws FileNotFoundException;
}
