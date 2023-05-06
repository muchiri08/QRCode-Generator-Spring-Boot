package com.muchiri.qrcodegenerator.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.muchiri.qrcodegenerator.entity.Product;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    public static void GenerateQRCode(Product product) throws WriterException, IOException {
        String qrCodesPath = "/home/muchiri/projects-workspace/QRCodeGenerator/QRCodes/";
        String qrCodeName = qrCodesPath+product.getName()+"-"+product.getProductId()+"-QRCODE.png";
        String detailShown = "ID: "+product.getProductId()+"\n"+"Name: "+product.getName()+"\n"+"Cost: "+product.getCost();

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(detailShown, BarcodeFormat.QR_CODE, 350, 350);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
