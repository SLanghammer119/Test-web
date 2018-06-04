/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.servlet;

import com.bumblebee.ctrl.OrderCtrl;
import com.bumblebee.model.Customer;
import com.bumblebee.model.Orderitem;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stefanie Langhammer
 */
@WebServlet(name = "orderPdf", urlPatterns = "/generate/orderPdf.pdf")
public class OrderPdfServlet extends HttpServlet {

    @Inject
    OrderCtrl orderCtrl;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Document doc = new Document();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            resp.setContentType("application/pdf");

            HttpSession sess = req.getSession();
            if (orderCtrl.getOrder().getOrderitems().size() > 0) {

                Customer customer = orderCtrl.getOrder().getCustomer();

                PdfWriter.getInstance(doc, bos);

                Font larger = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 30, BaseColor.GRAY);
                Font large = FontFactory.getFont(FontFactory.HELVETICA, 13);
                Font middle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);

                doc.open();

                doc.add(new Paragraph("Der Pizzaservice \n", larger));
                doc.add(new Paragraph("Nur bei uns - Pizza aus dem originalen Steinofen!", large));

                doc.add(Chunk.NEWLINE);
                doc.add(Chunk.NEWLINE);

                doc.add(new Paragraph(customer.getFirstname() + " " + customer.getLastname() + "\n" + customer.getStreet() + " " + customer.getHouseno()+ "\n" + customer.getPostcode() + " " + customer.getTown()));
                doc.add(Chunk.NEWLINE);
                doc.add(Chunk.NEWLINE);

                Image image = Image.getInstance(getServletContext().getRealPath("/resources/img/logo.jpg"));
                image.setAbsolutePosition(340f, 660f);

                doc.add(image);

                doc.add(new Paragraph("Bestellung", larger));
                doc.add(new Paragraph("\n\n"));

                float[] columnWidths = {1, 2, 4, 2, 2, 2};
                PdfPTable table;
                table = new PdfPTable(columnWidths);
                table.addCell("Nr.");
                table.addCell("Gericht");
                table.addCell("Zutaten");
                table.addCell("Einzelpreis");
                table.addCell("Anzahl");
                table.addCell("Gesamt");

                for (Orderitem item : orderCtrl.getOrder().getOrderitems()) {

                    table.addCell("" + item.getArticle().getArticleno());
                    table.addCell(item.getArticle().getName());
                    table.addCell("" + item.getArticle().getPrice() + " €");
                    table.addCell("" + item.getNumber());
                    table.addCell("" + item.getTotalline() + " €");
                }

                doc.add(table);

                doc.add(new Paragraph("                   Gesamtbetrag: " + orderCtrl.getOrder().getTotal() + " €", middle));

                doc.add(Chunk.NEWLINE);
                doc.add(Chunk.NEWLINE);
                doc.add(Chunk.NEWLINE);
                doc.add(Chunk.NEWLINE);

                doc.add(new Paragraph("Vielen Dank für Ihre Bestellung, besuchen Sie uns bald wieder!"));

                doc.close();
                OutputStream os = resp.getOutputStream();
                bos.writeTo(os);
                os.flush();
                os.close();

            } else {
                PdfWriter.getInstance(doc, bos);
                doc.open();

                doc.add(new Paragraph("Session abgelaufen  "));
            }
            doc.close();
            OutputStream os = resp.getOutputStream();
            bos.writeTo(os);
            os.flush();
            os.close();

        } catch (DocumentException ex) {
            Logger.getLogger(OrderPdfServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OrderPdfServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        HttpSession sess = req.getSession();
        sess.invalidate();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        // doGet(req, resp);
    }
}
