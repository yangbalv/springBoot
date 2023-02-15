package com.springboot.live_comm.services.excels;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class AddressExecute {


    public static void main(String[] args) throws IOException, InvalidFormatException {
        String filePath = "D:\\ZTY\\aa.xlsx";
        AddressExecute addressExecute = new AddressExecute();
        List<Address> addressList = addressExecute.listAll(filePath);
        Map<Integer, Address> all = new HashMap<>();
        System.out.println("初始数量: " + addressList.size());
//        街道推入区
        for (Address address : addressList) {
            if (address.type.equals(AddressTypeEnum.JIEDAO.getType())) {
                if (null != all.get(address.getFid())) {
                    all.get(address.getFid()).getChildren().add(address);

                } else {
                    System.out.println("街道找不到区：" + address);
                }
            } else {
                all.put(address.getId(), address);
            }
        }
        System.out.println("街道推入区 剩余数量: " + all.size());
        Set<Integer> set = all.keySet();
//        区推入市
        for (Address address : addressList) {
            if (address.type.equals(AddressTypeEnum.QU.getType())) {
                if (null != all.get(address.getId())) {
                    all.get(address.getFid()).getChildren().add(address);
                    all.remove(address.getId());
                    set.remove(address.getId());
                } else {
                    System.out.println("区找不到市：" + address);
                }
            }
        }

        System.out.println("区推入市 剩余数量: " + all.size());

        for (Address address : addressList) {
            if (address.type.equals(AddressTypeEnum.SHI.getType())) {
                if (null != all.get(address.getId())) {
                    all.get(address.getFid()).getChildren().add(address);
                    all.remove(address.getId());
                    set.remove(address.getId());
                } else {
                    System.out.println("市找不到省：" + address);
                }
            }
        }
        System.out.println("剩余数量: " + all.size());

        try (Writer writer = new FileWriter("D:\\ZTY\\test.txt", false)) {
            for (Map.Entry<Integer, Address> integerAddressEntry : all.entrySet()) {
                writer.write(integerAddressEntry.getValue().toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public List<Address> listAll(String filePath) throws IOException, InvalidFormatException {
        List<Address> addressList = new ArrayList<>();
        File excel = new File(filePath);
        //判断文件是否存在
        if (excel.isFile() && excel.exists()) {
//            获取文件后缀名
            String fileType = filePath.substring(filePath.lastIndexOf('.') + 1);
            Workbook wb;
            //根据文件后缀（xls/xlsx）进行判断
            if ("xls".equals(fileType)) {
                FileInputStream fis = new FileInputStream(excel);   //文件流对象
                wb = new HSSFWorkbook(fis);
            } else if ("xlsx".equals(fileType)) {
                wb = new XSSFWorkbook(excel);
            } else {
                System.out.println("文件类型错误!");
                return null;
            }
            Sheet sheet = wb.getSheetAt(0);     //读取sheet 0
            int firstRowIndex = sheet.getFirstRowNum() + 1;   //第一行是列名，所以不读
            int lastRowIndex = sheet.getLastRowNum();
            System.out.println("firstRowIndex: " + firstRowIndex);
            System.out.println("lastRowIndex: " + lastRowIndex);

            for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                Row row = sheet.getRow(rIndex);
                if (row != null) {
                    Cell cell0 = row.getCell(0);
                    Cell cell1 = row.getCell(1);
                    Cell cell2 = row.getCell(2);
                    Cell cell3 = row.getCell(3);

                    Integer id = Integer.parseInt(getCellValueByCell(cell0));
                    Integer fid = Integer.parseInt(getCellValueByCell(cell1));
                    String name = cell2.toString();
                    Integer type = Integer.parseInt(getCellValueByCell(cell3));
                    Address address = new Address();
                    address.setId(id);
                    address.setFid(fid);
                    address.setName(name);
                    address.setType(type);
                    if (fid > id) {
                        System.out.println(address);
                    }
                    addressList.add(address);
                }
            }
        }

        return addressList;
    }


    public static void doExecute(String url) {

        //excel文件路径
        String excelPath = url;

        try {
            //String encoding = "GBK";
            File excel = new File(excelPath);
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;
                //根据文件后缀（xls/xlsx）进行判断
                if ("xls".equals(split[1])) {
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                } else if ("xlsx".equals(split[1])) {
                    wb = new XSSFWorkbook(excel);
                } else {
                    System.out.println("文件类型错误!");
                    return;
                }

                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum() + 1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                System.out.println("firstRowIndex: " + firstRowIndex);
                System.out.println("lastRowIndex: " + lastRowIndex);

                for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);
                            if (cell != null) {
                                System.out.println(cell.toString());
                            }
                        }
                    }
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static class Address {
        private Integer id;
        private Integer fid;
        private String name;
        private Integer type;
        private List<Address> children = new ArrayList<>();

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getFid() {
            return fid;
        }

        public void setFid(Integer fid) {
            this.fid = fid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public List<Address> getChildren() {
            return children;
        }

        public void setChildren(List<Address> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            switch (type) {
                case 1001:
                    return "\n" + "\"" + name + "\"" + ": " + children;
                case 1002:
                    return "\n    " + "\"" + name + "\"" + ": " + children;
                case 1003:
                    if (children.size() > 0) {
                        return "\n       " + "\"" + name + "\"" + ": " + children;
                    } else {
                        return "\"" + name + "\"";
                    }
                default:
                    return "\"" + name + "\"";
            }

        }
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
