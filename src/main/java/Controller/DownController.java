package Controller;/**
 * Created by pc on 2018/1/25.
 */

import Service.TestService;
import Vo.Test;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/01/25
 */
@Controller
public class DownController {
    @Autowired
    TestService testService;
    @RequestMapping("/down")
    public String down() throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("test");
        XSSFRow row = xssfSheet.createRow(1);
        XSSFCell cell;
        cell = row.createCell(1);
        cell.setCellValue("stuname");
        cell = row.createCell(2);
        cell.setCellValue("stuid");
        cell = row.createCell(3);
        cell.setCellValue("stuclass");
        cell = row.createCell(4);
        cell.setCellValue("mathscore");
        cell = row.createCell(5);
        cell.setCellValue("chinscore");
        cell = row.createCell(6);
        cell.setCellValue("engscore");
        List<Test> list1 = testService.list();
        int i = 0,j = 2;
        while(i<list1.size()){
            Test test = list1.get(i);
            row = xssfSheet.createRow(j);
            cell = row.createCell(1);
            cell.setCellValue(test.getStuname());
            cell = row.createCell(2);
            cell.setCellValue(test.getStuid());
            cell = row.createCell(3);
            cell.setCellValue(test.getStuclass());
            cell = row.createCell(4);
            cell.setCellValue(test.getMathscore());
            cell = row.createCell(5);
            cell.setCellValue(test.getChinscore());
            cell = row.createCell(6);
            cell.setCellValue(test.getEngscore());
            i++;
            j++;
        }
        FileOutputStream out = new FileOutputStream(new File("D://jin1.xlsx"));
        xssfWorkbook.write(out);
        out.close();
        return "/Successful";
    }
}
