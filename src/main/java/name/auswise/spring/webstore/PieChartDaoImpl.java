package name.auswise.spring.webstore;

import java.util.List;

import org.springframework.stereotype.Component;

import name.auswise.spring.webstore.PieChartData.KeyValue;

@Component
public class PieChartDaoImpl implements PieChartDao {
 
    @Override
    public List<KeyValue> getPieChartData() {
        return PieChartData.getPieDataList();
    }
 
}