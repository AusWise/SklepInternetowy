package name.auswise.spring.webstore;

import java.util.List;

import name.auswise.spring.webstore.PieChartData.KeyValue;

public interface PieChartService {
 
    List<KeyValue> getPieChartData();
 
}