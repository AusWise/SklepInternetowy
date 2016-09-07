package name.auswise.spring.webstore;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.auswise.spring.webstore.PieChartData.KeyValue;

@Service
public class PieChartServiceImpl implements PieChartService {
 
    @Autowired
    private PieChartDao pieChartDao;
 
    public void setPieChartDao(PieChartDao pieChartDao) {
        this.pieChartDao = pieChartDao;
    }
    
    @Override
    public List<KeyValue> getPieChartData() {
        return pieChartDao.getPieChartData();
    }
 
}