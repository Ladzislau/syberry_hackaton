package com.team.syberry.util;

import com.team.syberry.domain.nationalbank.RateShortNationalBank;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class ChartUtil {

    public DefaultCategoryDataset createDatasetFromRateShortNationalBankList(List<RateShortNationalBank> rateList, String currencyCode){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int limit = Math.min(rateList.size(), 5);
        for (int i = 0; i < limit; i++) {
            RateShortNationalBank rate = rateList.get(i);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDateTime date = rate.getDate();
            dataset.addValue(rate.getCurOfficialRate(), currencyCode, date.format(formatter));
        }

        return dataset;
    }

    public JFreeChart createChart(CategoryDataset dataset) {
        return ChartFactory.createBarChart(
                "Sample Chart",
                "Category",
                "Value",
                dataset
        );
    }

    public byte[] generateChartImage(JFreeChart chart) {
        BufferedImage image = chart.createBufferedImage(400, 300);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

}
