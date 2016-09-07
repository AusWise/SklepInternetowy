package name.auswise.spring.webstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import name.auswise.spring.webstore.PieChartData.KeyValue;
 
@Controller
@RequestMapping("/piechart")
public class PieChartController {
 
    @Autowired
    private PieChartService pieChartService;
 
    @RequestMapping(method = RequestMethod.GET)
    public String springMVC(ModelMap modelMap) {
        List<KeyValue> pieDataList = pieChartService.getPieChartData();
        modelMap.addAttribute("pieDataList", pieDataList);
        return "spring";
    }
 
}