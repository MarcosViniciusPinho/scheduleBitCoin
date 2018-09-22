package br.com.cloudseven.bitcoin.stream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Marcos Pinho
 */
public class ExcelBuild {

    public static void build(HttpServletResponse response, String nomeArquivo) {

        File relatorioFile = new File(nomeArquivo);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + nomeArquivo);

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet excelSheet = workbook.createSheet("Variações do BITCOIN");
        setExcelHeader(excelSheet);
        setExcelRows(excelSheet);
        createArquivo(nomeArquivo, workbook);

        download(relatorioFile, response);
    }

    private static void download(File relatorioFile, HttpServletResponse response) {
        try {
            FileInputStream fileInputStream = new FileInputStream(relatorioFile);
            try {
                OutputStream outputStream = response.getOutputStream();
                IOUtils.copyLarge(fileInputStream, outputStream);
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("Erro na criação do arquivo", e);
            } finally {
                IOUtils.closeQuietly(fileInputStream);
            }
            boolean deleteOK = relatorioFile.delete();
            if(!deleteOK){
//                LOGGER.debug("Erro ao deletar o arquivo");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquivo não encontrado", e);
        }
    }

    private static void createArquivo(String nomeArquivo, HSSFWorkbook workbook) {
        try {
            OutputStream arquivoSaida = new FileOutputStream(nomeArquivo);
            try {
                workbook.write(arquivoSaida);
                arquivoSaida.close();
            } catch (IOException e) {
                throw new RuntimeException("Erro na criação do arquivo", e);
            } finally {
                IOUtils.closeQuietly(arquivoSaida);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquivo não encontrado", e);
        }
    }

    private static void setExcelHeader(HSSFSheet excelSheet) {
        HSSFRow excelHeader = excelSheet.createRow(0);
        excelHeader.createCell(0).setCellValue("Coluna 1");
        excelHeader.createCell(1).setCellValue("Coluna 2");
        excelHeader.createCell(2).setCellValue("Coluna 3");
        excelHeader.createCell(3).setCellValue("Coluna 4");
        excelHeader.createCell(4).setCellValue("Coluna 5");
    }

    private static void setExcelRows(HSSFSheet excelSheet){
        int record = 1;
        for (int i = 0; i <= 10; i++) {
            HSSFRow excelRow = excelSheet.createRow(record++);
            excelRow.createCell(0).setCellValue(Math.random());
            excelRow.createCell(1).setCellValue(Math.random());
            excelRow.createCell(2).setCellValue(Math.random());
            excelRow.createCell(3).setCellValue(Math.random());
            excelRow.createCell(4).setCellValue(Math.random());
        }
    }

}