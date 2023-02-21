package com.springboot.live_comm.utils.excel;


import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Service
public class CityConfigServiceImpl {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public UploadCityConfigResponseDto uploadAllCityConfig(Workbook workbook) {
        logger.info("start uploadAllCityConfig");
        UploadCityConfigResponseDto uploadCityConfigResponseDto = new UploadCityConfigResponseDto();

        Sheet sheet = workbook.getSheetAt(0);     //读取sheet 0
        int firstRowIndex = sheet.getFirstRowNum() + 1;   //第一行是列名，所以不读
        int lastRowIndex = sheet.getLastRowNum();
        logger.info("firstRowIndex: " + firstRowIndex);
        logger.info("lastRowIndex: " + lastRowIndex);
        List<CityConfig> cityConfigList = new ArrayList<>();
//        判断文件是否规范：
        Row correctFileRow = sheet.getRow(sheet.getFirstRowNum());
        Cell correctFileCell0 = correctFileRow.getCell(0);
        Cell correctFileCell1 = correctFileRow.getCell(1);
        Cell correctFileCell2 = correctFileRow.getCell(2);
        Cell correctFileCell3 = correctFileRow.getCell(3);
        String correctFileCityId = correctFileCell0.toString();
        String correctFileParentId = correctFileCell1.toString();
        String correctFileName = correctFileCell2.toString();
        String correctFileType = correctFileCell3.toString();
        logger.info("correctFileCityId is: {}, correctFileParentId is: {}, correctFileName is: {}, correctFileType is: {}", correctFileCityId, correctFileParentId, correctFileName, correctFileType);
        if (!correctFileCityId.equals("id") || !correctFileParentId.equals("父级ID") || !correctFileName.equals("名称") || !correctFileType.equals("类型")) {
            uploadCityConfigResponseDto.setResult(false);
            uploadCityConfigResponseDto.setResultMsg("文件格式不正确");
            return uploadCityConfigResponseDto;
        }


        for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
            Row row = sheet.getRow(rIndex);
            if (row != null) {
                Cell cell0 = row.getCell(0);
                Cell cell1 = row.getCell(1);
                Cell cell2 = row.getCell(2);
                Cell cell3 = row.getCell(3);

                String cityId = getCellValueByCell(cell0);
                String parentId = getCellValueByCell(cell1);
                String name = getCellValueByCell(cell2);
                String type = getCellValueByCell(cell3);
//                String id = IdGeneratedUtil.generateId();
                CityConfig cityConfig = new CityConfig();
                cityConfig.setId(cityId);
//                cityConfig.setCityId(cityId);
                cityConfig.setParentId(parentId);
                cityConfig.setName(name);
                cityConfig.setType(type);

                cityConfigList.add(cityConfig);
//                cityConfigDao.insert(cityConfig);
            }

        }

        logger.info("start uploadAllCityConfig");
        return uploadCityConfigResponseDto;
    }


    public UploadCityConfigResponseDto smartUploadAllCityConfig(Workbook workbook) {
        logger.info("start uploadAllCityConfig");
        UploadCityConfigResponseDto uploadCityConfigResponseDto = new UploadCityConfigResponseDto();

        Sheet sheet = workbook.getSheetAt(0);     //读取sheet 0
        int firstRowIndex = sheet.getFirstRowNum() + 1;   //第一行是列名，所以不读
        int lastRowIndex = sheet.getLastRowNum();
        logger.info("firstRowIndex: " + firstRowIndex);
        logger.info("lastRowIndex: " + lastRowIndex);
        List<CityConfig> cityConfigList = new ArrayList<>();
//        判断文件是否规范：
        Row correctFileRow = sheet.getRow(sheet.getFirstRowNum());
        Cell correctFileCell0 = correctFileRow.getCell(0);
        Cell correctFileCell1 = correctFileRow.getCell(1);
        Cell correctFileCell2 = correctFileRow.getCell(2);
        Cell correctFileCell3 = correctFileRow.getCell(3);
        String correctFileCityId = correctFileCell0.toString();
        String correctFileParentId = correctFileCell1.toString();
        String correctFileName = correctFileCell2.toString();
        String correctFileType = correctFileCell3.toString();
        logger.info("correctFileCityId is: {}, correctFileParentId is: {}, correctFileName is: {}, correctFileType is: {}", correctFileCityId, correctFileParentId, correctFileName, correctFileType);
        if (!correctFileCityId.equals("id") || !correctFileParentId.equals("父级ID") || !correctFileName.equals("名称") || !correctFileType.equals("类型")) {
            uploadCityConfigResponseDto.setResult(false);
            uploadCityConfigResponseDto.setResultMsg("文件格式不正确");
            return uploadCityConfigResponseDto;
        } else {

        }


        for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行

            Row row = sheet.getRow(rIndex);
            if (row != null) {
                Cell cell0 = row.getCell(0);
                Cell cell1 = row.getCell(1);
                Cell cell2 = row.getCell(2);
                Cell cell3 = row.getCell(3);

                String cityId = getCellValueByCell(cell0);
                if (!StringUtils.isBlank(cityId)) {
                    String parentId = getCellValueByCell(cell1);
                    String name = getCellValueByCell(cell2);
                    String type = getCellValueByCell(cell3);
                    CityConfig cityConfig = new CityConfig();
                    cityConfig.setId(cityId);
                    cityConfig.setParentId(parentId);
                    cityConfig.setName(name);
                    cityConfig.setType(type);
                    cityConfigList.add(cityConfig);
                    if (cityConfigList.size() % 100 == 0) {

                        cityConfigList.clear();
                        cityConfigList = new ArrayList<>();
                    }
                }


            }


        }
        if (null != cityConfigList && 0 != cityConfigList.size()) {

            cityConfigList.clear();
        }
        logger.info("start uploadAllCityConfig");
        return uploadCityConfigResponseDto;
    }

    //获取单元格各类型值，返回字符串类型
    public static String getCellValueByCell(Cell cell) {
        //判断是否为null或空串
        if (cell == null || cell.toString().trim().equals("")) {
            return "";
        }
        String cellValue = "";
        int cellType = cell.getCellType();
        switch (cellType) {
            case Cell.CELL_TYPE_NUMERIC: // 数字
                short format = cell.getCellStyle().getDataFormat();
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = null;
                    //System.out.println("cell.getCellStyle().getDataFormat()="+cell.getCellStyle().getDataFormat());
                    if (format == 20 || format == 32) {
                        sdf = new SimpleDateFormat("HH:mm");
                    } else if (format == 14 || format == 31 || format == 57 || format == 58) {
                        // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                        double value = cell.getNumericCellValue();
                        Date date = org.apache.poi.ss.usermodel.DateUtil
                                .getJavaDate(value);
                        cellValue = sdf.format(date);
                    } else {// 日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    }
                    try {
                        cellValue = sdf.format(cell.getDateCellValue());// 日期
                    } catch (Exception e) {
                        try {
                            throw new Exception("exception on get date data !".concat(e.toString()));
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } finally {
                        sdf = null;
                    }
                } else {
                    BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
                    cellValue = bd.toPlainString();// 数值 这种用BigDecimal包装再获取plainString，可以防止获取到科学计数值
                }
                break;
            case Cell.CELL_TYPE_STRING: // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                cellValue = cell.getBooleanCellValue() + "";
                ;
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式
                cellValue = cell.getCellFormula();
                break;
            case Cell.CELL_TYPE_BLANK: // 空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: // 故障
                cellValue = "ERROR VALUE";
                break;
            default:
                cellValue = "UNKNOW VALUE";
                break;
        }
        return cellValue;
    }

}
