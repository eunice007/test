package com.taikang.demo.core.utils;

import com.taikang.demo.core.common.annotation.ForExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Eunice
 * @date 2018/8/13
 */
public class ExcelUploadUtil {
    public static <T> List<T> upLoadExcel(MultipartFile file, Class<?> clazz, Integer limit) throws Exception {
        if (file == null) {
            return null;
        }
        // 判断文件后缀名是否为xls
        String fileName = file.getOriginalFilename();
        String subStr = fileName.substring(fileName.lastIndexOf('.'));
        Workbook wb = null;
        List<T> list = new ArrayList<>();
        if (subStr.equals(".xls")) {
            wb = new HSSFWorkbook(file.getInputStream());
        } else if (subStr.equals(".xlsx")) {
            wb = new XSSFWorkbook(file.getInputStream());
        }
        if (wb != null) {

            //获取实体类定义的字段
            Field[] fields = clazz.getDeclaredFields();
            // 将有forExcel注解的字段存入map排序
            TreeMap<Integer, Field> fieldsMap = new TreeMap<>();
            Map<String, Method> methods = new HashMap<>();
            for (Field field : fields) {
                boolean annotationPresent = field.isAnnotationPresent(ForExcel.class);
                if (annotationPresent) {
                    field.setAccessible(true);
                    ForExcel info = field.getAnnotation(ForExcel.class);
                    int order = info.order();
                    fieldsMap.put(order, field);
                    //获取字段对应的set方法
                    Method method = getSetMethod(field.getName(), clazz, field.getType());
                    methods.put(field.getName(), method);
                }
            }
            // 默认获取第0个sheet
            Sheet sheet = wb.getSheetAt(0);
            //excel的行数
            int rowNum = sheet.getLastRowNum();
            if (limit != null && rowNum > limit) {
                //超过一次导入最大行数限制
                return null;
            }

            for(int i=1; i<rowNum+1; i++){
                Row row = sheet.getRow(i);
                //新建对象
                T o = (T) clazz.newInstance();
                for (Map.Entry<Integer, Field> entry:
                     fieldsMap.entrySet()) {
                    Field field = entry.getValue();
                    Method method = methods.get(field.getName());
                    Cell cell = row.getCell(entry.getKey());
                    String cellValue = getCellValue(cell);
                    setFieldData(cellValue, field, method, o);
                }
            }

            /*Set<Integer> keySet = fieldsMap.keySet();
            for (int i = 1; i < rowNum+1; i++) {
                Row row = sheet.getRow(i);
                //新建对象
                T o = (T) clazz.newInstance();
                for (Integer key : keySet) {
                    Field field = fieldsMap.get(key);
                    Method set = methods.get( field.getName() );
                    Cell cell = row.getCell(key);
                    String data = getCellValue( cell );
                    setFieldData( data,field,set,o );
                }
                list.add(o);
            }*/

        }
        return list;
    }
    private static void setFieldData( String data,Field field,Method set,Object o ) throws Exception{
        Class fieldType = field.getType();
        if(  fieldType.equals( String.class ) ){
            set.invoke( o,data );
        } else if ( fieldType.equals( int.class ) || fieldType.equals( Integer.class) ){
            set.invoke( o,Integer.parseInt( data ) );
        } else if ( fieldType.equals( double.class ) || fieldType.equals( Double.class ) ){
            set.invoke( o,Double.parseDouble( data ) );
        } else if ( fieldType.equals( Date.class )){
            Date date = DateUtil.getDeclaredDate( Integer.parseInt( data ));
            set.invoke( o,date );
        }
    }
    /**
     * 获取单元格内容,无论什么类型均返回string
     * @param cell
     * @return
     */
    private static String getCellValue(Cell cell) {
        int type = cell.getCellType();
        if( type == cell.CELL_TYPE_NUMERIC ){
            double cellValue = cell.getNumericCellValue();
            long longValue = Math.round( cellValue );
            if( Double.parseDouble(longValue + ".0") == cellValue ){
                return String.valueOf( longValue );
            } else {
                return String.valueOf( cellValue );
            }
        } else if ( type == cell.CELL_TYPE_BLANK || type == cell.CELL_TYPE_ERROR ){
            return "";
        } else if( type == cell.CELL_TYPE_BOOLEAN ) {
            return String.valueOf( cell.getBooleanCellValue() );
        } else {
            return String.valueOf( cell.getStringCellValue() );
        }
    }
    /**
     * 获取字段的set方法
     *
     * @param fieldName
     * @param clazz
     * @return
     * @throws Exception
     */
    private static Method getSetMethod(String fieldName, Class<?> clazz, Class<?> fieldClass) throws Exception {
        String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        return clazz.getMethod(methodName, fieldClass);
    }

    /**
     * 获取字段的get方法
     *
     * @param fieldName
     * @param clazz
     * @return
     * @throws Exception
     */
    private static Method getGetMethod(String fieldName, Class<?> clazz, Class<?> fieldClass) throws Exception {
        String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        return clazz.getMethod(methodName, fieldClass);
    }
}
